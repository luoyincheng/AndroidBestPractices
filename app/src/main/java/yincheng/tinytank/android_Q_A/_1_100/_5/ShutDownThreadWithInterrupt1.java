package yincheng.tinytank.android_Q_A._1_100._5;

import java.util.Random;
import java.util.Vector;

public final class ShutDownThreadWithInterrupt1 implements Runnable {
	private final Vector<Integer> vector = new Vector<Integer>(1000);

	public Vector<Integer> getVector() {
		return vector;
	}

	@Override
	public synchronized void run() {
		Random number = new Random(123L);
		int i = vector.capacity();
		try {
			while (!Thread.currentThread().isInterrupted() && i > 0) {
				Thread.sleep(300);
				vector.add(number.nextInt(100));
				System.out.println(i);
				i--;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println(e.toString() + ":" + Thread.currentThread().isInterrupted());
		}
	}

	public static void main(String[] args) {
		ShutDownThreadWithInterrupt1 c = new ShutDownThreadWithInterrupt1();
		Thread thread = new Thread(c);
		thread.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread.interrupt();
	}
}