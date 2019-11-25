package yincheng.tinytank.android_Q_A._1_100._55

import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

fun main() {
    val executorService = Executors.newCachedThreadPool()
    for (i in 0..4)
        executorService.execute(Accessor(i))
    TimeUnit.MILLISECONDS.sleep(10)
    executorService.shutdownNow()
}