package yincheng.tinytank.android_Q_A._1_100._96

fun main() {
    Thread(ProducerAndConsumer.Producer()).start()
    Thread(ProducerAndConsumer.Consumer()).start()
}

class ProducerAndConsumer {

    companion object {
        val LOCK = Object()
        var count = 0
        const val FULL = 10
    }

    class Producer : Runnable {
        override fun run() {
            for (i in 1..200) {
                try {
                    Thread.sleep(1000) //在加锁的情况下在for循环中使用thread.sleep()，相当于每1000ms执行一次任务
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                println("---> ${System.currentTimeMillis()}" )
                synchronized(LOCK) {
                    while (count == FULL) {
                        try {
                            LOCK.wait()
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                    count++
                    println("${Thread.currentThread().name} 生产了$count 个了")
                    LOCK.notifyAll()
                }
            }
        }
    }

    class Consumer : Runnable {
        override fun run() {
            for (i in 1..200) {
                try {
                    Thread.sleep(1500)    //在加锁的情况下在for循环中使用thread.sleep()，相当于每1500ms执行一次任务
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                println("===> ${System.currentTimeMillis()}" )
                synchronized(LOCK) {
                    while (count == 0) {
                        try {
                            LOCK.wait()
                        } catch (e: Exception) {
                        }
                    }
                    count--
                    println("${Thread.currentThread().name} 本次消费后剩余$count 个")
                    LOCK.notifyAll()
                }
            }
        }
    }
}
