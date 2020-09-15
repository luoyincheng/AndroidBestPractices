package yincheng.tinytank.algorithm.leetcode._001_100

/**
 *　给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *　你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *　示例:
 *　给定 nums = [2, 7, 11, 15], target = 9
 *　因为 nums[0] + nums[1] = 2 + 7 = 9
 *　所以返回 [0, 1]
 */
fun main() {
//    val source = intArrayOf(2, 3, 6, 9, 11)
   val source = intArrayOf(1, 3, 4, 8, 9)
//    val result = bruteForce(source, 10)
//    val result = twoPassHashTable(source, 10)
   val result = onePassHashTable(source, 10)
   result?.forEachIndexed { index, i -> println("$index $i") }
}

/**
 * time complexity   O(n ^ 2)
 * space complexity  O(1)
 */
private fun bruteForce(numbers: IntArray, target: Int): IntArray? {
   numbers.forEachIndexed { index, i ->
      numbers.forEachIndexed { index1, i1 ->
         if (i1 == target - i && i1 != i) return intArrayOf(index, index1)
      }
   }
   return null
}

/**
 * time complexity   O(n)
 * space complexity  O(n)
 */

private fun twoPassHashTable(numbers: IntArray, target: Int): IntArray? {
   val hashMap = hashMapOf<Int, Int>()
   numbers.forEachIndexed { index, value -> hashMap[value] = index }
   numbers.forEachIndexed { index, value ->
      val complement = target - value
      if (hashMap.containsKey(complement) && hashMap[complement] != index)
         return intArrayOf(index, hashMap[complement]!!)
   }
   return null
}


/**
 * time complexity   O(n)
 * space complexity  O(n)
 */
private fun onePassHashTable(numbers: IntArray, target: Int): IntArray? {
   val hashMap = hashMapOf<Int, Int>()
   numbers.forEachIndexed { index, value ->
      val complement = target - value
      if (hashMap.contains(complement)) {
         return intArrayOf(index, hashMap[complement]!!)
      }
      hashMap[value] = index
   }
   return null
}