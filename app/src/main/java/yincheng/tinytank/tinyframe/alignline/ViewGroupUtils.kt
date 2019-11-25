package yincheng.tinytank.tinyframe.alignline

import android.util.Log
import android.view.View
import android.view.ViewGroup

object ViewGroupUtils {
    /**
     * @param isCombineCenterToEdge : true -> return two  collections，每个view的中线和边界线聚合在一个集合里面
     *                               false -> return four collections，每个view的中线和边界线分两个集合存储
     * @param releasedChild         : 手指抬起之前选中的View，根据该View的坐标来获取所有距离该View最近的的下标，总共0个或者6个
     */
    fun findAllAlignLinesRankedAndNearestCoordinates(viewGroup: ViewGroup, releasedChild: View, isCombineCenterToEdge: Boolean): PentaArrayList {
        val horizontalLines = HashSet<Int>()
        val verticalLines = HashSet<Int>()
        val horizontalCenterLines = HashSet<Int>()
        val verticalCenterLines = HashSet<Int>()

        for (i in 0 until viewGroup.childCount) {
            // 获取除选中的View之外的所有对齐线数据
            if (releasedChild == viewGroup.getChildAt(i)) continue
            horizontalLines.add(viewGroup.getChildAt(i).top)
            horizontalLines.add(viewGroup.getChildAt(i).bottom)
            verticalLines.add(viewGroup.getChildAt(i).left)
            verticalLines.add(viewGroup.getChildAt(i).right)
            if (isCombineCenterToEdge) {
                horizontalLines.add(((viewGroup.getChildAt(i).top + viewGroup.getChildAt(i).bottom) * 0.5f).toInt())
                verticalLines.add(((viewGroup.getChildAt(i).left + viewGroup.getChildAt(i).right) * 0.5f).toInt())
            } else {
                horizontalCenterLines.add(((viewGroup.getChildAt(i).top + viewGroup.getChildAt(i).bottom) * 0.5f).toInt())
                verticalCenterLines.add(((viewGroup.getChildAt(i).left + viewGroup.getChildAt(i).right) * 0.5f).toInt())
            }
        }

        val horizontalLinesSorted = ArrayList<Int>()
        horizontalLinesSorted.addAll(horizontalLines)
        horizontalLinesSorted.sort()
        val verticalLinesSorted = ArrayList<Int>()
        verticalLinesSorted.addAll(verticalLines)
        verticalLinesSorted.sort()
        val horizontalCenterLinesSorted = ArrayList<Int>()
        horizontalCenterLinesSorted.addAll(horizontalCenterLines)
        horizontalCenterLinesSorted.sort()
        val verticalCenterLinesSorted = ArrayList<Int>()
        verticalCenterLinesSorted.addAll(verticalCenterLines)
        verticalCenterLinesSorted.sort()

        // 获取距离选中的View边线最近的index
        val verticalLineLeft = leftOrTopIndexWhenInserted(verticalLinesSorted, 0, verticalLinesSorted.size - 1, releasedChild.left)
        val verticalLineCenter = leftOrTopIndexWhenInserted(verticalCenterLinesSorted, 0, verticalCenterLinesSorted.size - 1, ((releasedChild.left + releasedChild.right) * 0.5f).toInt())
        val verticalLineRight = leftOrTopIndexWhenInserted(verticalLinesSorted, 0, verticalLinesSorted.size - 1, releasedChild.right)
        val horizontalLineTop = leftOrTopIndexWhenInserted(horizontalLinesSorted, 0, horizontalLinesSorted.size - 1, releasedChild.top)
        val horizontalLineCenter = leftOrTopIndexWhenInserted(horizontalCenterLinesSorted, 0, horizontalCenterLinesSorted.size - 1, ((releasedChild.top + releasedChild.bottom) * 0.5f).toInt())
        val horizontalLineBottom = leftOrTopIndexWhenInserted(horizontalLinesSorted, 0, horizontalLinesSorted.size - 1, releasedChild.bottom)
        val indexList = arrayListOf(verticalLineLeft, verticalLineCenter, verticalLineRight, horizontalLineTop, horizontalLineCenter, horizontalLineBottom)
        Log.i("fadfadfaf", indexList.toString())
        var rere = StringBuilder()
        Log.e("fadsfadfaf", rere.append(verticalCenterLinesSorted.size).append(":").append(verticalLineCenter).toString())

        return PentaArrayList(verticalLinesSorted, verticalCenterLinesSorted, horizontalLinesSorted, horizontalCenterLinesSorted, indexList)
    }

    /**
     * 返回的是如果将compareTo按照大小插入到已知的arrayList中以后，得到compareTo在arrayList中的下标index-1
     */
    private fun leftOrTopIndexWhenInserted(arrayList: ArrayList<Int>,
                                           startCompareIndex: Int,
                                           endCompareIndex: Int,
                                           compareTo: Int): Int {
        if (arrayList.size == 0) return -1
        val middleIndex = ((startCompareIndex + endCompareIndex) * 0.5f).toInt()
        return when {
            compareTo < arrayList[0] -> -1
            compareTo > arrayList[arrayList.size - 1] -> arrayList.size - 1
            compareTo < arrayList[middleIndex] && compareTo < arrayList[middleIndex + 1] -> leftOrTopIndexWhenInserted(arrayList, startCompareIndex, middleIndex, compareTo)
            compareTo > arrayList[middleIndex] && compareTo > arrayList[middleIndex + 1] -> leftOrTopIndexWhenInserted(arrayList, middleIndex + 1, endCompareIndex, compareTo)
            else -> middleIndex
        }
    }

    /**
     * 加上internal var 将会直接讲成员变量暴露，外部可以直接调用
     */
    class PentaArrayList constructor(
            var verticalLines: ArrayList<Int>,
            var verticalCenterLines: ArrayList<Int>,
            var horizontalLines: ArrayList<Int>,
            var horizontalCenterLines: ArrayList<Int>,
            var nearestIndex: ArrayList<Int>)

    @JvmStatic
    fun main(args: Array<String>) {
        println(leftOrTopIndexWhenInserted(arrayListOf(), 0, 10, 77))
    }
}