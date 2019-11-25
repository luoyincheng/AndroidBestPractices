package yincheng.tinytank.ui.activity;

import android.widget.TextView;

import yincheng.tinytank.R;
import yincheng.tinytank.ui.activity.base.BaseActivity;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:04:24 21:08
 * Github : yincheng.luo
 */
public class DemoActivity extends BaseActivity {
	private TextView tv_anim;

	@Override
	protected int getLayoutId() {
		return R.layout.activity_demo;
	}

	@Override
	protected void initData() {
		tv_anim = findViewById(R.id.tv_anim);
	}

	@Override
	protected void initView() {

	}
}
