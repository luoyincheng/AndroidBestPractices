package yincheng.tinytank.android.bitmap

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import yincheng.tinytank.R

class BitmapActivity : AppCompatActivity() {
   private lateinit var imageViewShowingBitmap: AppCompatImageView
   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_bitmap_test)
      imageViewShowingBitmap = this.findViewById(R.id.iv_bitmap_container)
      val assetManager = this.resources.assets

//        val inputstream = assetManager.open("horizon_12800x4800.jpg")
//        imageViewShowingBitmap.setImageBitmap(BitmapFactory.decodeStream(inputstream))
   }
}
