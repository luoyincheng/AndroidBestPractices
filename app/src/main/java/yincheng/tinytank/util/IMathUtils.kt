package yincheng.tinytank.util

object IMathUtils {
    /**
     * 获取一列数据中所有最小的数据Index
     */
    fun findAllSmallestIndexes(intArray: IntArray): ArrayList<Int> {
        val resultList = ArrayList<Int>()
        val sortedArray = intArray.clone()
        sortedArray.sort()
        for (index in intArray.indices) {
            if (sortedArray[0] == intArray[index]) resultList.add(index)
        }
        return resultList
    }
}