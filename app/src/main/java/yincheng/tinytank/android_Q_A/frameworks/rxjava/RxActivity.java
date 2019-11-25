package yincheng.tinytank.android_Q_A.frameworks.rxjava;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import yincheng.tinytank.R;

public class RxActivity extends AppCompatActivity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_one_button);
		Disposable disposable = Observable
				.create(new ObservableOnSubscribe<Integer>() {
					@Override
					public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
						for (int i = 0; ; i++) {
							Log.i("RxActivity", "subscribe:" + i);
							emitter.onNext(i);
						}
					}
				})
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Consumer<Integer>() {
					@Override
					public void accept(Integer integer) throws Exception {
						TimeUnit.MILLISECONDS.sleep(2000);
						Log.i("RxActivity", "accept:" + integer);
					}
				});
	}
}
