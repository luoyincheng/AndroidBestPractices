package yincheng.tinytank.android_Q_A._1_100._35

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup

class SolidRatioView @JvmOverloads constructor(
      context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
   private val mPaint: Paint = Paint()
   private val mRatio = 0.5f // 宽度/高度 = 0.5f

   init {
      mPaint.color = Color.parseColor("#ffffff")
      mPaint.isAntiAlias = true
      mPaint.style = Paint.Style.STROKE
      mPaint.strokeWidth = 10.0f
   }

   override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
      super.onMeasure(widthMeasureSpec, heightMeasureSpec)
      val widthMode = MeasureSpec.getMode(widthMeasureSpec)
      val heightMode = MeasureSpec.getMode(heightMeasureSpec)

      val requiredWidth = MeasureSpec.getSize(widthMeasureSpec)
      val requiredHeight = MeasureSpec.getSize(heightMeasureSpec)
      val parentWidth = (parent as ViewGroup).measuredWidth
      val parentHeight = (parent as ViewGroup).measuredHeight

      var measuredWidth = 400 //这个是为wrap_content模式设置的默认值
      var measuredHeight = 400

      if (widthMode == MeasureSpec.EXACTLY) measuredWidth = if (requiredWidth > parentWidth) parentWidth else requiredWidth
      if (heightMode == MeasureSpec.EXACTLY) measuredHeight = if (requiredHeight > parentHeight) parentHeight else requiredHeight

      if (measuredHeight * mRatio > measuredWidth) measuredHeight = (measuredWidth / mRatio).toInt()
      else measuredWidth = (measuredHeight * mRatio).toInt()

      setMeasuredDimension(measuredWidth, measuredHeight)
   }

   override fun onDraw(canvas: Canvas?) {
      super.onDraw(canvas)
      canvas?.drawLine(0.0f, 0.0f, measuredWidth.toFloat(), measuredHeight.toFloat(), mPaint)
   }
}