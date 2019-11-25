package yincheng.tinytank.sourcecode.swipeback;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.core.view.ViewCompat;

import java.util.ArrayList;
import java.util.List;

import yincheng.tinytank.R;
import yincheng.tinytank.sourcecode.swipeback.app.SwipeBackListenerActivityAdapter;


/**
 * Created by yincheng on 2018/6/19/16:37.
 * github:luoyincheng
 */
public class SwipeBackLayout extends FrameLayout {
	/**
	 * Minimum velocity that will be detected as a fling
	 */
	private static final int MIN_FLING_VELOCITY = 400; // dips per second

	private static final int DEFAULT_SCRIM_COLOR = 0x99000000;

	private static final int FULL_ALPHA = 255;

	/**
	 * Edge flag indicating that the left edge should be affected.
	 */
	public static final int EDGE_LEFT = ViewDragHelper.EDGE_LEFT;

	/**
	 * Edge flag indicating that the right edge should be affected.
	 */
	public static final int EDGE_RIGHT = ViewDragHelper.EDGE_RIGHT;

	/**
	 * Edge flag indicating that the bottom edge should be affected.
	 */
	public static final int EDGE_BOTTOM = ViewDragHelper.EDGE_BOTTOM;

	/**
	 * Edge flag set indicating all edges should be affected.
	 */
	public static final int EDGE_ALL = EDGE_LEFT | EDGE_RIGHT | EDGE_BOTTOM;

	/**
	 * A view is not currently being dragged or animating as a result of a
	 * fling/snap.
	 */
	public static final int STATE_IDLE = ViewDragHelper.STATE_IDLE;

	/**
	 * A view is currently being dragged. The position is currently changing as
	 * a result of user input or simulated user input.
	 */
	public static final int STATE_DRAGGING = ViewDragHelper.STATE_DRAGGING;

	/**
	 * A view is currently settling into place as a result of a fling or
	 * predefined non-interactive motion.
	 */
	public static final int STATE_SETTLING = ViewDragHelper.STATE_SETTLING;

	/**
	 * Default threshold of scroll
	 */
	private static final float DEFAULT_SCROLL_THRESHOLD = 0.3f;

	private static final int OVERSCROLL_DISTANCE = 10;

	private static final int[] EDGE_FLAGS = {
			EDGE_LEFT, EDGE_RIGHT, EDGE_BOTTOM, EDGE_ALL
	};

	private int mEdgeFlag;

	//阈值
	private float mScrollThreshold = DEFAULT_SCROLL_THRESHOLD;

	private Activity mActivity;

	private boolean mEnable = true;

	private View mContentView;

	private ViewDragHelper mDragHelper;

	private float mScrollPercent;

	private int mContentLeft;

	private int mContentTop;

	/**
	 * The set of listeners to be sent events through.
	 */
	private List<SwipeListener> mListeners;

	private Drawable mShadowLeft;

	private Drawable mShadowRight;

	private Drawable mShadowBottom;

	private float mScrimOpacity;

	private int mScrimColor = DEFAULT_SCRIM_COLOR;

	private boolean mInLayout;

	private Rect mTmpRect = new Rect();

	/**
	 * Edge being dragged
	 */
	private int mTrackingDirection;

	public SwipeBackLayout(Context context) {
		this(context, null);
	}

	public SwipeBackLayout(Context context, AttributeSet attrs) {
		this(context, attrs, R.attr.SwipeBackLayoutStyle);
	}

	public SwipeBackLayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs);
		mDragHelper = ViewDragHelper.create(this, new ViewDragCallback());

		TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SwipeBackLayout, defStyle,
				R.style.SwipeBackLayout);

		int edgeSize = a.getDimensionPixelSize(R.styleable.SwipeBackLayout_edge_size, -1);
		if (edgeSize > 0)
			setEdgeSize(edgeSize);
		int mode = EDGE_FLAGS[a.getInt(R.styleable.SwipeBackLayout_edge_flag, 0)];
		setEdgeTrackingEnabled(mode);

		int shadowLeft = a.getResourceId(R.styleable.SwipeBackLayout_shadow_left,
				R.drawable.shadow_left);
		int shadowRight = a.getResourceId(R.styleable.SwipeBackLayout_shadow_right,
				R.drawable.shadow_right);
		int shadowBottom = a.getResourceId(R.styleable.SwipeBackLayout_shadow_bottom,
				R.drawable.shadow_bottom);
		setShadow(shadowLeft, EDGE_LEFT);
		setShadow(shadowRight, EDGE_RIGHT);
		setShadow(shadowBottom, EDGE_BOTTOM);
		a.recycle();
		final float density = getResources().getDisplayMetrics().density;
		final float minVel = MIN_FLING_VELOCITY * density;
		mDragHelper.setMinVelocity(minVel);
		mDragHelper.setMaxVelocity(minVel * 2f);
	}

	/**
	 * Sets the sensitivity of the NavigationLayout.
	 *
	 * @param context     The application context.
	 * @param sensitivity value between 0 and 1, the final value for touchSlop =
	 *                    ViewConfiguration.getScaledTouchSlop * (1 / s);
	 */
	public void setSensitivity(Context context, float sensitivity) {
		mDragHelper.setSensitivity(context, sensitivity);
	}

	public void setContentView(View view) {
		mContentView = view;
	}

	public void setEnableGesture(boolean enable) {
		mEnable = enable;
	}

	/**
	 * Enable edge tracking for the selected edges of the parent view. The
	 * callback's
	 * {@link ViewDragHelper.Callback#onEdgeTouched(int, int)}
	 * and
	 * {@link ViewDragHelper.Callback#onEdgeDragStarted(int, int)}
	 * methods will only be invoked for edges for which edge tracking has been
	 * enabled.
	 *
	 * @param edgeFlags Combination of edge flags describing the edges to watch
	 * @see #EDGE_LEFT
	 * @see #EDGE_RIGHT
	 * @see #EDGE_BOTTOM
	 */
	public void setEdgeTrackingEnabled(int edgeFlags) {
		mEdgeFlag = edgeFlags;
		mDragHelper.setEdgeTrackingEnabled(mEdgeFlag);
	}

	/**
	 * Set a color to use for the scrim that obscures primary content while a
	 * drawer is open.
	 *
	 * @param color Color to use in 0xAARRGGBB format.
	 */
	public void setScrimColor(int color) {
		mScrimColor = color;
		invalidate();
	}

	/**
	 * Set the size of an edge. This is the range in pixels along the edges of
	 * this view that will actively detect edge touches or drags if edge
	 * tracking is enabled.
	 *
	 * @param size The size of an edge in pixels
	 */
	public void setEdgeSize(int size) {
		mDragHelper.setEdgeSize(size);
	}

	/**
	 * Register a callback to be invoked when a swipe event is sent to this
	 * view.
	 *
	 * @param listener the swipe listener to attach to this view
	 * @deprecated use {@link #addSwipeListener} instead
	 */
	@Deprecated
	public void setSwipeListener(SwipeListener listener) {
		addSwipeListener(listener);
	}

	/**
	 * Add a callback to be invoked when a swipe event is sent to this view.
	 *
	 * @param listener the swipe listener to attach to this view
	 */
	public void addSwipeListener(SwipeListener listener) {
		if (mListeners == null) {
			mListeners = new ArrayList<SwipeListener>();
		}
		mListeners.add(listener);
	}

	public void removeSwipeListener(SwipeListener listener) {
		if (mListeners != null)
			mListeners.remove(listener);
	}

	public interface SwipeListener {
		void onScrollStateChanged(int state, float scrollPercent);

		void onEdgeTouched(int edgeFlag);

		/**
		 * Invoke when scroll percent over the threshold for the first time
		 */
		void onScrollOverThreshold();
	}

	public interface SwipeListenerEx extends SwipeListener {
		void onContentViewSwipedBack();
	}

	public void setScrollThresHold(float threshold) {
		if (threshold >= 1.0f || threshold <= 0) {
			throw new IllegalArgumentException("Threshold value should be between 0 and 1.0");
		}
		mScrollThreshold = threshold;
	}

	public void setShadow(Drawable shadow, int edgeFlag) {
		if ((edgeFlag & EDGE_LEFT) != 0) {
			mShadowLeft = shadow;
		} else if ((edgeFlag & EDGE_RIGHT) != 0) {
			mShadowRight = shadow;
		} else if ((edgeFlag & EDGE_BOTTOM) != 0) {
			mShadowBottom = shadow;
		}
		invalidate();
	}

	public void setShadow(int resId, int edgeFlag) {
		setShadow(getResources().getDrawable(resId), edgeFlag);
	}

	/**
	 * Scroll out contentView and finish the activity
	 */
	public void scrollToFinishActivity() {
		final int childWidth = mContentView.getWidth();
		final int childHeight = mContentView.getHeight();

		int left = 0, top = 0;
		if ((mEdgeFlag & EDGE_LEFT) != 0) {
			left = childWidth + mShadowLeft.getIntrinsicWidth() + OVERSCROLL_DISTANCE;
			mTrackingDirection = EDGE_LEFT;
		} else if ((mEdgeFlag & EDGE_RIGHT) != 0) {
			left = -childWidth - mShadowRight.getIntrinsicWidth() - OVERSCROLL_DISTANCE;
			mTrackingDirection = EDGE_RIGHT;
		} else if ((mEdgeFlag & EDGE_BOTTOM) != 0) {
			top = -childHeight - mShadowBottom.getIntrinsicHeight() - OVERSCROLL_DISTANCE;
			mTrackingDirection = EDGE_BOTTOM;
		}

		mDragHelper.smoothSlideViewTo(mContentView, left, top);
		invalidate();
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent event) {
		if (!mEnable) {
			return false;
		}
		try {
			return mDragHelper.shouldInterceptTouchEvent(event);
		} catch (ArrayIndexOutOfBoundsException e) {
			// FIXME: handleBusiness exception
			// issues #9
			return false;
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (!mEnable) {
			return false;
		}
		mDragHelper.processTouchEvent(event);
		return true;
	}

	@Override
	protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
		mInLayout = true;
		if (mContentView != null)
			mContentView.layout(mContentLeft, mContentTop,
					mContentLeft + mContentView.getMeasuredWidth(),
					mContentTop + mContentView.getMeasuredHeight());
		mInLayout = false;
	}

	@Override
	public void requestLayout() {
		if (!mInLayout) {
			super.requestLayout();
		}
	}

	@Override
	protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
		final boolean drawContent = child == mContentView;

		boolean ret = super.drawChild(canvas, child, drawingTime);
		if (mScrimOpacity > 0 && drawContent
				&& mDragHelper.getViewDragState() != ViewDragHelper.STATE_IDLE) {
			drawShadow(canvas, child);
			drawScrim(canvas, child);
		}
		return ret;
	}

	private void drawScrim(Canvas canvas, View child) {
		final int baseAlpha = (mScrimColor & 0xff000000) >>> 24;
		final int alpha = (int) (baseAlpha * mScrimOpacity);
		final int color = alpha << 24 | (mScrimColor & 0xffffff);

		if ((mTrackingDirection & EDGE_LEFT) != 0) {
			canvas.clipRect(0, 0, child.getLeft(), getHeight());
		} else if ((mTrackingDirection & EDGE_RIGHT) != 0) {
			canvas.clipRect(child.getRight(), 0, getRight(), getHeight());
		} else if ((mTrackingDirection & EDGE_BOTTOM) != 0) {
			canvas.clipRect(child.getLeft(), child.getBottom(), getRight(), getHeight());
		}
		canvas.drawColor(color);
	}

	private void drawShadow(Canvas canvas, View child) {
		final Rect childRect = mTmpRect;
		child.getHitRect(childRect);

		if ((mEdgeFlag & EDGE_LEFT) != 0) {
			mShadowLeft.setBounds(childRect.left - mShadowLeft.getIntrinsicWidth(), childRect.top,
					childRect.left, childRect.bottom);
			mShadowLeft.setAlpha((int) (mScrimOpacity * FULL_ALPHA));
			mShadowLeft.draw(canvas);
		}

		if ((mEdgeFlag & EDGE_RIGHT) != 0) {
			mShadowRight.setBounds(childRect.right, childRect.top,
					childRect.right + mShadowRight.getIntrinsicWidth(), childRect.bottom);
			mShadowRight.setAlpha((int) (mScrimOpacity * FULL_ALPHA));
			mShadowRight.draw(canvas);
		}

		if ((mEdgeFlag & EDGE_BOTTOM) != 0) {
			mShadowBottom.setBounds(childRect.left, childRect.bottom, childRect.right,
					childRect.bottom + mShadowBottom.getIntrinsicHeight());
			mShadowBottom.setAlpha((int) (mScrimOpacity * FULL_ALPHA));
			mShadowBottom.draw(canvas);
		}
	}

	/**
	 * 这个过程实际上是
	 * 1.取出Activity中已经存在的布局文件
	 * 2.将该布局文件添加到SwipeBackLayout中去，使得它具有了“SwipeBack”的属性
	 * 3.将该具有了swipeBack属性的布局文件再次添加DecorView中去,使得传进来的Activity(继承了SwipeBackActivity的Activity)
	 * 具有了SwipeBack的属性，that’s it
	 */
	public void attachToActivity(Activity activity) {
		mActivity = activity;
		TypedArray a = activity.getTheme().obtainStyledAttributes(new int[]{
				android.R.attr.windowBackground
		});
		int background = a.getResourceId(0, 0);//获取传进来的Activity的主题，为了将这个主题设置到将要被添加的View中去
		a.recycle();
		ViewGroup decor = (ViewGroup) activity.getWindow().getDecorView();
		ViewGroup decorChild = (ViewGroup) decor.getChildAt(0);
		decorChild.setBackgroundResource(background);//为要被添加的View 设置主题
		//将当前Activity中存在的View移除掉
		decor.removeView(decorChild);//想要添加一个View就必须先remove这个View，否则:The specified child already
		// has a parent
		//将当前Activity中的View添加到SwipeBackLayout中来
		addView(decorChild);//没有这一步Activity就是透明的，空的，盖住了桌面，启动了该App但是看到的仍然是桌面
		setContentView(decorChild);//不添加这一行结果:Unknown window type: 1001，这里是自定义的View
		addSwipeListener(new SwipeBackListenerActivityAdapter(activity));
		//然后再将添加了SwipeBackLayout的界面添加到DecorView中去
		decor.addView(this);
	}

	@Override
	public void computeScroll() {
		mScrimOpacity = 1 - mScrollPercent;
		if (mDragHelper.continueSettling(true)) {
			ViewCompat.postInvalidateOnAnimation(this);
		}
	}

	private class ViewDragCallback extends ViewDragHelper.Callback {
		private boolean mIsScrollOverValid;

		@Override
		public boolean tryCaptureView(View view, int i) {
			boolean ret = mDragHelper.isEdgeTouched(mEdgeFlag, i);
			if (ret) {
				if (mDragHelper.isEdgeTouched(EDGE_LEFT, i)) {
					mTrackingDirection = EDGE_LEFT;
				} else if (mDragHelper.isEdgeTouched(EDGE_RIGHT, i)) {
					mTrackingDirection = EDGE_RIGHT;
				} else if (mDragHelper.isEdgeTouched(EDGE_BOTTOM, i)) {
					mTrackingDirection = EDGE_BOTTOM;
				}
				if (mListeners != null && !mListeners.isEmpty()) {
					for (SwipeListener listener : mListeners) {
						listener.onEdgeTouched(mTrackingDirection);
					}
				}
				mIsScrollOverValid = true;
			}
			boolean directionCheck = false;
			if (mEdgeFlag == EDGE_LEFT || mEdgeFlag == EDGE_RIGHT) {
				directionCheck = !mDragHelper.checkTouchSlop(ViewDragHelper.DIRECTION_VERTICAL, i);
			} else if (mEdgeFlag == EDGE_BOTTOM) {
				directionCheck = !mDragHelper
						.checkTouchSlop(ViewDragHelper.DIRECTION_HORIZONTAL, i);
			} else if (mEdgeFlag == EDGE_ALL) {
				directionCheck = true;
			}
			return ret & directionCheck;
		}

		@Override
		public int getViewHorizontalDragRange(View child) {
			return mEdgeFlag & (EDGE_LEFT | EDGE_RIGHT);
		}

		@Override
		public int getViewVerticalDragRange(View child) {
			return mEdgeFlag & EDGE_BOTTOM;
		}

		@Override
		public void onViewPositionChanged(View changedView, int left, int top, int dx, int dy) {
			super.onViewPositionChanged(changedView, left, top, dx, dy);
			if ((mTrackingDirection & EDGE_LEFT) != 0) {
				mScrollPercent = Math.abs((float) left
						/ (mContentView.getWidth() + mShadowLeft.getIntrinsicWidth()));
			} else if ((mTrackingDirection & EDGE_RIGHT) != 0) {
				mScrollPercent = Math.abs((float) left
						/ (mContentView.getWidth() + mShadowRight.getIntrinsicWidth()));
			} else if ((mTrackingDirection & EDGE_BOTTOM) != 0) {
				mScrollPercent = Math.abs((float) top
						/ (mContentView.getHeight() + mShadowBottom.getIntrinsicHeight()));
			}
			mContentLeft = left;
			mContentTop = top;
			invalidate();
			if (mScrollPercent < mScrollThreshold && !mIsScrollOverValid) {
				mIsScrollOverValid = true;
			}

			if (mListeners != null && !mListeners.isEmpty()) {
				for (SwipeListener listener : mListeners) {
					listener.onScrollStateChanged(mDragHelper.getViewDragState(), mScrollPercent);
				}
			}

			if (mListeners != null && !mListeners.isEmpty()
					&& mDragHelper.getViewDragState() == STATE_DRAGGING
					&& mScrollPercent >= mScrollThreshold && mIsScrollOverValid) {
				mIsScrollOverValid = false;
				for (SwipeListener listener : mListeners) {
					listener.onScrollOverThreshold();
				}
			}

			if (mScrollPercent >= 1) {
				if (null != mListeners && !mListeners.isEmpty()) {
					for (SwipeListener listener : mListeners) {
						if (listener instanceof SwipeListenerEx) {
							((SwipeListenerEx) listener).onContentViewSwipedBack();
						}
					}
				}
			}
		}

		@Override
		public void onViewReleased(View releasedChild, float xvel, float yvel) {
			final int childWidth = releasedChild.getWidth();
			final int childHeight = releasedChild.getHeight();

			int left = 0, top = 0;
			if ((mTrackingDirection & EDGE_LEFT) != 0) {
				left = xvel > 0 || xvel == 0 && mScrollPercent > mScrollThreshold ? childWidth
						+ mShadowLeft.getIntrinsicWidth() + OVERSCROLL_DISTANCE : 0;
			} else if ((mTrackingDirection & EDGE_RIGHT) != 0) {
				left = xvel < 0 || xvel == 0 && mScrollPercent > mScrollThreshold ? -(childWidth
						+ mShadowLeft.getIntrinsicWidth() + OVERSCROLL_DISTANCE) : 0;
			} else if ((mTrackingDirection & EDGE_BOTTOM) != 0) {
				top = yvel < 0 || yvel == 0 && mScrollPercent > mScrollThreshold ? -(childHeight
						+ mShadowBottom.getIntrinsicHeight() + OVERSCROLL_DISTANCE) : 0;
			}

			mDragHelper.settleCapturedViewAt(left, top);
			invalidate();
		}

		@Override
		public int clampViewPositionHorizontal(View child, int left, int dx) {
			int ret = 0;
			if ((mTrackingDirection & EDGE_LEFT) != 0) {
				ret = Math.min(child.getWidth(), Math.max(left, 0));
			} else if ((mTrackingDirection & EDGE_RIGHT) != 0) {
				ret = Math.min(0, Math.max(left, -child.getWidth()));
			}
			return ret;
		}

		@Override
		public int clampViewPositionVertical(View child, int top, int dy) {
			int ret = 0;
			if ((mTrackingDirection & EDGE_BOTTOM) != 0) {
				ret = Math.min(0, Math.max(top, -child.getHeight()));
			}
			return ret;
		}

		@Override
		public void onViewDragStateChanged(int state) {
			super.onViewDragStateChanged(state);
			if (mListeners != null && !mListeners.isEmpty()) {
				for (SwipeListener listener : mListeners) {
					listener.onScrollStateChanged(state, mScrollPercent);
				}
			}
		}
	}
}
