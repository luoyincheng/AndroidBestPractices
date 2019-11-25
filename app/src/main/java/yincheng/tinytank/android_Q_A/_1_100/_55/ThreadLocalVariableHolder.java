package yincheng.tinytank.android_Q_A._1_100._55;

public class ThreadLocalVariableHolder {
	private static ThreadLocal<Integer> value = new ThreadLocal<Integer>() {
		protected synchronized Integer initialValue() {
			return 100;
		}
	};

	public static void increment() {
		value.set(value.get() + 1);
	}

	public static int get() {
		return value.get();
	}
}
