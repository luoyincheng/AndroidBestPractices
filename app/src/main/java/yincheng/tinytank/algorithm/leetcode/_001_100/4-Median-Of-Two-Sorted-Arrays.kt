package yincheng.tinytank.algorithm.leetcode._001_100

fun main() {
    val array1 = arrayOf(1, 2, 3, 7, 9, 11, 45)
    val array2 = arrayOf(4, 5, 6, 7, 8, 9, 12, 34, 45, 67, 78, 89)
    println(findMedianSortedArrays(array1, array2))

    println(findIndexToInsert(array2, 0, array2.size - 1, 1))

}

/**
 * 1.判断排序方式，从大到小还是从小到大
 * 2.
 */
fun findMedianSortedArrays(array1: Array<Int>, array2: Array<Int>): Boolean {
    val isOneBecomeBigger = array1[0] - array1[array1.size - 1] <= 0
    val isTwoBecomeBigger = array2[0] - array2[array2.size - 1] <= 0
    val isSameDirection = isOneBecomeBigger == isTwoBecomeBigger
    if (isSameDirection) {
        if (isOneBecomeBigger) {
            if (array1[array1.size / 2] > array2[0]) {

            }
        } else {

        }

    } else {
        if (isOneBecomeBigger) {

        } else {

        }
    }
    return isSameDirection
}

/**
 * 找出一个数组在另外一个数组的区间下标
 */
fun findRange(): Pair<Int, Int> {
    var pair = Pair<Int, Int>(-1, -1)
    return pair
}

fun findIndexToInsert(array: Array<Int>, startIndex: Int, endIndex: Int, target: Int): Int {
    val middleIndex = array[(startIndex + endIndex) / 2]
    val isBecomeBigger = array[array.size - 1] > array[0]  //todo 所有数字全部相等的情况
    if (isBecomeBigger) {
        if (array[middleIndex] < target) {
            return if (array[middleIndex + 1] < target) findIndexToInsert(array, middleIndex, endIndex, target)
            else middleIndex
        } else {
            return if (array[middleIndex - 1] > target) findIndexToInsert(array, 0, middleIndex, target)
            else middleIndex
        }
    }
    return -1
}