- Handler.post(Runnable runnable)方法是有返回值的，只有在Runnable成功放到messageQueue中以后才会返回True，否则返回false


|Handler|Looper|Thread|MessageQueue|
|:-----:|:----:|:----:|:----------:|
|Looper|Looper|Thread|MessageQueue|

``` 
public Handler(Looper looper) {
    this(looper, null, false);
}
```
    
```
public class UiThreadExecutor implements Executor {

    private final Handler mHandler = new Handler(Looper.getMainLooper());

    private Thread mUiThread = Looper.getMainLooper().getThread();

    @Override
    public void execute(@NonNull Runnable command) {
        if (Thread.currentThread() == mUiThread) {
            // already on main thread, simply execute
            command.run();
        } else {
            mHandler.post(command);
        }
    }
}
```