package yincheng.tinytank.java.concurrent.threadlocal;

import androidx.annotation.NonNull;

public class Accessor implements Runnable {
	private final int id;

	public Accessor(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			ThreadLocalVariableHolder.increment();
			System.out.println(this);
			Thread.yield();
		}
	}

	@NonNull
	@Override
	public String toString() {
		return "id:" + id + ":" + ThreadLocalVariableHolder.get();
	}
}
