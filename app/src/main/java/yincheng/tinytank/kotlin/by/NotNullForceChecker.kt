package yincheng.tinytank.kotlin.by

import kotlin.properties.Delegates

/**
 * 属性非空强制校验
 */
class NotNullForceChecker {
   var name: String by Delegates.notNull()
   fun init(name: String) {
      this.name = name
   }
}

fun main() {
   val notNullForceChecker = NotNullForceChecker()
   notNullForceChecker.init("name")
   println(notNullForceChecker.name)
}