package yincheng.tinytank.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;

import yincheng.tinytank.App;
import yincheng.tinytank.R;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:06:08 8:04
 * Github : yincheng.luo
 */
public class ResultDialog extends Dialog {
	private static final String TAG = ResultDialog.class.getSimpleName();
	private View dialogView;
	private View customizedView;
	private AnimationSet dialogInAnimSet;
	private int clickPosition;
	private LayoutInflater layoutInflater;

	private FrameLayout dialog_root;

	public ResultDialog(@NonNull Context context) {
		super(context, R.style.result_dialog);
	}

	public ResultDialog setClickPosition(int position) {
		this.clickPosition = position;
		return this;
	}

	protected void init() {
		setCancelable(true);
		setCanceledOnTouchOutside(false);
		dialogInAnimSet = (AnimationSet) AnimationUtils.loadAnimation(this.getContext(), R.anim.anim_dialog_in);
		layoutInflater = (LayoutInflater) App.getInstance().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_result);
		dialogView = getWindow().getDecorView().findViewById(android.R.id.content);
//      dialogView = findViewById(android.R.id.content);// TODO: 2018/6/9 android.R.id.content ??????
		dialog_root = findViewById(R.id.dialog_root);
		setViewVisible(clickPosition);
		dialog_root.addView(customizedView);
	}

	@Override
	protected void onStart() {
		super.onStart();
		dialogView.startAnimation(dialogInAnimSet);
	}

	private void setViewVisible(int position) {
		customizedView = layoutInflater.inflate(R.layout.generateviewlayout, dialog_root, false);
		switch (position) {
			case 0:
				break;
			case 1:
				break;
			case 2:
				break;
			case 3:
				customizedView.findViewById(R.id.SuccessTickView).setVisibility(View.VISIBLE);
				break;
			case 4:
				break;
		}
	}
}
