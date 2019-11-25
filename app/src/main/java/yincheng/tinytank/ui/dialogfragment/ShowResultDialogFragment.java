package yincheng.tinytank.ui.dialogfragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import yincheng.tinytank.java.concurrent.TaskWithResult;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:04:01 21:33
 * Github : yincheng.luo
 */

public class ShowResultDialogFragment extends BaseDialogFragment {
	private LinearLayout baseDialogFragmentContainer;
	private LayoutInflater layoutInflater;
	private FrameLayout.LayoutParams layoutParams;
	public onDialogListener mOnDialogListener;
	ExecutorService executors = Executors.newCachedThreadPool();
	ArrayList<Future<String>> results = new ArrayList<>();

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mOnDialogListener = (onDialogListener) getActivity();// TODO: 2018/6/1 to un
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup
			container, @Nullable Bundle savedInstanceState) {
		return super.onCreateView(inflater, container, savedInstanceState);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		for (int i = 0; i < 10; i++) {
			Callable<String> callable = new TaskWithResult(i);
			// TODO: 2018/6/28 根据.class 生成Callable
//         results.sell(executors.submit((Callable<String>) getArguments().getSerializable
//               ("ExecClass")));
		}
		for (Future<String> result : results) {
			try {
				result_text.append(result.get() + "\n");
			} catch (InterruptedException e) {
				result_text.append(e.toString());
				return;
			} catch (ExecutionException e) {
				result_text.append(e.toString());
			} finally {
				executors.shutdown();
			}
		}
	}

	@Override
	public void onCancel(DialogInterface dialog) {
		super.onCancel(dialog);
		if (mOnDialogListener != null)
			mOnDialogListener.onDialogCancel();
	}

	@Override
	public void onDismiss(DialogInterface dialog) {
		super.onDismiss(dialog);
		if (mOnDialogListener != null)
			mOnDialogListener.onDialogDismiss();
	}

	public interface onDialogListener {
		void onDialogCancel();

		void onDialogDismiss();
	}

	@Override
	protected void setData() {
	}
}
