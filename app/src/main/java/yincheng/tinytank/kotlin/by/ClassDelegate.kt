package yincheng.tinytank.kotlin.by


/**
 * 类的代理
 */
interface BaseInterface {
   fun show()
}

open class BaseInterfaceImpl : BaseInterface {
   override fun show() {
      println("BaseInterfaceImpl.show()")
   }
}

/**
 * by 关键词 实现代理，不用实现 [show] 方法
 */
class ClassDelegate(baseInterface: BaseInterface) : BaseInterface by baseInterface

fun main() {
   val baseInterfaceImpl = BaseInterfaceImpl()
   ClassDelegate(baseInterfaceImpl).show()
}