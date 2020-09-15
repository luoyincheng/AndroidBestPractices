package yincheng.tinytank.android_Q_A.frameworks.rxjava.principle;

public interface Observer<T> {
	void onComplete();

	void onError();

	void onNext(T t);
}
