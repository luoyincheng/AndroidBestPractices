package yincheng.tinytank.android_Q_A.frameworks.rxjava.principle;

import java.util.concurrent.Executors;

public class Schedulers {

	private static final Scheduler IO_SCHEDULER = new Scheduler(Executors.newSingleThreadExecutor());

	public static Scheduler IO() {
		return IO_SCHEDULER;
	}
}
