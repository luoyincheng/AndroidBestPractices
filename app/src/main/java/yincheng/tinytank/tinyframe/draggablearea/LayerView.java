package yincheng.tinytank.tinyframe.draggablearea;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

import androidx.annotation.Nullable;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import yincheng.tinytank.R;
import yincheng.tinytank.sourcecode.timer.Timer;
import yincheng.tinytank.sourcecode.timer.TimerTask;

import static yincheng.tinytank.ui.activity.AlignmentTestActivity.TOUCH_EVENT_TAG;

public class LayerView extends SubSamplingScaleImageView {
	DraggableAreaWithAlignmentLine mParent;
	GestureDetector gestureDetector;
	LayerView thisLayerView;
	RectF borderRect = new RectF();
	RectF leftTopRect = new RectF();
	RectF rightTopRect = new RectF();
	RectF leftBottomRect = new RectF();
	RectF rightBottomRect = new RectF();
	Paint borderPaint = new Paint();
	int borderWidth = 10;//实际显示的边框宽度是borderWidth的一半
	// TODO: 2018/11/4 边框的绘制会导致图片的一部分被遮挡，是否选择性改变图片的显示区域
	// TODO: 2018/11/4 边框的颜色有时会跟图片颜色相仿，导致边框看不清楚，(动态改变边框的颜色)
	int floor;
	float mRotation = 0.0f;
	boolean isEnabledOperation = false;
	boolean isDealMotionEventSelf = true;
	float actionDownX = 0.0f, actionDownY = 0.0f;
	Matrix mMatrix = getMatrix();
	// region [twinkling task]
	Handler handler = new Handler(Looper.getMainLooper());
	Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			thisLayerView.setRotation(++mRotation);
		}
	};
	Timer timer = new Timer();
	TimerTask timerTask = new TimerTask() {
		@Override
		public void run() {
			mHandler.sendEmptyMessage(1);
		}
	};

	public LayerView(Context context) {
		this(context, null);
	}

	public LayerView(Context context, @Nullable AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public LayerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		if (attrs != null) {
			TypedArray tp = context.obtainStyledAttributes(attrs, R.styleable.LayerView);
			try {
				floor = tp.getInt(R.styleable.LayerView_floor, 1);
			} finally {
				tp.recycle();
			}
		}
		mParent = (DraggableAreaWithAlignmentLine) getParent();
		init();
	}

	private void init() {
		thisLayerView = this;
		mMatrix = thisLayerView.getMatrix();
		borderPaint.setAntiAlias(true);
		borderPaint.setColor(Color.parseColor("#ffff0000"));
		borderPaint.setStyle(Paint.Style.STROKE);
		borderPaint.setStrokeWidth(borderWidth);

//        timer.schedule(timerTask, 0, 1);
	}
	// endregion

	public void applyMatrix() {
//		RectF rectF = new RectF(this.getLeft(),this.getTop(),this.getRight(),this.getBottom());
//		this.getMatrix().postScale(0.8f,0.8f);
	}

	private void starkTwink() {
		for (int i = 0; i < 1000; i++)
			handler.postDelayed(new TwinklingTask(), 50 * i);
	}

	private boolean isRunningUiThread() {
		return Looper.getMainLooper() == Looper.myLooper();
	}

	/**
	 * 无论在子View中对事件如何处理,ActionUp事件在任何时候都会传递到ViewGroup和Activity中去.
	 * (1)返回true
	 * disPatchTouchEvent如果返回true就会直接消费掉所有event/事件流
	 * (该View和包含它的所有ViewGroup、Activity都不会收到ActionDown和ActionMove事件,但一定会收到ActionUp事件),不会再传递给onTouchEvent。
	 * 参见:TinyTank/app/src/main/assets/touchevent/view_dispatchtouchevent_true.png
	 * (2)返回false
	 * 则事件流全部上溯,跟onTouchEvent()返回值无关
	 * (3)返回super
	 * 如果View要拦截Event,使得event消费在View的onTouchEvent中，由于View中没有onInterceptTouchEvent，怎么样传递给当前View的onTouchEvent呢？
	 * 答案是通过调用super.dispatchTouchEvent（在其内部调用到onTouchEvent）。
	 * 如果onTouchEvent()返回true,则事件流中的事件都会在onTouchEvent()处理
	 * 如果onTouchEvent()返回false,则只有ActionDown事件会由该View处理,其余事件上溯
	 */
//    @Override
//    public boolean dispatchTouchEvent(MotionEvent event) {
//        Log.i(TOUCH_EVENT_TAG, "[  child   ] ==> dispatchTouchEvent:" + "[false]");
//        return false;
//        Log.i(TOUCH_EVENT_TAG, "[  child   ] ==> dispatchTouchEvent:" + "[true");
//        return true;
//        Log.i(TOUCH_EVENT_TAG, "[  child   ] ==> dispatchTouchEvent:" + "[" + super.dispatchTouchEvent(event) + "]");
//        return super.dispatchTouchEvent(event);
//    }
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN://0
				Log.i(TOUCH_EVENT_TAG, "[  child   ] ==> ACTION_DOWN ");
				actionDownX = event.getX();
				actionDownY = event.getY();
				break;
			case MotionEvent.ACTION_UP://1
				Log.i(TOUCH_EVENT_TAG, "[  child   ] ==> ACTION_UP ");
				break;
			case MotionEvent.ACTION_MOVE://2
				Log.i(TOUCH_EVENT_TAG, "[  child   ] ==> ACTION_MOVE ");
				break;
			case MotionEvent.ACTION_CANCEL://3
				Log.i(TOUCH_EVENT_TAG, "[  child   ] ==> ACTION_CANCEL ");
				break;
			case MotionEvent.ACTION_OUTSIDE://4
				Log.i(TOUCH_EVENT_TAG, "[  child   ] ==> ACTION_OUTSIDE ");
				break;
			case MotionEvent.ACTION_POINTER_DOWN://5
				Log.i(TOUCH_EVENT_TAG, "[  child   ] ==> ACTION_POINTER_DOWN ");
				break;
			case MotionEvent.ACTION_POINTER_UP://6
				Log.i(TOUCH_EVENT_TAG, "[  child   ] ==> ACTION_POINTER_UP ");
				break;
			case MotionEvent.ACTION_HOVER_MOVE://7
				Log.i(TOUCH_EVENT_TAG, "[  child   ] ==> ACTION_HOVER_MOVE ");
				break;
			case MotionEvent.ACTION_SCROLL://8
				Log.i(TOUCH_EVENT_TAG, "[  child   ] ==> ACTION_SCROLL ");
				break;
			case MotionEvent.ACTION_HOVER_ENTER://9
				Log.i(TOUCH_EVENT_TAG, "[  child   ] ==> ACTION_HOVER_ENTER ");
				break;
			case MotionEvent.ACTION_HOVER_EXIT://10
				Log.i(TOUCH_EVENT_TAG, "[  child   ] ==> ACTION_HOVER_EXIT ");
				break;
			case MotionEvent.ACTION_BUTTON_PRESS://11
				Log.i(TOUCH_EVENT_TAG, "[  child   ] ==> ACTION_BUTTON_PRESS ");
				break;
			case MotionEvent.ACTION_BUTTON_RELEASE://12
				Log.i(TOUCH_EVENT_TAG, "[  child   ] ==> ACTION_BUTTON_RELEASE ");
				break;
		}
//        Log.i(TOUCH_EVENT_TAG, "[  child   ] ==> onTouchEvent:" + "[false]");
//        return false;
//        Log.i(TOUCH_EVENT_TAG, "[  child   ] ==> onTouchEvent:" + "[true]");
//        return true;
//        Log.i(TOUCH_EVENT_TAG, "[  child   ] ==> onTouchEvent:" + "[" + super.onTouchEvent(event) + "]");
//        return super.onTouchEvent(event);
		return false;
	}

	// TODO: 19-4-19 setlayertype()
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		setMeasuredDimension(400, 300);
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		Log.i("lifeCycleTest", "onSizeChanged");
		super.onSizeChanged(w, h, oldw, oldh);
//        Glide.with(this)
//                .load(R.mipmap.landscape)
//                .apply(RequestOptions.bitmapTransform(new RotateTransformation()))
//                .into(this);
	}

	@Override
	protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
		Log.i("lifeCycleTest", "onLayout" + ":" + this.getLeft() + ":" + this.getTop() + ":" + this.getRight() + ":" + this.getBottom());
		super.onLayout(changed, left, top, right, bottom);
		borderRect.set(0, 0, getWidth(), getHeight());

		leftTopRect.set(0, 0, borderRect.centerX(), borderRect.centerY());
		rightTopRect.set(borderRect.centerX(), 0, borderRect.right, borderRect.centerY());
		leftBottomRect.set(0, borderRect.centerY(), borderRect.centerX(), borderRect.bottom);
		rightBottomRect.set(borderRect.centerX(), borderRect.centerY(), borderRect.right, borderRect.bottom);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		Log.i("lifeCycleTest", "onDraw[" + ":" + this.getLeft() + ":" + this.getTop() + ":" + this.getRight() + ":" + this.getBottom() + ":" + isEnabledOperation);
		Log.i("lifeCycleTest", "onDraw]" + ":" + borderRect.left + ":" + borderRect.top + ":" + borderRect.right + ":" + borderRect.bottom);
		super.onDraw(canvas);
		if (isEnabledOperation) {
			borderPaint.setStyle(Paint.Style.STROKE);
			borderPaint.setStrokeWidth(borderWidth);
			borderPaint.setColor(Color.parseColor("#ff0000"));
			canvas.drawRect(borderRect, borderPaint);

			borderPaint.setStrokeWidth(borderWidth * 0.5f);
			canvas.drawLine(borderRect.centerX(), 0, borderRect.centerX(), getHeight(), borderPaint);
			canvas.drawLine(0, borderRect.centerY(), getWidth(), borderRect.centerY(), borderPaint);

			borderPaint.setStyle(Paint.Style.FILL);
			borderPaint.setColor(Color.parseColor("#000000"));
			canvas.drawCircle(leftTopRect.centerX(), leftTopRect.centerY(), leftTopRect.centerY() * 0.75f, borderPaint);
			canvas.drawCircle(rightTopRect.centerX(), rightTopRect.centerY(), leftTopRect.centerY() * 0.75f, borderPaint);
			canvas.drawCircle(leftBottomRect.centerX(), leftBottomRect.centerY(), leftTopRect.centerY() * 0.75f, borderPaint);
			canvas.drawCircle(rightBottomRect.centerX(), rightBottomRect.centerY(), leftTopRect.centerY() * 0.75f, borderPaint);
		}
	}

	public boolean isOperateEnabled() {
		return isEnabledOperation;
	}

	public void disableOperation() {
		isEnabledOperation = false;
		invalidate();
	}

	public void onClicked() {
		isEnabledOperation = !isEnabledOperation;
		applyMatrix();
//		starkTwink();
		invalidate();
	}

	public void onDoubleClick() {

	}

	void updateRotation() {
		Observable
				.create(new ObservableOnSubscribe<Integer>() {
					@Override
					public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {

					}
				}).subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe();
	}

	class TwinklingTask implements Runnable {

		@Override
		public void run() {
			Log.i("TwinklingTask", isRunningUiThread() + "");
			isEnabledOperation = !isEnabledOperation;
			invalidate();
		}
	}
}
