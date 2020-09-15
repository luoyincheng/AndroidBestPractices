package yincheng.tinytank.cornerstone.matrix

import android.graphics.Matrix
import android.graphics.RectF
import android.os.Handler
import android.util.Log
import android.widget.ImageView
import android.widget.SeekBar
import androidx.appcompat.widget.AppCompatImageView
import butterknife.BindView
import yincheng.tinytank.R
import yincheng.tinytank.ui.activity.base.BaseActivity

class MatrixActivity : BaseActivity() {
   @BindView(R.id.iv_matrix_test)
   internal var iv_matrix_test: AppCompatImageView? = null

   @BindView(R.id.iv_matrix)
   internal var iv_matrix: MatrixImageView? = null

   @BindView(R.id.sb)
   internal var sb: SeekBar? = null
   private val matrix = Matrix()
   private val rectF = RectF()
   private var handler: Handler? = null
   private var expandRunnable: Runnable? = null
   private var shrinkRunnable: Runnable? = null

   override fun getLayoutId(): Int {
      return R.layout.activity_matrix
   }

   override fun initData() {
      handler = Handler(mainLooper)
      expandRunnable = Runnable {
         scaleImage(1.2f)
         if (handler != null) {
            handler!!.postDelayed(shrinkRunnable, 15)
         }
      }
      shrinkRunnable = Runnable {
         scaleImage((1 / 1.2).toFloat())
         if (handler != null) {
            handler!!.postDelayed(expandRunnable, 15)
         }
      }
   }

   override fun initView() {
      iv_matrix_test!!.scaleType = ImageView.ScaleType.MATRIX
      matrix.reset()
   }

   override fun onStart() {
      super.onStart()
      handler!!.post(shrinkRunnable)
   }

   private fun scaleImage(ratioAfter: Float) {
      refreshImageRect()
      matrix.postScale(ratioAfter, ratioAfter, rectF.centerX(), rectF.centerY())
      refreshImageRect()
      matrix.postTranslate(1080 / 2 - rectF.centerX(), 2160 / 4 - rectF.centerY())
      applyMatrix()
   }

   // TODO: 2018/9/21 trying to draw too large bitmap
   private fun refreshImageRect() {
      if (iv_matrix_test!!.drawable != null) {
         rectF.set(iv_matrix_test!!.drawable.bounds)
         matrix.mapRect(rectF, rectF)
         Log.i("matrixTest", "left:" + rectF.left + "top:" + rectF.top + "right:" + rectF.right + "bottom:" + rectF.bottom)
      } else {
         Log.i("matrixTest", "getDrawable为空")
      }
   }

   private fun applyMatrix() {
      refreshImageRect()
      iv_matrix_test!!.imageMatrix = matrix
   }

   override fun onDestroy() {
      super.onDestroy()
      handler!!.removeCallbacks(shrinkRunnable)
      handler!!.removeCallbacks(expandRunnable)
   }
}
