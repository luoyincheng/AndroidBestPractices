package yincheng.tinytank.java.concurrent.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AtomicTest {
	Integer lockInt = 0;
	Lock lock = new ReentrantLock();
	private AtomicInteger atomicInt = new AtomicInteger();
	private int synchronizedInt = 0;

	public static void main(String[] args) {
		AtomicTest atomicTest = new AtomicTest();
		ExecutorService executor = Executors.newFixedThreadPool(2);
		for (int i = 0; i < 1000; i++) {
			executor.submit(new Runnable() {
				@Override
				public void run() {
					for (int i = 0; i < 10; i++) {
						atomicTest.increase();
						if (atomicTest.synchronizedInt == 10000)
							System.out.println("synchronized : 10000");
					}
				}
			});
		}

		for (int i = 0; i < 1000; i++) {
			executor.submit(new Runnable() {
				@Override
				public void run() {
					for (int i1 = 0; i1 < 10; i1++) {
						atomicTest.atomicInt.incrementAndGet();
						if (atomicTest.atomicInt.get() == 10000)
							System.out.println("atomic : 10000");
					}

				}
			});
		}

		for (int i = 0; i < 1000; i++) {
			executor.submit(new Runnable() {
				@Override
				public void run() {
					for (int i1 = 0; i1 < 10; i1++) {
						atomicTest.lockIncrease();
						if (atomicTest.lockInt == 10000)
							System.out.println("lock : 10000");
					}

				}
			});
		}

		executor.shutdown();
	}

	private void lockIncrease() {
		lock.lock();
		try {
			lockInt++;
		} finally {
			lock.unlock();
		}
	}

	private synchronized void increase() {
		synchronizedInt++;
	}
}