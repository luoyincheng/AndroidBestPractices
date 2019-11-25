package yincheng.tinytank.tinyframe.alignline

import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import yincheng.tinytank.tinyframe.draggablearea.LayerView
import yincheng.tinytank.tinyframe.draggablearea.ViewDragHelper
import yincheng.tinytank.util.IMathUtils

class AdsorbHelper constructor(var parentView: ViewGroup, private var isCombineEdgeCenterTogether: Boolean) {
    // todo gestureoverlayview
    // todo 给viewdraghelper添加点击事件的监听
    // region [变量]
    val adsorbDistance: Int = 15  //todo 根据屏幕宽高动态计算
    private var actionDownX: Float = 0.toFloat()
    private var actionDownY: Float = 0.toFloat()
    /**
     * 是否需要进行对齐线的判断 1.如果没有已知的数据就不需要判断
     *                          2.。。。。
     */
    private var isAbleToAlign = false
    /**
     * 吸附以后开始计算<累计偏移量> 当累计偏移量绝对值大于等于 adsorbDistance 时 当前View才会继续运动
     */
    private var accumulatedHorizontalOffset: Int = 0
    private var accumulatedVerticalOffset: Int = 0
    private var mViewDragHorizontalState: ViewDragHorizontalState = ViewDragHorizontalState.ADSORBED_HORIZONTAL
    private var mViewDragVerticalState: ViewDragVerticalState = ViewDragVerticalState.ADSORB_VERTICAL
    lateinit var mPentaArrayList: ViewGroupUtils.PentaArrayList

    // endregion
    val viewDragHelper: ViewDragHelper = ViewDragHelper.create(parentView, object : ViewDragHelper.Callback() {
        override fun onViewDragStateChanged(state: Int) {
            Log.i("ViewDragHelper", "onViewDragStateChanged")
            super.onViewDragStateChanged(state)
        }

        override fun onViewPositionChanged(changedView: View, left: Int, top: Int, dx: Int, dy: Int) {
            Log.i("ViewDragHelper", "onViewPositionChanged" + left + ":" + top)
            mPentaArrayList = ViewGroupUtils.findAllAlignLinesRankedAndNearestCoordinates(parentView, changedView, isCombineEdgeCenterTogether)
            super.onViewPositionChanged(changedView, left, top, dx, dy)
        }

        override fun onViewCaptured(capturedChild: View, activePointerId: Int) {
            currentCapturedChild = capturedChild as LayerView

            Log.i("ViewDragHelper", "onViewCaptured")
            super.onViewCaptured(capturedChild, activePointerId)
        }

        override fun onViewReleased(releasedChild: View, xvel: Float, yvel: Float) {
            Log.i("ViewDragHelper", "onViewReleased")
            // todo 只有在选中的情况下才进行 resetData() 添加判断
            resetData(releasedChild)
            /**
             * test ...
             */
            mViewDragVerticalState = ViewDragVerticalState.ADSORB_VERTICAL
            mViewDragHorizontalState = ViewDragHorizontalState.ADSORBED_HORIZONTAL
            super.onViewReleased(releasedChild, xvel, yvel)
        }

        override fun onEdgeTouched(edgeFlags: Int, pointerId: Int) {
            Log.i("ViewDragHelper", "onEdgeTouched")
            super.onEdgeTouched(edgeFlags, pointerId)
        }

        override fun onEdgeLock(edgeFlags: Int): Boolean {
            Log.i("ViewDragHelper", "onEdgeLock")
            return super.onEdgeLock(edgeFlags)
        }

        override fun onEdgeDragStarted(edgeFlags: Int, pointerId: Int) {
            Log.i("ViewDragHelper", "onEdgeDragStarted")
            super.onEdgeDragStarted(edgeFlags, pointerId)
        }

        override fun getOrderedChildIndex(index: Int): Int {
            Log.i("ViewDragHelper", "getOrderedChildIndex")
            return super.getOrderedChildIndex(index)
        }

        override fun getViewHorizontalDragRange(child: View): Int {
            Log.i("ViewDragHelper", "getViewHorizontalDragRange")
            return super.getViewHorizontalDragRange(child)
        }

        override fun getViewVerticalDragRange(child: View): Int {
            Log.i("ViewDragHelper", "getViewVerticalDragRange")
            return super.getViewVerticalDragRange(child)
        }

        override fun tryCaptureView(child: View, pointerId: Int): Boolean {
            Log.i("ViewDragHelper", "tryCaptureView")
            return true
        }

        /**
         * @param child ,当前view，可以使用child.left获取当前位置
         * @param left  ,将要移动到的位置，改变该值将会改变View的显示位置
         * @param dx    ,本次移动相对于上次移动的偏移量，有正负
         */
        override fun clampViewPositionHorizontal(child: View, left: Int, dx: Int): Int {
            Log.i("ViewDragHelper", "clampViewPositionHorizontal" + left + ":" + child.left + ":" + dx)
            /**
             * 未选中不能拖拽,（最高优先级先判断）
             */
            if (currentCapturedChild != null &&
                    !(currentCapturedChild as LayerView).isOperateEnabled)
                return child.left //不是left
            /**
             * 边界限制，（第二优先级，不受吸附的影响）
             */
            if (left < 0) return 0
            if (parentView.left + left + child.width > parentView.right)
                return parentView.right - child.width - parentView.left      //必须用left + child.getWidth()来计算
            /**
             * 吸附判断
             */
            return when {
                isAbleToAlign -> startAlign("horizontal", child, left, dx)
                else -> left
            }
        }

        override fun clampViewPositionVertical(child: View, top: Int, dy: Int): Int {
            Log.i("ViewDragHelper", "clampViewPositionVertical" + top + ":" + child.top)
            var realTop: Int = top
            if (currentCapturedChild != null && !(currentCapturedChild as LayerView).isOperateEnabled)
                realTop = child.top  //不是top
            if (top < 0) realTop = 0
            if (parentView.top + top + child.height > parentView.bottom)
                realTop = parentView.bottom - child.height - parentView.top
            if (realTop in 101..299) return 200
            return realTop
        }
    })
    var currentCapturedChild: LayerView? = null

    fun onTouchEvent(
            motionEvent: MotionEvent
    ) {
        when (motionEvent.action) {
            MotionEvent.ACTION_DOWN -> onActionDown(motionEvent)
            MotionEvent.ACTION_UP -> onActionUp(motionEvent)
        }
        viewDragHelper.processTouchEvent(motionEvent)
    }

    private fun onActionDown(motionEvent: MotionEvent) {
        actionDownX = motionEvent.x
        actionDownY = motionEvent.y
    }

    private fun startAlign(type: String, child: View, destinationCoordinate: Int, dx: Int): Int {
        /**
         * 1.判断left和left+child.width 是否存在于verticalLines中
         * 2.判断top和top+child.height 是否存在于horizontalLines中
         * 3.判断left+child.width * 0.5f 是否存在于verticalCenterLinesSorted中
         * 4.判断top+child.height * 0.5f 是否存在于horizontalCenterLinesSorted中
         */
        return findAlignedLinesAndIndex(type, child, destinationCoordinate, dx)
    }

    /**
     * dx < 0,表示手指往左滑动，dx > 0,表示手指往右滑动
     * @param destinationCoordinate, View左边，右边，上边，下边，中间的坐标,这是由于viewDragHelper已经算好的，如果没有对齐直接返回该值就好
     * @return Array<Int>,可能的长度是1,2,3,4  第一条数据一定是:View最终的显示位置
     *                                         其余数据是返回的对齐线坐标，有可能是 1,2,3条
     */
    private fun findAlignedLinesAndIndex(direction: String, capturedView: View, destinationCoordinate: Int, dx: Int): Int {

        //        when (mViewDragHorizontalState) {
//            ViewDragHorizontalState.ADSORBED_HORIZONTAL -> {
//                accumulatedHorizontalOffset += dx
//                if (accumulatedHorizontalOffset <= -adsorbDistance) {
//                    mViewDragHorizontalState = ViewDragHorizontalState.FINDING_HORIZONTAL
//                    return child.left + accumulatedHorizontalOffset
//                }
//                return child.left
//            }
//            ViewDragHorizontalState.FINDING_HORIZONTAL -> return left
//        }
        return findAllAlignLinesInOneDirection(direction, capturedView, destinationCoordinate, dx)
    }

    /**
     * 一次性找到水平方向或者垂直方向上的所有吸附点，数量从0-3不等
     * @param direction             水平方向从verticalLines中查找 。。。
     * @param capturedView          当前操作的View
     * @param destinationCoordinate 该View将要移动到的坐标点
     * @param dx > 0                往右移动，否则往左
     */
    private fun findAllAlignLinesInOneDirection(direction: String, capturedView: View, destinationCoordinate: Int, dx: Int): Int {
        return when (direction) {
            "horizontal" -> {
                Log.i("horizontal", capturedView.left.toString() + ":" + capturedView.top.toString() + ":" + destinationCoordinate.toString())
//                findDestinationAfterAligned(
//                        capturedView,
//                        destinationCoordinate,
//                        dx,
//                        mPentaArrayList.verticalLines,
//                        mPentaArrayList.verticalCenterLines,
//                        mPentaArrayList.nearestIndex[0],
//                        mPentaArrayList.nearestIndex[1],
//                        mPentaArrayList.nearestIndex[2])
                var leftMargin = Int.MAX_VALUE
                var centerMargin = Int.MAX_VALUE
                var rightMargin = Int.MAX_VALUE

                if (mPentaArrayList.nearestIndex[0] != -1) {
                    leftMargin = Math.abs(capturedView.left - mPentaArrayList.verticalLines[mPentaArrayList.nearestIndex[0]])
                }
                if (mPentaArrayList.nearestIndex[1] != -1) {
                    centerMargin = Math.abs(capturedView.left + capturedView.width * 0.5f - mPentaArrayList.verticalLines[mPentaArrayList.nearestIndex[1]]).toInt()
                }
                if (mPentaArrayList.nearestIndex[2] != -1) {
                    rightMargin = Math.abs(capturedView.right - mPentaArrayList.verticalLines[mPentaArrayList.nearestIndex[2]])
                }

                val nearestIndexs = IMathUtils.findAllSmallestIndexes(intArrayOf(leftMargin, centerMargin, rightMargin))
                Log.i("nearestIndexs", "$nearestIndexs | $leftMargin | $centerMargin | $rightMargin")

                destinationCoordinate
            }
            "vertical" -> {
                Log.i("vertical", capturedView.left.toString() + ":" + capturedView.top.toString() + ":" + destinationCoordinate.toString())
//                findDestinationAfterAligned(
//                        capturedView,
//                        destinationCoordinate,
//                        dx,
//                        mPentaArrayList.horizontalLines,
//                        mPentaArrayList.horizontalCenterLines,
//                        mPentaArrayList.nearestIndex[3],
//                        mPentaArrayList.nearestIndex[4],
//                        mPentaArrayList.nearestIndex[5])
                destinationCoordinate
            }
            else -> destinationCoordinate
        }
    }

    private fun findDestinationAfterAligned(capturedView: View,
                                            destinationCoordinate: Int,
                                            dx: Int,
                                            borderLines: ArrayList<Int>,//left right or top bottom
                                            centerLines: ArrayList<Int>,
                                            leftOrTopNearestIndex: Int,
                                            centerNearestIndex: Int,
                                            rightOrBottomNearestIndex: Int): Int {

        val array = intArrayOf(Int.MAX_VALUE, Int.MAX_VALUE, Int.MAX_VALUE)

        val nearestIndexs = IMathUtils.findAllSmallestIndexes(array)
        Log.i("emmm...", "nearestIndexs:" + nearestIndexs + ":" + leftOrTopNearestIndex + ":" + centerNearestIndex + ":" + rightOrBottomNearestIndex)

        // 往 左边/上边 滑动
        if (dx < 0) {
            // 当前只有一个View 或者 该View在最左边/最上边
            if (leftOrTopNearestIndex != -1) {

            }
            if (centerNearestIndex != -1) {

            }
            if (rightOrBottomNearestIndex != -1) {

            }
        } else {

        }
        return destinationCoordinate
    }

    /**
     * 获取对齐以后的正确位置,并绘制对齐线
     * @param widthOrHeight : 用来计算某一边对齐之后其余边是否也对齐  通用的
     */
    private fun getProperDestination(nearest: Int, widthOrHeight: Int, array: Array<Int>): Int {
        when (nearest) {
            array[1] -> {
                // TODO 绘制对齐线
                Log.i("getProperDestination", "1")
                return array[1]
            }
            array[2] -> {
                // TODO 绘制对齐线
                Log.i("getProperDestination", "2")

                return (array[2] - widthOrHeight * 0.5f).toInt()
            }
            array[3] -> {
                Log.i("getProperDestination", "3")

                // TODO 绘制对齐线
                return array[3] - widthOrHeight
            }
        }
        return -1
    }

    /**
     * 总是最先吸附间距最小的那个
     */
    fun hasReachedAlignRegion(leftOrTop: Int, center: Int, rightOrBottom: Int) {
        if (leftOrTop < center) {
            if (leftOrTop < rightOrBottom) {

            }
        }
    }

    private fun onActionUp(motionEvent: MotionEvent) {
        // todo 点击事件应该加上时间判断
        if (Math.abs(motionEvent.x - actionDownX) < 1 && Math.abs(motionEvent.y - actionDownY) < 1) {
            if (currentCapturedChild != null)
                currentCapturedChild!!.onClicked()
            else for (i in 0 until parentView.childCount)
                (parentView.getChildAt(i) as LayerView).disableOperation()
        }
        currentCapturedChild = null
    }

    enum class ViewDragHorizontalState {
        ADSORBED_HORIZONTAL, FINDING_HORIZONTAL // todo 更多的状态
    }

    enum class ViewDragVerticalState {
        ADSORB_VERTICAL, FINDING_VERTICAL
    }

    lateinit var mOnAlignListener: OnAlignListener

    interface OnAlignListener {
        fun onAlignLineFound(horizontalLines: ArrayList<Int>, verticalLines: ArrayList<Int>)
    }

    fun resetData(releasedChild: View) {
        mPentaArrayList = ViewGroupUtils.findAllAlignLinesRankedAndNearestCoordinates(parentView, releasedChild, isCombineEdgeCenterTogether)
        isAbleToAlign = mPentaArrayList.horizontalLines.size > 0 ||
                mPentaArrayList.horizontalCenterLines.size > 0 ||
                mPentaArrayList.verticalLines.size > 0 ||
                mPentaArrayList.verticalCenterLines.size > 0
        /**
         * test ...
         */
        mOnAlignListener.onAlignLineFound(mPentaArrayList.horizontalLines, mPentaArrayList.verticalLines)
        accumulatedHorizontalOffset = 0
        accumulatedVerticalOffset = 0
    }
}