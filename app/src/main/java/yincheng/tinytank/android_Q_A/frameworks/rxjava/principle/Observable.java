package yincheng.tinytank.android_Q_A.frameworks.rxjava.principle;

import android.util.Log;

public class Observable<T> {
	private final onSubscribe<T> mOnSubscribe;

	public Observable(onSubscribe<T> onSubscribe) {
		Log.i("-----Observable构造函数", Observable.this + "=====" + onSubscribe);
		this.mOnSubscribe = onSubscribe;
	}

	//create方法会创建一个onSubscribe回调接口
	public static <T> Observable<T> create(onSubscribe<T> onSubscribe) {
		return new Observable<>(onSubscribe);
	}

	public void subscribe(Subscriber<? super T> subscriber) {
//		subscriber.onStart();
		Log.i("-----subscribe", mOnSubscribe + ".startWork  " + subscriber);
		mOnSubscribe.startWork(subscriber);
	}

	public interface onSubscribe<T> {
		void startWork(Subscriber<? super T> subscriber);
	}

	public interface Transformer<T, R> {
		R transform(T from);
	}

	/**
	 * 将一个Observable转化成另外一种类型的Observable
	 *
	 * @param transformer 转换规则
	 * @return 一个新的Observable
	 */
	public <R> Observable<R> map(Transformer<? super T, ? extends R> transformer) {
		onSubscribe<R> mapOnSubscribe = new onSubscribe<R>() {
			@Override
			public void startWork(Subscriber<? super R> subscriber) {
				Log.i("-----map", "startWork()");
				//这个Observable.this指的就是调用map()方法的Observable
				Subscriber mapSubscriber = new Subscriber<T>() {
					@Override
					public void onComplete() {

					}

					@Override
					public void onError() {

					}

					@Override
					public void onNext(T t) {
						Log.i("-----map", subscriber + ".onNext()");
						subscriber.onNext(transformer.transform(t));
					}
				};
				Log.i("-----map", Observable.this + ".subscribe " + mapSubscriber);
				/*
				 * 将这个subscriber传给originObservable中的startWork方法
				 * 将下面(subscribeOn)传来的subscriber封装成一个mapSubscriber，然后将他交给
				 * 上一层(originObservable)去执行
				 */
				Observable.this.subscribe(mapSubscriber);
			}
		};
		return create(mapOnSubscribe);
	}

	//region [Scheduler]

	/**
	 * 将lastSubscriber放到新线程中执行
	 * subscribeOn是作用于上层OnSubscribe的，可以让OnSubscribe的call方法在新线程中执行。
	 */
	public Observable<T> subscribeOn(Scheduler scheduler) {
		onSubscribe<T> subscribeOnOnSubscribe = new onSubscribe<T>() {
			@Override
			public void startWork(Subscriber<? super T> subscriber) {
				Log.i("-----subscribeOn", "startWork()");
//				subscriber.onStart();
				scheduler.createWorker().schedule(new Runnable() {
					@Override
					public void run() {
						//subscriber是lastSubscriber
						Log.i("-----subscribeOn", "Observable.this:" + Observable.this.toString());
						Log.i("-----subscribeOn", Observable.this.mOnSubscribe + ".startWork " + subscriber);
						//这个Observable.this指的是调用subscribeOn()方法的Observable。即transformedObservable
						Observable.this.mOnSubscribe.startWork(subscriber);
					}
				});
			}
		};
		Log.i("-----subscribeOn", "createObservableWithOnSubscribe:" + subscribeOnOnSubscribe);
		return Observable.create(subscribeOnOnSubscribe);
	}

	public Observable<T> observeOn(Scheduler scheduler) {
		return Observable.create(new onSubscribe<T>() {
			@Override
			public void startWork(Subscriber<? super T> subscriber) {
				Log.i("-----", "Observable.observeOn.startWork()");
				subscriber.onStart();
				Scheduler.Worker worker = scheduler.createWorker();
				Observable.this.mOnSubscribe.startWork(new Subscriber<T>() {
					@Override
					public void onComplete() {
						worker.schedule(new Runnable() {
							@Override
							public void run() {
								subscriber.onComplete();
							}
						});
					}

					@Override
					public void onError() {
						worker.schedule(new Runnable() {
							@Override
							public void run() {
								subscriber.onError();
							}
						});
					}

					@Override
					public void onNext(T t) {
						worker.schedule(() -> {
							subscriber.onNext(t);
						});
					}
				});
			}
		});
	}
	//endregion

	//region [map]

//	public <R> Observable<R> map(Transformer<? super T, ? extends R> transformer) {
//		return create(new MapOnSubscribe<T, R>(this, transformer));
//	}

//	public class MapOnSubscribe<T, R> implements onSubscribe<R> {
//		final Observable<T> source;
//		final Transformer<? super T, ? extends R> transformer;
//
//		public MapOnSubscribe(Observable<T> source, Transformer<? super T, ? extends R> transformer) {
//			this.source = source;
//			this.transformer = transformer;
//		}
//
//		@Override
//		public void startWork(Subscriber<? super R> subscriber) {
//			Log.i("-----", "Observable.map.startWork()");
//			source.subscribe(new MapSubscriber<R, T>(subscriber, transformer));
//		}
//	}
//
//
//	public class MapSubscriber<T, R> extends Subscriber<R> {
//
//		final Subscriber<? super T> actual;
//		final Observable.Transformer<? super R, ? extends T> transformer;
//
//		public MapSubscriber(Subscriber<? super T> actual, Transformer<? super R, ? extends T> transformer) {
//			this.actual = actual;
//			this.transformer = transformer;
//		}
//
//		@Override
//		public void onComplete() {
//			actual.onComplete();
//		}
//
//		@Override
//		public void onError() {
//			actual.onError();
//		}
//
//		@Override
//		public void onNext(R r) {
//			actual.onNext(transformer.transform(r));
//		}
//	}
	//endregion
}
