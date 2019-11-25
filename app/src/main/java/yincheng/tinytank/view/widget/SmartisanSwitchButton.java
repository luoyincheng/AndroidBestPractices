package yincheng.tinytank.view.widget;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;

import androidx.annotation.Nullable;

import yincheng.tinytank.R;
import yincheng.tinytank.view.BaseView;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:04:26 22:00
 * Github : yincheng.luo
 */
public class SmartisanSwitchButton extends BaseView {
	private RectF rectFLeft, rectFRight;
	private float measuredHeight = 200f;
	private float innerShadowWidth = 5;

	private float innerViewRealWidth;

	public SmartisanSwitchButton(Context context) {
		this(context, null);
	}

	public SmartisanSwitchButton(Context context, @Nullable AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public SmartisanSwitchButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		initBase();
	}

	public void initBase() {
		setLayerType(LAYER_TYPE_SOFTWARE, null);
		mBaseStrokePaint.setColor(getResources().getColor(R.color.white));
		mBaseStrokePaint.setStrokeWidth(4);
		mBaseStrokePaint.setMaskFilter(new BlurMaskFilter(6, BlurMaskFilter.Blur.INNER));
		rectFLeft = new RectF(2, 2, 200 - 2, 200 - 2);// TODO: 2018/4/26 为什么这里传入measuredHeight不行
		rectFRight = new RectF(800 + 2, 0 + 2, 1000 - 2, 200 - 2);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

	@Override
	protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
		super.onLayout(changed, left, top, right, bottom);
	}


	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		drawBorder(canvas);
	}

	private void drawBorder(Canvas canvas) {
		mBasePath.arcTo(rectFLeft, 90, 180);
		mBasePath.lineTo(900, 0);
		mBasePath.arcTo(rectFRight, -90, 180);
		mBasePath.close();
		canvas.drawPath(mBasePath, mBaseStrokePaint);
	}

}
