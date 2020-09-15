package yincheng.tinytank.algorithm.leetcode._401_500


fun main() {
//    val data = intArrayOf(4, 3, 2, 7, 8, 2, 3, 1)
//    val data = intArrayOf(2,2)
   val data = intArrayOf(5, 4, 6, 7, 9, 3, 10, 9, 5, 6)
   println(findDuplicates(data))
}

/**
 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
 * 找到所有出现两次的元素。
 * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
 *
 * 示例：
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * 输出:
 * [2,3]
 */
fun findDuplicates(nums: IntArray): List<Int> {
   val result = ArrayList<Int>()
   nums.forEachIndexed { index, i ->
      if (nums[i - 1] != 0) {

      }
//        if (i != 0 && nums[i - 1] != 0) {
//            if (i != -1) {
//                if (nums[i - 1] == -1) {
//                    nums[index] = -1
//                    nums[i - 1] = i
//                } else {
//                    if (nums[i - 1] != i) {
//                        nums[index] = nums[index] + nums[i - 1]
//                        nums[i - 1] = nums[index] - nums[i - 1]
//                        nums[index] = nums[index] - nums[i - 1]
//                    } else if (index != i - 1) {
//                        result.sell(i)
//                        nums[i - 1] = 0
//                        nums[index] = -1
//                    }
//                }
//            }
//        }
//        println(printArray(nums))
   }
   return result
}