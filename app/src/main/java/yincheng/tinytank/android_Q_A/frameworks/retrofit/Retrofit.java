package yincheng.tinytank.android_Q_A.frameworks.retrofit;

import java.lang.reflect.Proxy;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class Retrofit {
	public static <T> T newProxy(Class<T> clazz) {
		return (T) Proxy.newProxyInstance(clazz.getClassLoader(),
				new Class[]{clazz}, new RequestHandler());
	}

	public static void main(String[] args) {
		ApiService apiService = Retrofit.newProxy(ApiService.class);
		Observable<CheckUpdate> checkUpdateObservable = apiService.checkUpdate("3.1.0");
		if (checkUpdateObservable == null) {
			System.out.println("null");
		} else {
			System.out.println("not null");
			Disposable disposable = checkUpdateObservable
					.subscribeOn(Schedulers.io())
					.subscribe(new Consumer<CheckUpdate>() {
						@Override
						public void accept(CheckUpdate checkUpdate) throws Exception {
							System.out.println("1");
						}
					}, new Consumer<Throwable>() {
						@Override
						public void accept(Throwable throwable) throws Exception {
							System.out.println("2");
						}
					});
		}
	}
}
