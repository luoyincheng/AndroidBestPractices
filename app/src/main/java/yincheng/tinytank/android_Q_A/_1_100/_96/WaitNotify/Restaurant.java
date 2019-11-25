package yincheng.tinytank.android_Q_A._1_100._96.WaitNotify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Restaurant {
	Meal meal;
	ExecutorService executorService = Executors.newCachedThreadPool();
	final Chef chef = new Chef(this);
	final Waiter waiter = new Waiter(this);

	private Restaurant() {
		executorService.execute(chef);
		executorService.execute(waiter);
	}

	public static void main(String[] args) {
		new Restaurant();
	}
}
