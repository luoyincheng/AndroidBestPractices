package yincheng.tinytank.algorithm.leetcode._001_100

import kotlin.math.max
import kotlin.math.min

fun main() {
   val source = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7, 33, 25, 67, 11)
   println(containerWithMostWater(source))
}

fun containerWithMostWater(data: IntArray): Int {
   var maxArea = 0
   var startIndex = 0
   var endIndex = data.size - 1
   while (startIndex < endIndex) {
      val nowArea = min(data[startIndex], data[endIndex]) * (endIndex - startIndex)
      maxArea = max(nowArea, maxArea)
      if (data[endIndex] > data[startIndex])
         startIndex++
      else
         endIndex--
   }
   return maxArea
}