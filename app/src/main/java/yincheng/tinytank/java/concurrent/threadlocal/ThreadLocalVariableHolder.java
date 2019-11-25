package yincheng.tinytank.java.concurrent.threadlocal;

import androidx.annotation.Nullable;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadLocalVariableHolder {
	private static ThreadLocal<Integer> value = new ThreadLocal<Integer>() {
		private Random random = new Random();

		@Nullable
		@Override
		protected Integer initialValue() {
			return random.nextInt(10000);
		}
	};

	public static void increment() {
		value.set(value.get() + 1);
	}

	public static int get() {
		return value.get();
	}

	public static void main(String[] args) throws Exception {
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			executorService.execute(new Accessor(i));
		}
		TimeUnit.SECONDS.sleep(3);
		executorService.shutdown();
	}
}
