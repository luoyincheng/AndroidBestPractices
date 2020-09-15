package yincheng.tinytank.android_Q_A._1_100._58;

public class App {
	public static void main(String[] args) {
		final String rawString = "hello world";
		Callback callback = new Callback() {
			@Override
			public void call() {
				System.out.println(rawString);
			}
		};
		callback.call();
	}

	private void testParam(final String rawString) {
		Callback callback = new Callback() {
			@Override
			public void call() {
				System.out.println(rawString);
			}
		};
		callback.call();
	}

	public interface Callback {
		void call();
	}
}