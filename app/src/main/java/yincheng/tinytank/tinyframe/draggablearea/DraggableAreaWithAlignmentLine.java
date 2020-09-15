package yincheng.tinytank.tinyframe.draggablearea;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import yincheng.tinytank.tinyframe.alignline.AdsorbHelper;

import static yincheng.tinytank.ui.activity.AlignmentTestActivity.TOUCH_EVENT_TAG;

/**
 * 当按下一个控件，调用流程是Activity.dispatchTouchEvent -> ViewGroup.dispatchTouchEvent ,
 * <p>
 * 1、ViewGroup.dispatchTouchEvent返回true会消费掉当前的event，不会调用当前ViewGroup的onTouchEvent。
 * 参见:TinyTank/app/src/main/assets/touchevent/viewgroup_dispatchtouchevent_true.png
 * <p>
 * 2、ViewGroup.dispatchTouchEvent返回false会调用父控件的onTouchEvent方法。并且逐级往上层回溯onTouchEvent。
 * 参见:TinyTank/app/src/main/assets/touchevent/viewgroup_dispatchtouchevent_true.png
 * <p>
 * 3、
 */
public class DraggableAreaWithAlignmentLine extends FrameLayout implements AdsorbHelper.OnAlignListener {
	DraggableAreaWithAlignmentLine mDraggableAreaWithAlignmentLine;
	AdsorbHelper mAdsorbHelper;
	SparseArray<LayerView> viewList = new SparseArray<>();

	Paint alignLinePaint = new Paint();
	int alignLineWidth = 4;
	/**
	 * AlignAbout-----------------------------------------------------------------------------------------------------------------------
	 */
	ArrayList<Integer> knownHorizontalLines = new ArrayList<>();
	ArrayList<Integer> knownVerticalLines = new ArrayList<>();

	public DraggableAreaWithAlignmentLine(Context context) {
		this(context, null);
	}

	public DraggableAreaWithAlignmentLine(Context context, @Nullable AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public DraggableAreaWithAlignmentLine(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
	}

	private void init() {
		mDraggableAreaWithAlignmentLine = this;
		mAdsorbHelper = new AdsorbHelper(this, true);
		mAdsorbHelper.mOnAlignListener = this;
		alignLinePaint.setAntiAlias(true);
		alignLinePaint.setStrokeWidth(alignLineWidth);
		alignLinePaint.setStyle(Paint.Style.STROKE);
		alignLinePaint.setColor(Color.parseColor("#ff000000"));
	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		for (int i = 0; i < getChildCount(); i++)
			viewList.put(((LayerView) getChildAt(i)).floor, (LayerView) getChildAt(i));
		this.removeAllViews();
		for (int i = 0; i < viewList.size(); i++)
			this.addView(viewList.get(i));
		/*
		 * 1.一个ViewGroup有多少子View，它的所有View中最大的layer就是该值(floor最小值为1)
		 * 1.所有在一层的view坐标不能有交集
		 * 2.view的layer属性改变之后需要重新调用onLayout方法，
		 * 3.
		 */
		View bottomBeauty = getChildAt(0);
		bottomBeauty.layout(0, 0, 800, 500);
		getChildAt(1).layout(100, 350, 900, 850);
		getChildAt(2).layout(200, 700, 1000, 1200);
		getChildAt(3).layout(300, 1050, 1080, 1550);
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
//        Log.i(TOUCH_EVENT_TAG, "{  parent  } ==> onInterceptTouchEvent" + ":" + "[false]");
//        return false;
//        Log.i(TOUCH_EVENT_TAG, "{  parent  } ==> onInterceptTouchEvent" + ":" + "[true]");
//        return true;
//        Log.i(TOUCH_EVENT_TAG, "{  parent  } ==> onInterceptTouchEvent" + ":" + "[" + super.onInterceptTouchEvent(ev) + "]");
//        return super.onInterceptTouchEvent(ev);
		Log.i(TOUCH_EVENT_TAG, "{  parent  } ==> onInterceptTouchEvent" + ":" + "[" + mAdsorbHelper.getViewDragHelper().shouldInterceptTouchEvent(ev) + "]");
		return mAdsorbHelper.getViewDragHelper().shouldInterceptTouchEvent(ev);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		mAdsorbHelper.onTouchEvent(event);
		return true;
	}

	/**
	 * TODO: 19-4-19 只要重写该方法就不能正常处理点击事件
	 */
//	@Override
//	public boolean dispatchTouchEvent(MotionEvent ev) {
//        Log.i(TOUCH_EVENT_TAG, "{  parent  } ==> dispatchTouchEvent" + ":" + "[false]");
//        return false;
//        Log.i(TOUCH_EVENT_TAG, "{  parent  } ==> dispatchTouchEvent" + ":" + "[true");
//        return true;
//        Log.i(TOUCH_EVENT_TAG, "{  parent  } ==> dispatchTouchEvent" + ":" + "[" + super.dispatchTouchEvent(ev) + "]");
//        return super.dispatchTouchEvent(ev);
//	}
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		for (Integer knownVerticalLine : knownVerticalLines)
			canvas.drawLine(knownVerticalLine, 0, knownVerticalLine, getBottom() - mDraggableAreaWithAlignmentLine.getTop(), alignLinePaint);
		for (Integer knownHorizontalLine : knownHorizontalLines) {
			canvas.drawLine(0, knownHorizontalLine, getRight() - mDraggableAreaWithAlignmentLine.getLeft(), knownHorizontalLine, alignLinePaint);
		}
	}

	// TODO: 2018/11/2 每个空间左上角显示当前位于哪一层
	private void exchangeViaFloor(int selectedFloor) {
		if (selectedFloor == 0) return;
		viewList.get(selectedFloor).floor = selectedFloor - 1;
		viewList.get(selectedFloor - 1).floor = selectedFloor;
		layout(0, 0, 0, 0);
	}

	@Override
	public void onAlignLineFound(@NotNull ArrayList<Integer> horizontalLines, @NotNull ArrayList<Integer> verticalLines) {
		Log.i("onAlignLineFound", "--------------->");
		knownVerticalLines = verticalLines;
		knownHorizontalLines = horizontalLines;
		invalidate();
	}
}

