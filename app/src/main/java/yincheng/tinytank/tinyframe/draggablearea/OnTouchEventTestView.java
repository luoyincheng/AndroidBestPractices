package yincheng.tinytank.tinyframe.draggablearea;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class OnTouchEventTestView extends View {
	private static final String TAG = "onTouchEventTest";

	public OnTouchEventTestView(Context context) {
		super(context);
	}

	public OnTouchEventTestView(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
	}

	public OnTouchEventTestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	public OnTouchEventTestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getActionMasked()) {
			case MotionEvent.ACTION_DOWN:
				Log.i(TAG, "ACTION_DOWN");
				break;
			case MotionEvent.ACTION_MOVE:
				Log.i(TAG, "ACTION_MOVE");

				break;
			case MotionEvent.ACTION_UP:
				Log.i(TAG, "ACTION_UP");

				break;
			case MotionEvent.ACTION_POINTER_DOWN:
				Log.i(TAG, "ACTION_POINTER_DOWN");

				break;
			case MotionEvent.ACTION_POINTER_UP:
				Log.i(TAG, "ACTION_POINTER_UP");

				break;
			case MotionEvent.ACTION_POINTER_INDEX_MASK:
				Log.i(TAG, "ACTION_POINTER_INDEX_MASK");

				break;
			case MotionEvent.ACTION_POINTER_INDEX_SHIFT:
				Log.i(TAG, "ACTION_POINTER_INDEX_SHIFT");

				break;
		}
//        Log.i(TAG, "super.onTouchEvent(event):" + super.onTouchEvent(event));
		return true;
	}
}
