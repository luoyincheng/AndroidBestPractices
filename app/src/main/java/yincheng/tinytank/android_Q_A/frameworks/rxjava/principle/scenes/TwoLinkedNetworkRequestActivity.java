package yincheng.tinytank.android_Q_A.frameworks.rxjava.principle.scenes;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * 嵌套的两次网络请求
 */
public class TwoLinkedNetworkRequestActivity extends AppCompatActivity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Disposable disposable = Observable
				.create(new ObservableOnSubscribe<String>() {
					@Override
					public void subscribe(ObservableEmitter<String> emitter) throws Exception {

					}
				})
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.doOnNext(new Consumer<String>() {
					@Override
					public void accept(String s) throws Exception {

					}
				})
				.flatMap(new Function<String, ObservableSource<?>>() {
					@Override
					public ObservableSource<?> apply(String s) throws Exception {
						return null;
					}
				})
				.subscribe(new Consumer<Object>() {
					@Override
					public void accept(Object o) throws Exception {

					}
				}, new Consumer<Throwable>() {
					@Override
					public void accept(Throwable throwable) throws Exception {

					}
				});
	}
}
