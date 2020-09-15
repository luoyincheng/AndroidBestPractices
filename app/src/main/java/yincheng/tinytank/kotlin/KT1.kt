package yincheng.tinytank.kotlin

fun main() {
//    val y = 9
//    if (0 in 1..y + 1) {
//        println("fits in range")
//    }
//    val list = listOf("a", "b", "c")
//    if (-1 !in 0..list.lastIndex) {
//        println("-f is out of range ${list.lastIndex}")
//    }
   /*list.indices 返回的是一个IntRange对象，这里指的是０..2*/
//    if (list.size !in list.indices) {
//        println("list size is out of valid list indices range,too ${list.indices}")
//    }

//    for (i in 1..5) {
//        println("$i") // 1 2 3 4 5
//    }

//    for (i in 1..10 step 2) {
//        println("$i") // 1 3 5 7 9
//    }

//    for (i in 9 downTo 0 step 3) {
//        println("$i") // 9 6 3 0
//    }

//    val items = listOf("apple", "banana", "kiwifruit")
//    println(decribe("haha")) // unknown

//    when {
//        "orange" in items -> println("juicy")
//        "apple" in items -> println("apple is fine too")
//    }

//    val fruits = listOf("ac", "aab", "b", "a", "ad")
//    fruits.filter { it.startsWith("a") }
//            .sortedByDescending { it}
//            .map { it.toUpperCase() }
//            .forEach { println(it) }

//    val map = mapOf("a" to 1, "b" to 2, "c" to 3)
//    println(map["a"])

//    val p: String by lazy {
//        "我的世界"
//    }
//    println(p)

//    "hellow world".extendedFunction()

//    val files = File("TestFile").listFiles()
//    println(files?.size) // null
//    println(files?.size ?: "empty") // empty

//    val userInfomation = mapOf("name" to "luoyincheng", "email" to null, "age" to 27)
//    println(userInfomation["email"] ?: throw IllegalArgumentException("email is missing")) // ?: 如果为空就走后面

//    println(transform("blue"))

//    tryCatchFun()

//    println(arrayOfMinusOnes(3))

//    val myTurtle = MyTurtle()
//    with(myTurtle){
//        penDown()
//        for (i in 1..4){
//            forWard100()
//            turn90()
//        }
//        penUp()
//    }

//    var a = 1
//    var b = 2
//    a = b.also { b = a }
//    println("$a $b")

   // *****
//    val a : Int? = 127
//    val b : Int? = 127
//    val c : Int? = 128
//    val d : Int? = 128
//    val e : Int? = -128
//    val f : Int? = -128
//    val g : Int? = -129
//    val h : Int? = -129
//    println(a === b)
//    println(c === d)
//    println(e === f)
//    println(g === h)

//    val a: Int = 1000
//    val b: Int = 1000
//    val c: Int = a
//    println(a == b)
//    println(a === b)
//    println(a === c)
//    println(a == c)
//    println(a == 1000)
//    println(a === 1000)
//    if (a is Any) {
//
//    }
//
//
//    val boxedA: Int? = a
//    val anotherBoxedA: Int? = a
//    println(boxedA == a)
//    println(boxedA === a)
//    println(boxedA == anotherBoxedA)
//    println(boxedA === anotherBoxedA)
//    println(boxedA == 1000)
//    println(boxedA === 1000)
//
//    println(a)
//    println(c)
//    println(boxedA)
//    println(anotherBoxedA)
//
//    val aa: Int = 1
//    val bb: Long = aa.toLong()
//    val cc: Char = 'a'
//    val dd: Char = '1'


   println(charToInt('1'))
}

fun charToInt(char: Char): Int {
   if (char !in '0'..'9') throw java.lang.IllegalArgumentException("out of range")
   return char.toInt() - '0'.toInt()
}


class MyTurtle {
   fun penDown() {}
   fun forWard100() {}
   fun turn90() {}
   fun penUp() {}
}

fun arrayOfMinusOnes(size: Int): IntArray {
   return IntArray(size).apply { fill(-1) }
}

fun decribe(obj: Any): String =
      when (obj) {
         1 -> "one"
         "hello" -> "greeting"
         is Long -> "Long"
         !is String -> "Not a String"
         else -> "unknown"
      }

fun String.extendedFunction() {
   println("这是一个String类的扩展函数")
}

fun transform(param: String): Int {
   return when (param) {
      "red" -> 1
      "green" -> 2
      "blue" -> 3
      "alpha" -> 4
      else -> throw IllegalArgumentException("参数错误")
   }
}

fun tryCatchFun(): String {
   return try {
      transform("1")
   } catch (e: IllegalArgumentException) {
      println(e.toString())
   } finally {
      println("这里可以做回收操作")
   } as String
}


