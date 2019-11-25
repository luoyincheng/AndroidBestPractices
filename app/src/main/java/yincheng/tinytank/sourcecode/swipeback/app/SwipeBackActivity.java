package yincheng.tinytank.sourcecode.swipeback.app;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import yincheng.tinytank.common.annotation.Recite;
import yincheng.tinytank.sourcecode.swipeback.SwipeBackLayout;
import yincheng.tinytank.sourcecode.swipeback.Utils;

public abstract class SwipeBackActivity extends AppCompatActivity implements SwipeBackActivityBase {
	private SwipeBackActivityHelper mHelper;//将Activity和SwipeBackLayout联系起来

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mHelper = new SwipeBackActivityHelper(this);//Activity是SwipeBackActivityHelper的成员
		mHelper.onActivityCreate();//创建一个SwipebackLayout
	}

	@Recite
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		mHelper.onPostCreate();//attachToActivity(),具体的联系Activity和SwipeBackLayout的方法
	}

	@Override
	public View findViewById(int id) {
		View v = super.findViewById(id);
		if (v == null && mHelper != null)
			return mHelper.findViewById(id);
		return v;
	}

	@Override
	public SwipeBackLayout getSwipeBackLayout() {
		return mHelper.getSwipeBackLayout();
	}

	@Override
	public void setSwipeBackEnable(boolean enable) {
		getSwipeBackLayout().setEnableGesture(enable);
	}

	@Override
	public void scrollToFinishActivity() {
		Utils.convertActivityToTranslucent(this);
		getSwipeBackLayout().scrollToFinishActivity();
	}
}
