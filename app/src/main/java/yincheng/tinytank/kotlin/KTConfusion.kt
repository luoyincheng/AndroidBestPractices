package yincheng.tinytank.kotlin

fun main() {
//    println(doSomething())
//    println(fail())

   val map = mapOf("a" to "aa", "b" to "bb")
   val data: String? = map["c"]
   println(data?.length)
   val dataa: String = map["c"] ?: fail()
   println(dataa.length)
}

fun UnitTest(): Unit {

}


fun doSomething() { // 返回类型为Unit
   println("hello world")
}

fun fail(): Nothing { // 返回类型为Nothing
   throw RuntimeException("Something went wrong")
}




