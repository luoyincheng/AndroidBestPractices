package yincheng.tinytank.ui.activity.base;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.orhanobut.logger.Logger;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import yincheng.tinytank.R;
import yincheng.tinytank.common.GenericItemHolder;
import yincheng.tinytank.provider.adapter.GenericAdapter;
import yincheng.tinytank.provider.helper.ActivityHelper;
import yincheng.tinytank.sourcecode.swipeback.app.SwipeBackActivity;
import yincheng.tinytank.ui.activity.MainActivity;
import yincheng.tinytank.ui.activity.MarkdownViewActivity;
import yincheng.tinytank.ui.dialog.BaseDialog;
import yincheng.tinytank.ui.dialog.ResultDialog;
import yincheng.tinytank.ui.dialogfragment.ShowResultDialogFragment;
import yincheng.tinytank.view.FontTextView;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:04:01 13:51
 * Github : yincheng.luo
 */

public abstract class GenericActivityWithRecyclerView<T extends Bundle> extends
		SwipeBackActivity implements ShowResultDialogFragment.onDialogListener {
	private final String TAG = getClass().getSimpleName();
	@BindView(R.id.backHome)
	public ImageView iv_backHome;
	@BindView(R.id.toolbar_title)
	public FontTextView toolbar_title;
	protected AppCompatActivity genericAppCompatActivityContext = this;
	@BindView(R.id.rv_generic)
	RecyclerView genericRecyclerView;
	private Unbinder unbinder;
	private ShowResultDialogFragment showResultDialogFragment;

	private AtomicBoolean isMdPathAdded = new AtomicBoolean(false);
	private String mdPathFromIntent;

	private GenericAdapter genericAdapter;
	private List<GenericItemHolder> genericItemHolders = getGenericItemHolders();
	private T resultData = fillResultData();
	private Handler mHandler;
	private Intent intent;
	private ResultDialog resultDialog;
	private BaseDialog baseDialog;

	protected abstract List<GenericItemHolder> getGenericItemHolders();

	protected T fillResultData() {
		return (T) new Bundle();// TODO: 2018/4/5
	}

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		Logger.i(TAG);
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_with_recyclerview);
		initView();
		unbinder = ButterKnife.bind(this);
		mHandler = new Handler(getMainLooper());
		intent = new Intent(genericAppCompatActivityContext, MarkdownViewActivity.class);
		prepareData();
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
//		Logger.i(TAG);
		super.onSaveInstanceState(outState);
	}

	@Override
	protected void onPostCreate(@Nullable Bundle savedInstanceState) {
//		Logger.i(TAG);
		super.onPostCreate(savedInstanceState);
	}

	@Override
	protected void onStart() {
//		Logger.i(TAG);
		super.onStart();
	}

	@Override
	protected void onResume() {
//		Logger.i(TAG);
		isMdPathAdded.set(false);
		super.onResume();
	}

	@Override
	protected void onStop() {
//		Logger.i(TAG);
		super.onStop();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
//		Logger.i(TAG);
		super.onConfigurationChanged(newConfig);
	}

	@Override
	protected void onDestroy() {
//		Logger.i(TAG);
		super.onDestroy();
		unbinder.unbind();
	}

	protected void initView() {
		getWindow().setBackgroundDrawable(null);//UI优化
	}

	protected void prepareData() {
//		Log.i("mdTest", "mdPathFromIntent:" + mdPathFromIntent);
		mdPathFromIntent = getIntent().getStringExtra("mdName");
		toolbar_title.setText(mdPathFromIntent);
		initAdapter();
	}

	private void appendPathIntoIntent(Intent intent, int position) {
		if (!isMdPathAdded.get()) {
			intent.putExtra("mdName", (mdPathFromIntent == null ? "" : (mdPathFromIntent + "/")) +
					genericItemHolders.get(position).getTitle());
			isMdPathAdded.set(true);
		}
	}

	// TODO: 2018/4/3 to re
	private void initAdapter() {
		genericRecyclerView.setHasFixedSize(true);// TODO: 2018/4/1
		genericRecyclerView.setLayoutManager(new LinearLayoutManager(this));
		genericAdapter = new GenericAdapter(this, genericItemHolders);
		genericAdapter.openLoadAnimation();
		genericAdapter.setNotDoAnimationCount(0);
		genericAdapter.setOnItemChildClickListener((adapter, view, position) -> {
			intent.putExtra("mdName", (mdPathFromIntent == null ? "" : (mdPathFromIntent + "/")) +
					genericItemHolders.get
							(position).getTitle());
			ActivityHelper.startActivity(genericAppCompatActivityContext, intent);
		});

		genericAdapter.setOnItemClickListener((adapter, view, position) -> {
			GenericItemHolder.ITEM_CLASS_TYPE itemClassType = genericItemHolders.get(position)
					.getItemClassType();
			if (itemClassType == null && getGenericItemHolders().get(position).getmRunnable() != null)
				mHandler.post(genericItemHolders.get(position).getmRunnable());
			else
				switch (genericItemHolders.get(position).getItemClassType()) {
					case ACTIVITY:
						try {
							// TODO: 2018/6/9 用resolveActivity方法
							Intent intent = new Intent(GenericActivityWithRecyclerView.this, Class.forName
									("yincheng.tinytank.ui.activity." + genericItemHolders.get
											(position).getTitle() + "Activity"));
							appendPathIntoIntent(intent, position);
							startActivity(intent);
						} catch (ClassNotFoundException e) {
							// TODO: 2018/4/1 日志收集，打印到文件里面
							e.printStackTrace();
						}
						break;
					case FRAGMENT:
						break;
					case DIALOG:
						if (baseDialog == null)
							baseDialog = new BaseDialog
									.DialogBuilder(this)
									.withAspectRatio(0.5f)
									.Build();
						baseDialog.show();
						break;
					case DIALOG_FRAGMENT:
						showResultDialogFragment(genericItemHolders.get(position).getmClazz());
						break;
					case POPUP_WINDOW:
						break;
				}
		});
		genericRecyclerView.setAdapter(genericAdapter);
	}

	@OnClick(R.id.backHome)
	public void onBackClick() {
		startActivity(new Intent(this, MainActivity.class));
	}

	protected void showResultDialogFragment(Class clazz) {
		if (showResultDialogFragment == null) {
			showResultDialogFragment = new ShowResultDialogFragment();
			Toast.makeText(genericAppCompatActivityContext, "11111", Toast.LENGTH_SHORT).show();
//       showStringResultDialogFragment.setOnDialogListener(this);//应该在dialogfragment中的onCreate()
// 方法中创建
		}
		if (showResultDialogFragment.getDialog() == null) {
			Toast.makeText(genericAppCompatActivityContext, "22222", Toast.LENGTH_SHORT).show();
//         new ShowResultDialogFragment().show(getSupportFragmentManager(), "resultfragment");
			ShowResultDialogFragment showResultDialogFragment = new ShowResultDialogFragment();
			Bundle bundle = new Bundle();
			bundle.putSerializable("ExecClass", clazz);
			showResultDialogFragment.setArguments(bundle);
			showResultDialogFragment.show(getSupportFragmentManager(), TAG);
		} else {
			Toast.makeText(genericAppCompatActivityContext, "33333", Toast.LENGTH_SHORT).show();
			showResultDialogFragment.getDialog().show();
		}
	}

	@Override
	public void onDialogCancel() {
		Toast.makeText(genericAppCompatActivityContext, "onDialogCancel()", Toast.LENGTH_SHORT)
				.show();
	}

	@Override
	public void onDialogDismiss() {
		Toast.makeText(genericAppCompatActivityContext, "onDialogDismiss()", Toast.LENGTH_SHORT)
				.show();
	}

}