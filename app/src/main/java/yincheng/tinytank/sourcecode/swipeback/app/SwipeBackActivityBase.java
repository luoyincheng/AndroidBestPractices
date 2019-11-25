package yincheng.tinytank.sourcecode.swipeback.app;


import yincheng.tinytank.sourcecode.swipeback.SwipeBackLayout;

/**
 * @author Yrom
 */
public interface SwipeBackActivityBase {
	/**
	 * @return the SwipeBackLayout associated with this activity.
	 */
	SwipeBackLayout getSwipeBackLayout();

	void setSwipeBackEnable(boolean enable);

	/**
	 * Scroll out contentView and finish the activity
	 */
	void scrollToFinishActivity();

}
