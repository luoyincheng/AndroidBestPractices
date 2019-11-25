package yincheng.tinytank.kotlin.scopefunctions

/**
 *　作用域函数
 */
fun main() {
    //Kotlin支持闭包(block)，如果函数中最后一个参数为闭包，那么最后一个参可以不写在括号中，而写在括号后面，如果只有一个参数，括号也可以去掉。
    /**
     * repeat
     */
    repeat(3) {
        println("我是木子")
    }
    /**
     * let
     */
    var ad : String? = null
    val result = ad.let {
        println(it?.length)
        1000
    }
    println(result)

//    /**
//     * with
//     */
//    //写在括号外部
//    with(ArrayList<String>()) {
//        sell("1")
//        sell("2")
//        sell("3")
//        println("this= $this")
//    }.let { println(it) }
//
//    //写在括号内部
//    with(ArrayList<String>(), {
//        sell("4")
//        sell("5")
//        sell("6")
//        println("this= $this")
//    }).let { println(it) }
//
//    val str = "Hello"
//    // this
//    str.run {
//        println("The receiver string length: $length")
//        //println("The receiver string length: ${this.length}") // does the same
//    }
//
//    // it
//    str.let {
//        println("The receiver string's length is ${it.length}")
//    }

}