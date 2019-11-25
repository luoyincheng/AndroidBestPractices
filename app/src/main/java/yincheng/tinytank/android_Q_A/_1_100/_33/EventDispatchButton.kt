package yincheng.tinytank.android_Q_A._1_100._33

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatButton

class EventDispatchButton @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatButton(context, attrs, defStyleAttr) {
    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
//        Log.i("EventDispatch", "view:dispatchTouchEvent:false")
//        return false
//        Log.i("EventDispatch", "view:dispatchTouchEvent:true")
//        return true
        Log.i("EventDispatch", "view:dispatchTouchEvent:${super.dispatchTouchEvent(event)}")
        return super.dispatchTouchEvent(event)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
//        Log.i("EventDispatch", "view:onTouchEvent:false")
//        return false
//        Log.i("EventDispatch", "view:onTouchEvent:true")
//        return true
        Log.i("EventDispatch", "view:onTouchEvent:${super.onTouchEvent(event)}")
        return super.onTouchEvent(event)
    }
}