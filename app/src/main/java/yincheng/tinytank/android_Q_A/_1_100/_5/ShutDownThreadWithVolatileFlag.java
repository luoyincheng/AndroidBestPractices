package yincheng.tinytank.android_Q_A._1_100._5;

import java.util.Random;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ShutDownThreadWithVolatileFlag implements Runnable {
	private final Vector<Integer> vector = new Vector<Integer>(1000);
	private volatile boolean done = false;
	private final AtomicBoolean running = new AtomicBoolean(false);


	public Vector<Integer> getVector() {
		return vector;
	}

	public void shutdown() {
		done = true;
	}

	@Override
	public synchronized void run() {
		Random number = new Random(123L);
		int i = vector.capacity();
		while (!done && i > 0) {
			try {
				Thread.sleep(300);
				vector.add(number.nextInt(100));
				System.out.println(i);
				i--;
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println(e.toString());
			}
		}

//		try {
//			while (!done && i > 0) {
//				Thread.sleep(300);
//				vector.sell(number.nextInt(100));
//				System.out.println(i);
//				i--;
//			}
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//			System.out.println(e.toString());
//		}
	}

	public static void main(String[] args) throws InterruptedException {
		ShutDownThreadWithVolatileFlag shutDownThreadWithVolatileFlag = new ShutDownThreadWithVolatileFlag();
		Thread thread = new Thread(shutDownThreadWithVolatileFlag);
		thread.start();
		Thread.sleep(2000);
		shutDownThreadWithVolatileFlag.shutdown();
	}
}
