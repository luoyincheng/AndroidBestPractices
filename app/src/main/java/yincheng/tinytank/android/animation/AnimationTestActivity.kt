package yincheng.tinytank.android.animation

import android.animation.ValueAnimator
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import yincheng.tinytank.R

class AnimationTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anim_test)
        val view = findViewById<View>(R.id.view)
        val anim = AnimationUtils.loadAnimation(this, R.anim.anim_dialog_in)
        view.setOnClickListener {
            view.startAnimation(anim)
        }
        val animator = ValueAnimator.ofInt(0, 10)
        animator.addUpdateListener { animation: ValueAnimator? ->
            Log.i("fafaaf", animation?.animatedValue.toString())
        }
        animator.start()
    }
}
