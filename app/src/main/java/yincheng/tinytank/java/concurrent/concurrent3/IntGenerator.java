package yincheng.tinytank.java.concurrent.concurrent3;

/**
 * Created by yincheng on 2018/5/30/17:26.
 * github:luoyincheng
 */
public abstract class IntGenerator {
	/**
	 * 因为canceled标志是boolean类型的，所以它是原子性的，即诸如赋值和返回值这样的简单操作
	 * 在发生时没有中断的可能，因此你不会看到这个域处于在执行这些简单操作的过程中的中间状态。
	 * 为了保证可视性，canceled标志还被设置为volatile的
	 */
	private volatile boolean canceled = false;

	public abstract int next();

	public boolean isCanceled() {
		return canceled;
	}

	public void cancel() {
		canceled = true;
	}
}
