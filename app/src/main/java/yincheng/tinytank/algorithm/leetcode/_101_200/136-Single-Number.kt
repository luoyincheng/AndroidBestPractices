package yincheng.tinytank.algorithm.leetcode._101_200

fun main() {
    val source = intArrayOf(1, 2, 4, 3, 1, 4, 6, 5, 2, 6, 5)
    println(findSingleNumber(source))
}

/**
 * 根据异或运算的特点，相同的数字经过异或运算后结果为0，除单独出现一次的数字外，其他数字都是出现两次的，
 * 那么这些数字经过异或运算后结果一定是0。而任何数字与0进行异或运算都是该数字本身。所以对数组所有元素进行异或运算，
 * 运算结果就是题目的答案。
 */
fun findSingleNumber(numbers: IntArray): Int {
    var ans = numbers[0]
    if (numbers.size > 1) {
        for (i in 1 until numbers.size) {
            ans = ans xor numbers[i]
        }
    }
    return ans
}