package yincheng.tinytank.android_Q_A._1_100._33

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.FrameLayout

class EventDispatchFrameLayout @JvmOverloads constructor(
      context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

   override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
//        Log.i("EventDispatch", "viewGroup:dispatchTouchEvent:false")
//        return false
//        Log.i("EventDispatch", "viewGroup:dispatchTouchEvent:true")
//        return true
      Log.i("EventDispatch", "viewGroup:dispatchTouchEvent:${super.dispatchTouchEvent(ev)}")
      return super.dispatchTouchEvent(ev)
   }

   override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
//        Log.i("EventDispatch", "viewGroup:onInterceptTouchEvent:false")
//        return false
//        Log.i("EventDispatch", "viewGroup:onInterceptTouchEvent:true")
//        return true
      Log.i("EventDispatch", "viewGroup:onInterceptTouchEvent:${super.onInterceptTouchEvent(ev)}")
      return super.onInterceptTouchEvent(ev)
   }

   override fun onTouchEvent(event: MotionEvent?): Boolean {
//        Log.i("EventDispatch", "viewGroup:onTouchEvent:false")
//        return false
//        Log.i("EventDispatch", "viewGroup:onTouchEvent:true")
//        return true
      Log.i("EventDispatch", "viewGroup:onTouchEvent:${super.onTouchEvent(event)}")
      return super.onTouchEvent(event)
   }
}