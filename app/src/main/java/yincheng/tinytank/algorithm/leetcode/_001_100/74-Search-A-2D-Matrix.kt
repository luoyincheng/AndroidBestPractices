package yincheng.tinytank.algorithm.leetcode._001_100

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

    println(searchMatrix(source, 0))
}

fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    val rowSize = matrix.size
    if (rowSize == 0) return false
    val columnSize = matrix[0].size
    if (columnSize == 0) return false
    var endIndex = rowSize * columnSize - 1
    var startIndex = 0
    while (startIndex <= endIndex) {
        val middleIndex = ((startIndex + endIndex) * 0.5f).toInt()
        if (target > matrix[middleIndex / columnSize][middleIndex % columnSize]) {
            startIndex = middleIndex + 1
        } else if (target < matrix[middleIndex / columnSize][middleIndex % columnSize]) {
            endIndex = middleIndex - 1
        } else {
            return true
        }
    }
    return false
}