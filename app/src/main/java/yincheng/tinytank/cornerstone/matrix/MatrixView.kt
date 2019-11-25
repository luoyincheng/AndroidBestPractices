package yincheng.tinytank.cornerstone.matrix

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View

class MatrixView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : View(context, attrs, defStyleAttr) {

    private var mPaint = Paint()
    private val mStrokeWidth = 4.0f
    private var mCornerPoints = FloatArray(4)
    private var mMatrix = Matrix()

    init {
        mPaint.isAntiAlias = true
        mPaint.style = Paint.Style.STROKE
        mPaint.color = Color.parseColor("#ff0000")
        mPaint.strokeWidth = mStrokeWidth

        mCornerPoints[0] = 100f
        mCornerPoints[1] = 400f
        mCornerPoints[2] = 900f
        mCornerPoints[3] = 700f
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        drawRect(canvas)
    }

    fun rotate(degree: Int) {
        mMatrix.setRotate(90.0f, (mCornerPoints[0] + mCornerPoints[2]) * 0.5f, (mCornerPoints[1] + mCornerPoints[3]) * 0.5f)
        mMatrix.mapPoints(mCornerPoints)


        invalidate()
    }

    fun scale() {
        mMatrix.setScale(0.5f, 0.5f)
        mMatrix.mapPoints(mCornerPoints)
        invalidate()
    }

    private fun drawRect(canvas: Canvas?) {
        val rectF = RectF(mCornerPoints[0], mCornerPoints[1], mCornerPoints[2], mCornerPoints[3])
        canvas?.drawRect(rectF, mPaint)
    }

    private fun printPoints(description: String) {
        for (mCornerPoint in mCornerPoints) {
            Log.i("printPoints", description + mCornerPoint.toString())
        }
    }
}
