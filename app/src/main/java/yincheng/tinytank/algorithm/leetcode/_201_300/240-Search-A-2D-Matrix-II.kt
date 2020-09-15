package yincheng.tinytank.algorithm.leetcode._201_300

fun main() {
   //5行３列
   val source = Array(5) { IntArray(3) }
   source[0][0] = 1
   source[0][1] = 2
   source[0][2] = 3

   source[1][0] = 4
   source[1][1] = 5
   source[1][2] = 6//第二行第三列

   source[2][0] = 7
   source[2][1] = 8
   source[2][2] = 9

   source[3][0] = 10
   source[3][1] = 11
   source[3][2] = 12

   source[4][0] = 13
   source[4][1] = 14
   source[4][2] = 15

   val result = search2DMatrix(source, 19)
   println(result.contentToString())
}

fun search2DMatrix(source: Array<IntArray>, target: Int): IntArray {
   val result = IntArray(2)
   var row = source.size - 1
   var column = 0
   while (row >= 0 && column < source[0].size) {
      when {
         source[row][column] > target -> row--
         source[row][column] < target -> column++
         else -> {
            result[0] = row
            result[1] = column
            return result
         }
      }
   }
   return result
}