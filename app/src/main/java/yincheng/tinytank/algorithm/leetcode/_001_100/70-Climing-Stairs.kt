package yincheng.tinytank.algorithm.leetcode._001_100

/**
 * 1-------1
 * 2-------2
 * 3-------3
 * 4-------5
 * 5-------8
 * 6-------13
 * ……
 * 也就是求出　１＋２＋３＋５＋８＋１３＋２１＋……的值
 */
fun main() {
    println(violentSolution(0, 5))
    println(fun2(5))
}

fun fun2(n: Int): Int {
    if (n == 1) return 1
    var prepre = 1 //前前一个
    var pre = 2  //前一个
    for (i in 3..n) {
        val now = prepre + pre
        prepre = pre
        pre = now
    }
    return pre
}

/**
 * 1.暴力法
 */
fun violentSolution(i: Int, j: Int): Int {
    if (i > j) return 0
    if (i == j) return 1
    return violentSolution(i + 1, j) + violentSolution(i + 2, j)
}