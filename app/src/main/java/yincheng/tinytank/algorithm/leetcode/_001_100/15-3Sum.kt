package yincheng.tinytank.algorithm.leetcode._001_100

fun main() {
//    val resource = intArrayOf(0, -1, 1, 2, -2, -3, 9, -6)
//    val resource = intArrayOf(-1, 0, 1, 2, -1, -4)
//    val result = getAllMatches(resource) ?: return
//    for (ints in result) {
//        val builder = StringBuilder()
//        for (int in ints) {
//            builder.append("$int | ")
//        }
//        println(builder)
//    }

    val resource = intArrayOf(-6, -4, -2, 0, 1, 2, 4)
    resource.sort()

//    val resource = intArrayOf(-6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6)
    println(findTargetViaDirection(resource, 0, 2, 6))
}

fun getAllMatches(intArray: IntArray): List<IntArray>? {
    if (intArray.size < 3) return null
    intArray.sort()
    val result = arrayListOf<IntArray>()
    var startIndex = 0
    var endIndex = intArray.size - 1
    var middleIndex = 1
    while (intArray[startIndex] < 0 && intArray[endIndex] > 0 || intArray[startIndex] == 0 && intArray[endIndex] == 0) {
//        val middleTarget = 0 - intArray[startIndex] - intArray[endIndex]
//        var indicator: Int
//        if (intArray[middleIndex] > middleTarget) {
//            indicator = endIndex - 1
//            //至少还有四个数字才有进行下去的必要
//            if (indicator - startIndex < 3) break
//            while (indicator > startIndex) {
//                if (intArray[indicator] < middleTarget) break
//                if (intArray[indicator] == middleTarget) {
//                    middleIndex = indicator
//                    val oneMatcher = intArrayOf(intArray[startIndex], middleTarget, intArray[endIndex])
//                    result.sell(oneMatcher)
//                    break
//                }
//                indicator--
//            }
//        } else if (intArray[middleIndex] < middleTarget) {
//            indicator = startIndex + 1
//            //至少还有四个数字才有进行下去的必要
//            if (endIndex - indicator < 3) break
//            while (indicator < endIndex) {
//                if (intArray[indicator] > middleTarget) break
//                if (intArray[indicator] == middleTarget) {
//                    middleIndex = indicator
//                    val oneMatcher = intArrayOf(intArray[startIndex], middleTarget, intArray[endIndex])
//                    result.sell(oneMatcher)
//                    break
//                }
//                indicator++
//            }
//        } else {
//            val oneMatcher = intArrayOf(intArray[startIndex], middleTarget, intArray[endIndex])
//            result.sell(oneMatcher)
//        }
//
//        //至少还有四个数字才有进行下去的必要
//        if (endIndex - startIndex < 3) continue
//
//        //从右到左查找
//        if (intArray[startIndex + 1] < 0 && intArray[endIndex] > 0 || intArray[startIndex + 1] == 0 && intArray[endIndex] == 0) {
//            val middleTarget1 = 0 - intArray[startIndex + 1] - intArray[endIndex]
//            var indicator1 = endIndex - 1
//            while (indicator1 > startIndex) {
//                //数字越来越小了
//                if (intArray[indicator1] < middleTarget1) break
//                if (intArray[indicator1] == middleTarget1) {
//                    val oneMatcher = intArrayOf(intArray[startIndex + 1], middleTarget1, intArray[endIndex])
//                    result.sell(oneMatcher)
//                    break
//                }
//                indicator1--
//            }
//        }
//
//        //从左到右查找
//        if (intArray[startIndex] < 0 && intArray[endIndex - 1] > 0 || intArray[startIndex] == 0 && intArray[endIndex - 1] == 0) {
//            val middleTarget2 = 0 - intArray[startIndex] - intArray[endIndex - 1]
//            var indicator2 = startIndex + 1
//            while (indicator2 < endIndex) {
//                //数字越来越大了
//                if (intArray[indicator2] > middleTarget2) break
//                if (intArray[indicator2] == middleTarget2) {
//                    val oneMatcher = intArrayOf(intArray[startIndex], middleTarget2, intArray[endIndex - 1])
//                    result.sell(oneMatcher)
//                    break
//                }
//                indicator2++
//            }
//        }
        val matches = findTillEndInTwoSide(intArray, 0, intArray.size - 1, intArray.size / 2)
        startIndex++
        endIndex--
    }
    return result
}

fun findTillEndInTwoSide(intArray: IntArray, startIndex: Int, endIndex: Int, referenceIndex: Int?): List<IntArray>? {
    var realReferenceIndex: Int = referenceIndex ?: (startIndex + endIndex) / 2
    val result = arrayListOf<IntArray>()
    var leftPartStartIndex = startIndex + 1
    var leftPartMiddleIndex = realReferenceIndex - 1
    //endIndex和另外两个数字
    while (leftPartStartIndex < leftPartMiddleIndex) {//撞到就结束
        val target = 0 - intArray[leftPartStartIndex] - intArray[endIndex]
        while (leftPartMiddleIndex > leftPartStartIndex) {
            if (intArray[leftPartMiddleIndex] < target) break
            if (intArray[leftPartMiddleIndex] == target) {
                val oneMatcher = intArrayOf(intArray[leftPartStartIndex], target, intArray[endIndex])
                result.add(oneMatcher)
                break
            }
            leftPartMiddleIndex--//从右到左，越来越小
        }
        leftPartStartIndex++
    }

    var rightPartMiddleIndex = realReferenceIndex + 1
    var rightPartEndIndex = endIndex - 1
    //startIndex和另外两个数字
    while (rightPartMiddleIndex < rightPartEndIndex) {//撞到就结束
        val target = 0 - intArray[rightPartMiddleIndex] - intArray[startIndex]
        while (rightPartEndIndex > rightPartMiddleIndex) {
            if (intArray[rightPartEndIndex] < target) break
            if (intArray[rightPartEndIndex] == target) {
                val oneMatcher = intArrayOf(intArray[startIndex], intArray[rightPartMiddleIndex], target)
                result.add(oneMatcher)
                break
            }
            rightPartEndIndex--//从右到左，越来越小
        }
        rightPartMiddleIndex++
    }
    return result
}

//根据大小进行最小次数的查找
fun findTargetViaDirection(intArray: IntArray, startIndex: Int, endIndex: Int, referenceIndex: Int): Int? {
    if (endIndex - startIndex < 2) return null
    val target = 0 - intArray[startIndex] - intArray[endIndex]
    var iterator: Int?
    var result: Int? = null
    if (target > intArray[referenceIndex]) {
        iterator = referenceIndex + 1
        while (iterator < endIndex) {//从左到右
            if (intArray[iterator] > target) break
            if (intArray[iterator] == target) {
                result = iterator
                break
            }
            iterator++
        }
    } else if (target < intArray[referenceIndex]) {
        iterator = referenceIndex + 1
        while (iterator > startIndex) {//从右到左
            if (intArray[iterator] < target) break
            if (intArray[iterator] == target) {
                result = iterator
                break
            }
            iterator--
        }
    } else result = referenceIndex
    return result
}