package yincheng.tinytank.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.Nullable;


public class PathView extends BaseView {
	private Paint mPaint;
	private Path mPath;
	private int bezierMarginTop = 250;//最高点距离顶部的距离
	private int thirdPointY;

	public PathView(Context context) {
		this(context, null);
	}

	public PathView(Context context, @Nullable AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public PathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
	}

	private void init() {
		mPaint = new Paint();
		mPaint.setStyle(Paint.Style.FILL);
		mPaint.setColor(Color.parseColor("#3c5f78"));
		mPaint.setAntiAlias(true);
		mPath = new Path();
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		thirdPointY = getMeasuredHeight();
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		mPath.reset();
		mPath.moveTo(0, bezierMarginTop);
		mPath.quadTo(getMeasuredWidth() / 2, thirdPointY, getMeasuredWidth(), bezierMarginTop);
		mPath.lineTo(getMeasuredWidth(), getMeasuredHeight());
		mPath.lineTo(0, getMeasuredHeight());
		mPath.close();
		canvas.drawPath(mPath, mPaint);
	}

	private float downY;
	private float nowY;
	private float preY;

	public void answerFinger(MotionEvent event) {
		switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				downY = event.getY();
				nowY = downY;
				break;
			case MotionEvent.ACTION_MOVE:
				preY = nowY;
				nowY = event.getY();
				if (nowY - downY <= 0) return;//不允许往上，只是下拉刷新
				getDampHeight(nowY - downY, preY - downY);//下一步执行完成的真实高度(带阻尼效果)基于之前的高度来计算
				if (thirdPointY > getMeasuredHeight() * 2 - bezierMarginTop || thirdPointY < getMeasuredHeight())
					return;
				invalidate();
				break;
			case MotionEvent.ACTION_UP:
				reset();
				break;
		}
	}

	/**
	 * 根据滑动的距离占recyclerview高度的比率来控制 pathview的高度
	 */
	private void getDampHeight(float currentYPosition, float preYPosition) {
		float ratio = 1.0f - (1.0f * currentYPosition / 1000);
		thirdPointY += (int) (currentYPosition - preYPosition) * ratio * ratio;
	}

	private void reset() {
		thirdPointY = getMeasuredHeight();
		invalidate();
		nowY = 0;
		preY = 0;
	}
}
