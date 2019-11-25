package yincheng.tinytank.algorithm.leetcode._001_100

fun main() {
    val source = intArrayOf(1, 3, 4, 6, 7, 8, 9, 10, 23, 56)
    println(findInsertIndex(source, 2))
}

/**
 * 1. 比二分查找多了一步,就是每次判断时，不只要判断大小，还要判断紧随的那个数字是否也要比要判断的数字
 */
private fun findInsertIndex(nums: IntArray, target: Int): Int {
    var result = -1
    var startIndex = 0
    var endIndex = nums.size - 1
    var middleIndex: Int
    while (startIndex <= endIndex) {
        middleIndex = (startIndex + endIndex) / 2
        if (target < nums[middleIndex]) {
            if (middleIndex - 1 < 0) return 0
            if (target > nums[middleIndex - 1]) return middleIndex - 1
            endIndex = middleIndex
        } else if (target > nums[middleIndex]) {
            if (middleIndex + 1 > nums.size) return nums.size
            if (target > nums[middleIndex + 1]) return middleIndex + 1
            startIndex = middleIndex //优化
        } else return middleIndex
    }
    return result
}