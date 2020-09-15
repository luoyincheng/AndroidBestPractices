package yincheng.tinytank.ui.activity;

import java.util.List;

import yincheng.tinytank.common.GenericItemHolder;
import yincheng.tinytank.ui.activity.base.AlgorithmRunnableRecyclerViewActivity;


/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:06:29 8:20
 * Github : yincheng.luo
 */
public class LeetCodeActivity extends AlgorithmRunnableRecyclerViewActivity {
	@Override
	protected List<GenericItemHolder> getGenericItemHolders() {
		return null;
	}

//	@Override
//	protected List<GenericItemHolder> getGenericItemHolders() {
//		Runnable ReverseIntegerRunnable = () -> computationConsumer(.class
//				.getDeclaredMethods()[0], -123456789, null);
//
//		return Arrays.asList(
//				new GenericItemHolder("ReverseInteger", true, ReverseIntegerRunnable)
//		);
//	}
//
//	private Disposable sortComputationConsumer(String method) {
//		StringBuilder sourceDataBuilder = new StringBuilder();
//		StringBuilder usedTimeBuilder = new StringBuilder();
//		StringBuilder resultBuilder = new StringBuilder();
//		return ObservableCreate
//				.create((ObservableOnSubscribe<String>) emitter -> {
//					switch (method) {
//						case "reverseInteger":
//							long data = new Random().nextLong();
//							sourceDataBuilder.append(String.valueOf(data));
//							resultBuilder.append(String.valueOf(reverseInteger(data)));
//							emitter.onNext(resultBuilder.toString());
//							break;
//					}
//				})
//				.subscribeOn(Schedulers.computation())
//				.observeOn(AndroidSchedulers.mainThread())
//				.subscribe(s -> MessageDialogView
//						.newInstance(method + ":",
//								sourceDataBuilder.toString(),//直接使用变量来传递
//								usedTimeBuilder.toString(),//直接使用变量来传递
//								s,//emitter发送而来
//								false,
//								Bundler.create()
//										.put(BundleConstant.YES_EXTRA, false)
//										.end(), true)
//						.show(getSupportFragmentManager(), MessageDialogView.TAG));
//	}
}
