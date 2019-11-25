package yincheng.tinytank.android_Q_A.frameworks.rxjava.principle;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RXActivity extends AppCompatActivity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Observable originObservable = Observable.create(new Observable.onSubscribe<Integer>() {
			@Override
			public void startWork(Subscriber<? super Integer> subscriber) {
				Log.i("-----originObservable", "startWork()  -  " + "currentThread:" + Thread.currentThread().getName());
				for (int i = 0; i < 10; i++) {
					Log.i("-----originObservable", subscriber + ".onNext()");
					subscriber.onNext(i);
				}
			}
		});

		Observable.Transformer<Integer, String> firstTransformer = new Observable.Transformer<Integer, String>() {
			@Override
			public String transform(Integer from) {
				return Integer.toBinaryString(from);
			}
		};

		Subscriber<String> lastSubscriber = new Subscriber<String>() {
			@Override
			public void onComplete() {

			}

			@Override
			public void onError() {

			}

			@Override
			public void onNext(String s) {
				Log.i("-----lastSubscriber", Thread.currentThread().getName() + " -result- " + s);
			}
		};

		Observable transformedObservable = originObservable.map(firstTransformer);
		Observable subscribedOnObservable = transformedObservable.subscribeOn(Schedulers.IO());
		subscribedOnObservable.subscribe(lastSubscriber);

		Log.i("-----", "\n"
				+ "[originObservable:" + originObservable + "]\n"
				+ "[firstTransformer:" + firstTransformer + "]\n"
				+ "[lastSubscriber:" + lastSubscriber + "]\n"
				+ "[transformedObservable:" + transformedObservable + "]\n"
				+ "[subscribedOnObservable:" + subscribedOnObservable + "]\n"
		);
	}
}
