package yincheng.tinytank.android_Q_A._1_100._96.WaitNotify;

import java.util.concurrent.TimeUnit;

public class Chef implements Runnable {
	private Restaurant restaurant;
	private int count = 0;

	Chef(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				synchronized (Chef.this) {                  //给this(Chef)加锁
					while (restaurant.meal != null) {
						Chef.this.wait();                    //让this(Chef)等待
					}
				}
				if (++count == 10) {
					System.out.println("out of food,closing");
					restaurant.executorService.shutdownNow();
				}
				System.out.println("Order up!");
				synchronized (restaurant.waiter) {
					restaurant.meal = new Meal(count);
					restaurant.waiter.notifyAll();
				}
				TimeUnit.MICROSECONDS.sleep(10000);
			}
		} catch (InterruptedException e) {
			System.out.println("Chef interrupted");
		}
	}
}
