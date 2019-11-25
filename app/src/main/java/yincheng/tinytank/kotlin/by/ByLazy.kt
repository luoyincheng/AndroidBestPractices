package yincheng.tinytank.kotlin.by

/**
 * 属性延迟加载
 */
class ByLazy {
    val lazyName: String by lazy {
        println("只有初始化lazyName时才会进入lazy{}代码块")
        "凭心而动(在这里指定初始化的lazyName)"
    }
}

fun main() {
    val byLazy = ByLazy()
    println("lazyName = ${byLazy.lazyName}")
    println("lazyName = ${byLazy.lazyName}")
}