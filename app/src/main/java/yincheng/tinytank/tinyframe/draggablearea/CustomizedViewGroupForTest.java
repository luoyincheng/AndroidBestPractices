package yincheng.tinytank.tinyframe.draggablearea;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class CustomizedViewGroupForTest extends FrameLayout {
	public CustomizedViewGroupForTest(Context context) {
		this(context, null);
	}

	public CustomizedViewGroupForTest(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public CustomizedViewGroupForTest(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        Log.i("lifeCycleTest", "[container] -> onInterceptTouchEvent = " + "[" + super.onInterceptTouchEvent(ev) + "]");
//        return super.onInterceptTouchEvent(ev);
//    }
//
//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        Log.i("lifeCycleTest", "[container] -> dispatchTouchEvent = " + "[" + super.dispatchTouchEvent(ev) + "]");
//        return super.dispatchTouchEvent(ev);
//    }
//
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN://0
//                Log.i("lifeCycleTest", "[container] -> ACTION_DOWN = " + "[" + super.onTouchEvent(event) + "]");
//                break;
//            case MotionEvent.ACTION_UP://1
//                Log.i("lifeCycleTest", "[container] -> ACTION_UP = " + "[" + super.onTouchEvent(event) + "]");
//                break;
//            case MotionEvent.ACTION_MOVE://2
//                Log.i("lifeCycleTest", "[container] -> ACTION_MOVE = " + "[" + super.onTouchEvent(event) + "]");
//                break;
//            case MotionEvent.ACTION_CANCEL://3
//                Log.i("lifeCycleTest", "[container] -> ACTION_CANCEL = " + "[" + super.onTouchEvent(event) + "]");
//                break;
//            case MotionEvent.ACTION_OUTSIDE://4
//                Log.i("lifeCycleTest", "[container] -> ACTION_OUTSIDE = " + "[" + super.onTouchEvent(event) + "]");
//                break;
//            case MotionEvent.ACTION_POINTER_DOWN://5
//                Log.i("lifeCycleTest", "[container] -> ACTION_POINTER_DOWN = " + "[" + super.onTouchEvent(event) + "]");
//                break;
//            case MotionEvent.ACTION_POINTER_UP://6
//                Log.i("lifeCycleTest", "[container] -> ACTION_POINTER_UP = " + "[" + super.onTouchEvent(event) + "]");
//                break;
//            case MotionEvent.ACTION_HOVER_MOVE://7
//                Log.i("lifeCycleTest", "[container] -> ACTION_HOVER_MOVE = " + "[" + super.onTouchEvent(event) + "]");
//                break;
//            case MotionEvent.ACTION_SCROLL://8
//                Log.i("lifeCycleTest", "[container] -> ACTION_SCROLL = " + "[" + super.onTouchEvent(event) + "]");
//                break;
//            case MotionEvent.ACTION_HOVER_ENTER://9
//                Log.i("lifeCycleTest", "[container] -> ACTION_HOVER_ENTER = " + "[" + super.onTouchEvent(event) + "]");
//                break;
//            case MotionEvent.ACTION_HOVER_EXIT://10
//                Log.i("lifeCycleTest", "[container] -> ACTION_HOVER_EXIT = " + "[" + super.onTouchEvent(event) + "]");
//                break;
//            case MotionEvent.ACTION_BUTTON_PRESS://11
//                Log.i("lifeCycleTest", "[container] -> ACTION_BUTTON_PRESS = " + "[" + super.onTouchEvent(event) + "]");
//                break;
//            case MotionEvent.ACTION_BUTTON_RELEASE://12
//                Log.i("lifeCycleTest", "[container] -> ACTION_BUTTON_RELEASE = " + "[" + super.onTouchEvent(event) + "]");
//                break;
//        }
////        viewDragHelper.processTouchEvent(event);
//        return super.onTouchEvent(event);
//    }
}
