package yincheng.tinytank.ui.activity.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:04:04 8:11
 * Github : yincheng.luo
 */

public abstract class BaseActivity extends AppCompatActivity {
	Unbinder unbinder;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(getLayoutId());
		unbinder = ButterKnife.bind(this);
		getWindow().setBackgroundDrawable(null);
		initData();
		initView();
	}

	protected abstract int getLayoutId();

	protected abstract void initData();

	protected abstract void initView();

	@Override
	protected void onDestroy() {
		super.onDestroy();
		unbinder.unbind();
	}
}
