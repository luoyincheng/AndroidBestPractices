package yincheng.tinytank.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;

public class SwipeRefreshLayout extends ViewGroup {
	public SwipeRefreshLayout(Context context) {
		super(context);
	}

	public SwipeRefreshLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public SwipeRefreshLayout(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	public SwipeRefreshLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
	}


	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		if (getChildCount() != 2) return;
		getChildAt(0).setLeft(0);
		getChildAt(0).setTop(0);
		getChildAt(0).setRight(1080);
		getChildAt(0).setBottom(getChildAt(0).getMeasuredHeight());

		Log.i("fafadf", getChildAt(0).getMeasuredHeight() + ":" + getChildAt(0).getHeight());
		getChildAt(1).setLeft(0);
		getChildAt(1).setTop(getChildAt(0).getMeasuredHeight());
		getChildAt(1).setRight(1080);
		getChildAt(1).setBottom(1920);

	}
}
