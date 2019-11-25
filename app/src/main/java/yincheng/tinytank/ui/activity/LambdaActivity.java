package yincheng.tinytank.ui.activity;

import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

import yincheng.tinytank.common.GenericItemHolder;
import yincheng.tinytank.ui.activity.base.GenericActivityWithRecyclerView;

/**
 * Created by yincheng on 2018/5/24/15:01.
 * github:luoyincheng
 */
public class LambdaActivity extends GenericActivityWithRecyclerView {

	@Override
	protected List<GenericItemHolder> getGenericItemHolders() {
		Runnable threadRunnable = () -> Toast.makeText(genericAppCompatActivityContext, "Thread in lambda way," +
				"passing an runnable into mainMessageQueue", Toast.LENGTH_LONG).show();
		return Arrays.asList(new GenericItemHolder("ThreadLambda", true, threadRunnable));
	}
}
