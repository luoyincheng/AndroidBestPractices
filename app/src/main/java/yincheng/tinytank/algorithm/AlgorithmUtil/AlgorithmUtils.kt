package yincheng.tinytank.algorithm.AlgorithmUtil

fun printArray(intArray: IntArray) {
   val stringBuilder = StringBuilder()
   for (integer in intArray) {
      stringBuilder.append("$integer -> ")
   }
   println(stringBuilder.substring(0, stringBuilder.length - 2))
}