package yincheng.tinytank.provider.helper;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import yincheng.tinytank.ui.dialogfragment.ShowResultDialogFragment;

/**
 * Created by yincheng on 2018/5/31/10:10.
 * github:luoyincheng
 */
public class RxHelper {
	private static int onNextTimes = 0;
	private static ShowResultDialogFragment showResultDialogFragment;

	public static <T> Disposable computationConsumer(Observable<T> observable, Consumer<T>
			consumer) {
		return observable.subscribeOn(Schedulers.computation())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(consumer);
	}
}
