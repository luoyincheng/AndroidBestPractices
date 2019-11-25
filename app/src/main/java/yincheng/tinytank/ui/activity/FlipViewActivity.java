package yincheng.tinytank.ui.activity;

import butterknife.BindView;
import yincheng.tinytank.R;
import yincheng.tinytank.ui.activity.base.BaseActivity;
import yincheng.tinytank.view.flipView.FlipTextView;

import static yincheng.tinytank.provider.ItemHolderProvider.testStringList;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:04:22 21:19
 * Github : yincheng.luo
 */
public class FlipViewActivity extends BaseActivity {
	@BindView(R.id.fliptextview)
	FlipTextView fliptextview;

	@Override
	protected int getLayoutId() {
		return R.layout.activity_flipview;
	}

	@Override
	protected void initData() {
		fliptextview.addNotice(testStringList);
		fliptextview.startFlipping();
	}

	@Override
	protected void initView() {

	}
}
