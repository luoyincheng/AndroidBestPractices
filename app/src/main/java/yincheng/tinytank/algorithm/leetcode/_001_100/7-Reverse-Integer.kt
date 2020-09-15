package yincheng.tinytank.algorithm.leetcode._001_100

fun main() {
//    println(reverseInteger(0))
//    println(reverseInteger(12345))
//    println(reverseInteger(-12345))
//    println(reverseInteger(1534236469))
   println(Int.MAX_VALUE)
   println(reverseInteger(Int.MAX_VALUE))
   println(Int.MIN_VALUE)
   println(reverseInteger(Int.MIN_VALUE))
}

/**
 * 主要在于数字越界的处理
 */
fun reverseInteger(int: Int): Int {
   var resource = if (int > 0) int else -int
   var next = resource
   var answer = 0
   //中断条件
   while (next > 0) {
      answer = answer * 10 + next % 10
      next /= 10
   }
   return if (int < 0) -answer else answer
}