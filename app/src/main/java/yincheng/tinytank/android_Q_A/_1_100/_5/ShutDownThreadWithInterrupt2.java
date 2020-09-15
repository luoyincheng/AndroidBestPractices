package yincheng.tinytank.android_Q_A._1_100._5;

import java.util.Random;
import java.util.Vector;

public class ShutDownThreadWithInterrupt2 implements Runnable {
	private final Vector<Integer> vector = new Vector<Integer>(1000);

	public static void main(String[] args) {
		ShutDownThreadWithInterrupt2 c = new ShutDownThreadWithInterrupt2();
		Thread thread = new Thread(c);
		thread.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread.interrupt();
	}

	public Vector<Integer> getVector() {
		return vector;
	}

	@Override
	public synchronized void run() {
		Random number = new Random(123L);
		int i = vector.capacity();
		while (!Thread.currentThread().isInterrupted() && i > 0) {
			try {
				Thread.sleep(300);
				vector.add(number.nextInt(100));
				System.out.println(i);
				i--;
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println(e.toString() + ":" + Thread.currentThread().isInterrupted());
				/*
				 *如果没有这一行代码，该线程会收到一次中断提示，但是之后会继续执行未完成的任务，也就是说中断实际上就不会起作用，因为抛出InterruptedException
				 *异常后，中断标示位会自动清除。
				 */
				Thread.currentThread().interrupt();
			}
		}
	}
}
