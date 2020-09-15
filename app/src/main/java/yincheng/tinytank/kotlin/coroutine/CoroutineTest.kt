package yincheng.tinytank.kotlin.coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.concurrent.atomic.AtomicLong

fun main() {
//    // 协程真的比线程更廉价
//    // 协程的最大优点是它们可以 挂起 而不会阻塞一个线程
//
//    // TODO() 打印的时间不对 挂起？ 阻塞？
//    // 示例1
//    GlobalScope.launch {
//        // launch a new coroutine in background and continue
//        /**
//         * 我们使用了类似 Thread.sleep() 的 delay() 函数，但是它更优异：它 不会阻塞一个线程 ，但是会挂起协程自身。
//         * 当这个协程处于等待状态时该线程会返回线程池中，当等待结束的时候，这个协程会在线程池中的空闲线程上恢复。
//         * 主线程（通过 main() 函数运行的线程）必须等到我们的协程完成，否则程序会在 Hello 被打印之前终止。
//         * 如果我们直接在 main() 中尝试使用诸如 delay() 这样的非阻塞函数，我们将得到一个编译错误：
//         * 挂起函数只被允许在协程或另一个挂起函数中调用
//         * 这是因为我们不在任何协程中。我们可以在 runBlocking {} 包装中使用 delay，它启动了一个协程并等待直到它结束(如示例2)
//         */
//        delay(1000) // non-blocking delay for 1 second (default time unit is ms)
//        println("World! ${System.currentTimeMillis()}") // print after delay
//    }
//    Thread.sleep(2000) // block main thread for 2 seconds to keep JVM alive
//    println("Hello, ${System.currentTimeMillis()}") // main thread continues while coroutine is delayed
//
//    // 示例2
//    runBlocking {
//        delay(2000)
//    }


   // 示例3
   // 启动一百万个协程 瞬间算完 nb啊
   val c = AtomicLong()
   for (i in 1..1_000_000L)
      GlobalScope.launch {
         c.addAndGet(i)
      }
   println(c.get())

//    // 示例4
//    // 从协程中返回一个值
//    val deferred = (1..1_000_000).map { n ->
//        GlobalScope.async {
//            delay(1000) //就算给每个协程增加1秒的运行时间，1000000个协程的总共运行也只有几秒，而不是上百万秒，说明协程实际上是并行运行的
//            n
//        }
//    }
//    /**
//     * 从每个协程等待并取得它的执行结果，接下来将使用标准库的 sumBy() 函数来将所有结果叠加到一起
//     * await() 不能在协程外调用，因为它需要挂起直至计算结束，并且只有协程可以被无阻塞的挂起。因此，让我们将它们放到协程中(用runBlocking包括起来)
//     */
//    runBlocking {
//        val sum = deferred.sumBy { it.await() }
//        println("sum:$sum")
//    }
//
//    // 示例5
//    // 挂起函数
//    /**
//     * <挂起函数只被允许在协程或另一个挂起函数中调用>,因此需要加上suspend讲workLoad函数显式的标注为可挂起
//     */
//    suspend fun workLoad(int: Int): Int {
//        delay(1000) //这是一个挂起函数，需要讲workLoad方法显式的标注为可挂起
//        return int
//    }
//
//    /**
//     * workload() 可以在一个协程中调用（或另一个挂起函数），但是 不能 在协程外调用。自然地，delay() 与 await() 这些我们在上面使用的函数它们自己也被修饰为 suspend，
//     * 并且这也是为什么我们要将它们放入 runBlocking {}，launch {} 或者 async {} 中。
//     */
//    // 现在当我们从协程中调用 workload()，编译器知道它可以挂起并相应地准备：
//    val result = GlobalScope.async { workLoad(100) }
//    println("result $result")

}
