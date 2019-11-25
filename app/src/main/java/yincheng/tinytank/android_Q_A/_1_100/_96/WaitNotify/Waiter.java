package yincheng.tinytank.android_Q_A._1_100._96.WaitNotify;

public class Waiter implements Runnable {
	private Restaurant restaurant;

	Waiter(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				synchronized (Waiter.this) {
					while (restaurant.meal == null)
						Waiter.this.wait();
				}
				System.out.println("Waiter got " + restaurant.meal);
				synchronized (restaurant.chef) {
					restaurant.meal = null;
					restaurant.chef.notifyAll();
				}
			}
		} catch (InterruptedException e) {
			System.out.println("Waiter Interrupted");
		}
	}
}
