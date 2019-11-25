package yincheng.tinytank.common;

import java.util.concurrent.Callable;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:05:18 8:45
 * Github : yincheng.luo
 */
public class GenericItemHolder<T> {
	private String title;
	private ITEM_CLASS_TYPE itemClassType;
	private Runnable mRunnable;
	private Callable<T> mCallable;
	private Class mClazz;
	private boolean hasDoc;
	private boolean isExtendFromRecyclerActivity = true;

	public enum ITEM_CLASS_TYPE {// TODO: 2018/5/24
		ACTIVITY, FRAGMENT, DIALOG_FRAGMENT, DIALOG, POPUP_WINDOW,
		NONE
	}

	public String getTitle() {
		return title;
	}

	public ITEM_CLASS_TYPE getItemClassType() {
		return itemClassType;
	}

	public Runnable getmRunnable() {
		return mRunnable;
	}

	public Callable<T> getmCallable() {
		return mCallable;
	}

	public Class getmClazz() {
		return mClazz;
	}

	public boolean isHasDoc() {
		return hasDoc;
	}

	public GenericItemHolder(String title) {
		this(title, ITEM_CLASS_TYPE.ACTIVITY);
	}

	public GenericItemHolder(String title, boolean hasDoc, boolean isExtendFromRecyclerActivity) {
		this(title, hasDoc);
		this.isExtendFromRecyclerActivity = isExtendFromRecyclerActivity;
	}

	public GenericItemHolder(String title, boolean hasDoc) {
		this(title, ITEM_CLASS_TYPE.ACTIVITY, hasDoc);
	}

	public GenericItemHolder(String title, ITEM_CLASS_TYPE item_class_type) {
		this(title, item_class_type, false);
	}

	public GenericItemHolder(String title, ITEM_CLASS_TYPE item_class_type, Callable<T> callable) {
		this(title, item_class_type, false);
		this.mCallable = callable;
		this.isExtendFromRecyclerActivity = true;
	}

	public GenericItemHolder(String title, ITEM_CLASS_TYPE item_class_type, Class clazz) {
		this(title, item_class_type, false);
		this.mClazz = clazz;
		this.isExtendFromRecyclerActivity = true;
	}

	public GenericItemHolder(String title, ITEM_CLASS_TYPE classType, boolean hasDoc) {
		this.title = title;
		this.itemClassType = classType;
		this.hasDoc = hasDoc;
		this.isExtendFromRecyclerActivity = true;
	}

	public GenericItemHolder(String title, boolean hasDoc, Runnable runnable) {
		this.title = title;
		this.hasDoc = hasDoc;
		this.mRunnable = runnable;
		this.isExtendFromRecyclerActivity = true;
	}
}
