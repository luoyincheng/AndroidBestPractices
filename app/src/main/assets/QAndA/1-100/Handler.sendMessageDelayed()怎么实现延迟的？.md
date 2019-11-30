### Handler.sendMessageDelayed()怎么实现延迟的？

以handler.postDelayed()为例：它的调用逻辑是这样的：

```java
public final boolean postDelayed(Runnable r, long delayMillis){
        return sendMessageDelayed(getPostMessage(r), delayMillis);
}
public final boolean sendMessageDelayed(Message msg, long delayMillis){
        if (delayMillis < 0) {
            delayMillis = 0;
        }
        return sendMessageAtTime(msg, SystemClock.uptimeMillis() + delayMillis);
}
public boolean sendMessageAtTime(Message msg, long uptimeMillis) {
        MessageQueue queue = mQueue;
        if (queue == null) {
            RuntimeException e = new RuntimeException(
                    this + " sendMessageAtTime() called with no mQueue");
            Log.w("Looper", e.getMessage(), e);
            return false;
        }
        return enqueueMessage(queue, msg, uptimeMillis);
}
private boolean enqueueMessage(MessageQueue queue, Message msg, long uptimeMillis) {
        msg.target = this;
        if (mAsynchronous) {
            msg.setAsynchronous(true);
        }
        return queue.enqueueMessage(msg, uptimeMillis);
}
```

进入到了MessageQueue的enqueueMessage()方法：

```java
boolean enqueueMessage(Message msg, long when) {
       ...
        synchronized (this) {
            if (mQuitting) {             
                msg.recycle();
                return false;
            }
            msg.markInUse();
            msg.when = when;
            Message p = mMessages;
            boolean needWake;
            if (p == null || when == 0 || when < p.when) {
                msg.next = p;
                mMessages = msg;
                needWake = mBlocked;
            } else {
                needWake = mBlocked && p.target == null && msg.isAsynchronous();
                Message prev;
                for (;;) {
                    prev = p;
                    p = p.next;
                    if (p == null || when < p.when) {
                        break;
                    }
                    if (needWake && p.isAsynchronous()) {
                        needWake = false;
                    }
                }
                msg.next = p; // invariant: p == prev.next
                prev.next = msg;
            }
            if (needWake) {
                nativeWake(mPtr);
            }
        }
        return true;
    }
```

在上面的enqueueMessage()方法中会将延迟的时间when放到msg上，并加入到messageQueue中。我们知道Looper会在不断的进行loop操作，loop()是在一个死循环中不断的从MessageQueue中取message，然后交给handler进行处理消息。此时如果MessageQueue中存在延时的message看看要怎么处理？ 进入queue.next()方法中看看做了什么：

```java
Message next() {
        ...
        for (;;) {
           ...
            nativePollOnce(ptr, nextPollTimeoutMillis);   // native 函数

            synchronized (this) {
                final long now = SystemClock.uptimeMillis();
                Message prevMsg = null;
                Message msg = mMessages;
                ...
                if (msg != null) {
                    if (now < msg.when) {
                        nextPollTimeoutMillis = (int) Math.min(msg.when - now, Integer.MAX_VALUE);
                    } else {
                       ...
                    }
                } else {
                    nextPollTimeoutMillis = -1;
                }              
                ...
            }
            ...
            nextPollTimeoutMillis = 0;
        }
    }
```

可以看到，在这个方法内，如果头部的这个Message是有延迟而且延迟时间没到的（now < msg.when），会计算一下时间（保存为变量nextPollTimeoutMillis），然后在循环开始的时候判断如果这个Message有延迟，就调用nativePollOnce(ptr, nextPollTimeoutMillis)进行阻塞。nativePollOnce()的作用类似与object.wait()，只不过是使用了Native的方法对这个线程精确时间的唤醒。

> postDelay()一个10秒钟的Runnable A、消息进队，MessageQueue调用next()方法中的`nativePollOnce()`阻塞，Looper阻塞；
>
> 紧接着post()一个Runnable B、消息进队，判断现在A时间还没到、正在阻塞，把B插入消息队列的头部（A的前面），然后调用MessageQueue的enqueueMessage()方法中的`nativeWake()`方法唤醒线程；
>
> MessageQueue.next()方法被唤醒后，重新开始读取消息链表，第一个消息B无延时，直接返回给Looper；
>
> Looper处理完这个消息再次调用next()方法，MessageQueue继续读取消息链表，第二个消息A还没到时间，计算一下剩余时间（假如还剩9秒）继续调用`nativePollOnce()`阻塞；直到阻塞时间到或者下一次有Message进队；

https://juejin.im/post/5d5d4c5d6fb9a06ad00573c5 

