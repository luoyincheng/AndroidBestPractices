package yincheng.tinytank.android_Q_A._1_100._96.BlockingQueue;

import java.util.concurrent.BlockingQueue;

public class LiftOffRunner implements Runnable {
	public BlockingQueue<LiftOff> rockets;

	public LiftOffRunner(BlockingQueue<LiftOff> rockets) {
		this.rockets = rockets;
	}

	public void add(LiftOff liftOff) {
		try {
			rockets.put(liftOff);
		} catch (InterruptedException e) {
			System.out.println("Interrupted during put()");
		}
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				Thread.sleep(1500);
				System.out.println("take === " + rockets.size());
				LiftOff rocket = rockets.take();
				rocket.run();
			}
		} catch (InterruptedException e) {
			System.out.println("Waking from take()");
		}
		System.out.println("Exiting LiftOffRunner");
	}
}
