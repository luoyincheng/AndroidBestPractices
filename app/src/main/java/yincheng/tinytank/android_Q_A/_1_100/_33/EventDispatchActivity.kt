package yincheng.tinytank.android_Q_A._1_100._33

import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import yincheng.tinytank.R

class EventDispatchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_dispatch)
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
//        Log.i("EventDispatch", "activity:dispatchTouchEvent:false")
//        return false
//        Log.i("EventDispatch", "activity:dispatchTouchEvent:true")
//        return true
        Log.i("EventDispatch", "activity:dispatchTouchEvent:${super.dispatchTouchEvent(ev)}")
        return super.dispatchTouchEvent(ev)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
//        Log.i("EventDispatch", "activity:onTouchEvent:false")
//        return false
//        Log.i("EventDispatch", "activity:onTouchEvent:true")
//        return true
        Log.i("EventDispatch", "activity:onTouchEvent:${super.onTouchEvent(event)}")
        return super.onTouchEvent(event)
    }
}