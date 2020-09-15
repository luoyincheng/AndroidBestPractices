package yincheng.tinytank.java.concurrent.concurrent3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yincheng on 2018/5/30/17:34.
 * github:luoyincheng
 */
public class EventChecker implements Runnable {
	private final int id;
	private IntGenerator intGenerator;

	public EventChecker(IntGenerator intGenerator, int id) {
		this.intGenerator = intGenerator;
		this.id = id;
	}

	public static void test(IntGenerator intGenerator, int count) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < count; i++) executorService.execute(new EventChecker(intGenerator, i));
		executorService.shutdown();
	}

	/**
	 * 开启多个线程同时对
	 *
	 * @param intGenerator
	 */
	public static void test(IntGenerator intGenerator) {
		test(intGenerator, 10);
	}

	@Override
	public void run() {
		while (!intGenerator.isCanceled()) {
			int val = intGenerator.next();
			if (val % 2 != 0) {
				System.out.println(val + "奇数!");
				intGenerator.cancel();
			}
		}
	}
}
