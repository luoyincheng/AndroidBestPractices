package yincheng.tinytank.android_Q_A._1_100._96.BlockingQueue;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;

public class BlockingQueueTest {
	public static void main(String[] args) {
		LiftOffRunner liftOffRunner = new LiftOffRunner(new ArrayBlockingQueue<LiftOff>(5));
		new Thread(liftOffRunner).start();
		put(liftOffRunner);
	}


	private static void put(LiftOffRunner liftOffRunner) {
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				liftOffRunner.add(new LiftOff(1));
				System.out.println("put " + liftOffRunner.rockets.size());
			}
		}, 0, 1000);
	}

}