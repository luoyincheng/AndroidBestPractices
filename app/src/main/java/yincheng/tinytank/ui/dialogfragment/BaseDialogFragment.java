package yincheng.tinytank.ui.dialogfragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import yincheng.tinytank.R;
import yincheng.tinytank.view.FontTextView;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:04:01 21:47
 * Github : yincheng.luo
 */
public abstract class BaseDialogFragment extends DialogFragment {
	/**
	 * onAttach() -> onCreate() -> onCreateDialog() -> onCreateView() -> onStart() ->
	 * onDestroyView() -> onDestroy() -> onDetach()
	 */
	public View rootView;
	@BindView(R.id.result_text)
	public FontTextView result_text;
	protected volatile List<Integer> layoutIds = new ArrayList<>();
	Unbinder unbinder;
	private LinearLayout baseDialogFragmentContainer;
	private LayoutInflater layoutInflater;
	private FrameLayout.LayoutParams layoutParams;
	private int times = 0;

	public void setTextviewText(@IdRes int tv_resId, String s) {
		((TextView) getView().findViewById(tv_resId)).setText(s);
	}

//   public void addChildViewWithLayout(Context context, @LayoutRes int layoutRes) {
////      TODO:2018 / 4 / 2 只有fragmleyout.layoutparams 才能添加到以linearlayout为父viewgroup的布局中去
//      layoutInflater = (LayoutInflater) context.getSystemService(Context
//            .LAYOUT_INFLATER_SERVICE);
//      layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams
//            .MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
////      childView.setLayoutParams(layoutParams);
////      当第三个参数为true时，会自动将第一个参数所指定的View添加到第二个参数所指定的View中, 而不用调用addView方法
//      View childView = layoutInflater.inflate(layoutRes, baseDialogFragmentContainer, false);
//      childView.setLayoutParams(layoutParams);
//      baseDialogFragmentContainer = getView().findViewById(R.id.container);
//      baseDialogFragmentContainer.addView(childView);
////      Toast.makeText(context, layoutInflater == null ? "null" : "not null", Toast.LENGTH_SHORT)
////            .show();
//   }

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
			Bundle savedInstanceState) {
		Logger.e("DialogFragmentLifeCycle", "onCreateView()");
		rootView = inflater.inflate(R.layout.dialogfragment_base, container, false);
		unbinder = ButterKnife.bind(this, rootView);
//      只有父container使用FindViewById来查找，因为父布局在bind之前使用
//      LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context
// .LAYOUT_INFLATER_SERVICE);
//      layoutInflater = LayoutInflater.from(getActivity());
//      layoutInflater = getLayoutInflater();
//        View childView = layoutInflater.inflate(getChildLayoutIds(),
// baseDialogFragmentContainer, true);// TODO: 2018/4/2 第二个参数的意义
		return rootView;
	}

	public int getTimes() {
		return times;
	}

	public int getChildCount() {
		return layoutIds.size();
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Logger.e("DialogFragmentLifeCycle", "onCreate()");
	}

	@NonNull
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		Logger.e("DialogFragmentLifeCycle", "onCreateDialog()");
		return super.onCreateDialog(savedInstanceState);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		Logger.e("DialogFragmentLifeCycle", "onViewCreated()");
		super.onViewCreated(view, savedInstanceState);
		setData();
	}

	protected abstract void setData();

	@Override
	public void onStart() {
		Logger.e("DialogFragmentLifeCycle", "onStart()");
		Window window = getDialog().getWindow();
		WindowManager.LayoutParams layoutParams = window.getAttributes();
		layoutParams.width = (int) (getContext().getResources().getDisplayMetrics().widthPixels *
				0.925);
		layoutParams.height = (int) (layoutParams.width * 1.78);
		layoutParams.gravity = Gravity.CENTER;
		window.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00ffffff")));
		window.setAttributes(layoutParams);
		super.onStart();
	}

	@Override
	public void onDestroyView() {
		Logger.e("DialogFragmentLifeCycle", "onDestroyView()");
		super.onDestroyView();
	}

	@Override
	public void onDestroy() {
		Logger.e("DialogFragmentLifeCycle", "onDestroy()");
		super.onDestroy();
		if (unbinder != null)
			unbinder.unbind();
	}

	@Override
	public void onCancel(DialogInterface dialog) {
		Logger.e("DialogFragmentLifeCycle", "onCancel()");
		super.onCancel(dialog);
	}

	@Override
	public void onDismiss(DialogInterface dialog) {
		Logger.e("DialogFragmentLifeCycle", "onDismiss()");
		super.onDismiss(dialog);
	}

	@Override
	public void onAttach(Context context) {
		Logger.e("DialogFragmentLifeCycle", "onAttach()");
		super.onAttach(context);
	}

	@Override
	public void onDetach() {
		Logger.e("DialogFragmentLifeCycle", "onDetach()");
		super.onDetach();
	}
}
