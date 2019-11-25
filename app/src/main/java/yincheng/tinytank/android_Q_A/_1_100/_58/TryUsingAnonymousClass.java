package yincheng.tinytank.android_Q_A._1_100._58;

public class TryUsingAnonymousClass {
	public void useMyInterface() {
		final Integer number = 123;
		System.out.println(number);

		MyInterface myInterface = new MyInterface() {
			@Override
			public void doSomething() {
				System.out.println(number);
			}
		};
		myInterface.doSomething();

		System.out.println(number);
	}

	public interface MyInterface {
		void doSomething();
	}
}


