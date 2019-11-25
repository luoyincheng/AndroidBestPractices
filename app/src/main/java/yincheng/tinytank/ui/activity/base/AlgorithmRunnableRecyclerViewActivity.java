package yincheng.tinytank.ui.activity.base;


import java.lang.reflect.Method;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.operators.observable.ObservableCreate;
import io.reactivex.schedulers.Schedulers;
import yincheng.tinytank.provider.BundleConstant;
import yincheng.tinytank.provider.helper.Bundler;
import yincheng.tinytank.ui.dialog.MessageDialogView;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:06:29 8:29
 * Github : yincheng.luo
 */
public abstract class AlgorithmRunnableRecyclerViewActivity extends
		GenericActivityWithRecyclerView {

	public <T> Disposable computationConsumer(Method method, Object sourceData, T target) {
		String stringParam = parseToString(sourceData);
		StringBuilder usedTimeBuilder = new StringBuilder();
		StringBuilder resultBuilder = new StringBuilder();
		return ObservableCreate
				.create(new ObservableOnSubscribe<String>() {
					@Override
					public void subscribe(ObservableEmitter<String> emitter) throws Exception {
						Long beginTime = System.currentTimeMillis();
						// TODO: 2018/6/29  invoke方法,第一个参数的意义
						Object result;
						if (target == null)
							result = method.invoke(null, sourceData);
						else
							result = method.invoke(null, sourceData, target);
						usedTimeBuilder.append(System.currentTimeMillis() - beginTime);
						emitter.onNext(parseToString(result));
					}
				})
				.subscribeOn(Schedulers.computation())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Consumer<String>() {
					@Override
					public void accept(String s) throws Exception {
						MessageDialogView.newInstance(
								method.getName(),
								stringParam,
								usedTimeBuilder.toString(),
								s,
								false,
								Bundler.create()
										.put(BundleConstant.YES_EXTRA, true)
										.end(),
								true)
								.show(getSupportFragmentManager(), MessageDialogView.TAG);
					}
				});
	}

	private String parseToString(Object param) {
		StringBuilder builder = new StringBuilder();
		if (param instanceof int[]) {
			for (int i : ((int[]) param)) {
				builder.append(i).append(i == ((int[]) param).length - 1 ? "" : ",");
			}
		} else if (param instanceof Integer[]) {
			for (int i : ((Integer[]) param)) {
				builder.append(i).append(i == ((Integer[]) param).length - 1 ? "" : ",");
			}
		}
		return builder.toString();
	}

	public Method genMethod(Class clazz, String methodName, Class... paramClass) {
		try {
			return clazz.getDeclaredMethod(methodName, paramClass);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return null;
	}
}
