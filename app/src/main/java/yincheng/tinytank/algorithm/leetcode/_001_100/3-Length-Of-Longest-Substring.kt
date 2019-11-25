package yincheng.tinytank.algorithm.leetcode._001_100

fun main() {
    val string1 = "wahhhfeiga"
    val string2 = "asdfdsa"
    val string3 = "wodew"
    println(findLengthOfLongestSubstring(string1))
    println(findLengthOfLongestSubstring(string2))
    println(findLengthOfLongestSubstring(string3))
}

fun findLengthOfLongestSubstring(string: String): Int {
    var answer = 0
    val storedIndexes = IntArray(128)
    var startIndex = 0  //最长的Substring 最左边的index
    // try to extend the range [i, j]

    string.forEachIndexed { index, char ->
        //找出startIndex
        startIndex = Math.max(startIndex, storedIndexes[char.toInt()])

        //每次从当前找到的最大值和之前找到的最大值中选择较大的那一个
        answer = Math.max(answer, index - startIndex + 1)

        println("$index $char $startIndex ${storedIndexes[char.toInt()]}")

        // 这个index+1真的精髓
        storedIndexes[char.toInt()] = index + 1
    }
    return answer
}