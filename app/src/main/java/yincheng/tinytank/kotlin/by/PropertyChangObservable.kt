package yincheng.tinytank.kotlin.by

import kotlin.properties.Delegates

/**
 * 监听属性变化
 */
class PropertyChangObservable {
   var name: String by Delegates.observable("垂緌饮清露") { property, old, new ->
      println("${property.returnType}, $old -> $new")
   }

   var address: String by Delegates.vetoable("居高声自远", { _, oldValue, newValue ->
      println("oldValue：$oldValue | newValue：$newValue")
      newValue.contains("wang")
   })
}

fun main() {
   val propertyChangObservable = PropertyChangObservable()
   println(propertyChangObservable.name)
   propertyChangObservable.name = "流响出疏桐"

   propertyChangObservable.address = "非是藉秋风"
   println(propertyChangObservable.address)
}