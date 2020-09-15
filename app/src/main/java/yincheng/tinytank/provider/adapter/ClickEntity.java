package yincheng.tinytank.provider.adapter;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by yincheng on 2018/5/24/18:16.
 * github:luoyincheng
 */
public class ClickEntity implements MultiItemEntity {
	public static final int CLICK_ITEM_VIEW = 1;
	public static final int CLICK_ITEM_CHILD_VIEW = 2;
	public static final int LONG_CLICK_ITEM_VIEW = 3;
	public static final int LONG_CLICK_ITEM_CHILD_VIEW = 4;
	public static final int NEST_CLICK_ITEM_CHILD_VIEW = 5;
	public boolean hasDoc;
	public int Type;
	private String title;
	private ITEM_CLASS_TYPE itemClassType;
	private Runnable mRunnable;


	public ClickEntity(String title, ITEM_CLASS_TYPE class_type, final int type, boolean hasDoc) {
		this.title = title;
		this.itemClassType = class_type;
		this.hasDoc = hasDoc;
		Type = type;
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

	public boolean isHasDoc() {
		return hasDoc;
	}

	public void setHasDoc(boolean hasDoc) {
		this.hasDoc = hasDoc;
	}

	@Override
	public int getItemType() {
		return Type;
	}

	public enum ITEM_CLASS_TYPE {// TODO: 2018/5/24 仿照代码家的viewanimation框架里面的给enmu中添加.class
		ACTIVITY, FRAGMENT, DIALOG_FRAGMENT, DIALOG, POPUP_WINDOW,
		NULL
	}
}