package yincheng.tinytank.java.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yincheng on 2018/5/30/16:17.
 * github:luoyincheng
 */
public class ConCurrent1 implements Runnable {
	protected int countDown = 10;
	private static int taskCount = 0;
	private final int id = taskCount++;

	public ConCurrent1() {
	}

	public ConCurrent1(int countDown) {
		this.countDown = countDown;
	}

	public String status() {
		return "#" + id + "(" + (countDown > 0 ? countDown : "发射！！") +
				")," + "时间:" + System.currentTimeMillis();
	}

	@Override
	public void run() {
		while (countDown-- > 0) {
			System.out.println(status());
			Thread.yield();
		}
	}

	public static void main(String[] args) {
//      ConCurrent1 concurrent1 = new ConCurrent1();
		ConCurrent1 concurrent1 = new ConCurrent1(20);
		concurrent1.run();//方式一

		Thread thread = new Thread(new ConCurrent1());
		thread.start();//方式二
		System.out.println("开启任务");

		for (int i = 0; i < 5; i++) new Thread(new ConCurrent1()).start();//方式三
		System.out.println("开始倒计时");

		/**
		 * Creates a thread pool that creates new threads as needed, but
		 * will reuse previously constructed threads when they are
		 * available.  These pools will typically improve the performance
		 * of programs that execute many short-lived asynchronous tasks.
		 * Calls to {@code execute} will reuse previously constructed
		 * threads if available. If no existing thread is available, a new
		 * thread will be created and added to the pool. Threads that have
		 * not been used for sixty seconds are terminated and removed from
		 * the cache. Thus, a pool that remains idle(闲置的) for long enough will
		 * not consume any resources. Note that pools with similar
		 * properties but different details (for example, timeout parameters)
		 * may be created using {@link ThreadPoolExecutor} constructors.
		 *
		 * @return the newly created thread pool
		 *
		 * 对shutDown方法的调用可以防止新任务被提交给这个Executor，当前线程(在本例中就是驱动main()的线程)
		 * 将继续运行在shutDown()被调用之前提交的所有任务，这个程序将在Executor中的所有任务执行完成之后尽快退出
		 */
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) executorService.execute(new ConCurrent1());//方式四
		executorService.shutdown();

		/**
		 * Creates a thread pool that reuses a fixed number of threads
		 * operating off a shared unbounded queue.  At any point, at most
		 * {@code nThreads} threads will be active processing tasks.
		 * If additional tasks are submitted when all threads are active,
		 * they will wait in the queue until a thread is available.
		 * If any thread terminates due to a failure during execution
		 * prior to shutdown, a new one will take its place if needed to
		 * execute subsequent tasks.  The threads in the pool will exist
		 * until it is explicitly {@link ExecutorService#shutdown shutdown}.
		 *
		 * FixedThreadPool一次性预先执行代价高昂的线程分配
		 * 在任何线程池中，现有现成在可能的情况下，都会被自动复用
		 */
		ExecutorService fixedExecutor = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 5; i++) fixedExecutor.execute(new ConCurrent1());
		executorService.shutdown();

		/**
		 * Creates an Executor that uses a single worker thread operating
		 * off an unbounded queue. (Note however that if this single
		 * thread terminates due to a failure during execution prior to
		 * shutdown, a new one will take its place if needed to execute
		 * subsequent tasks.)  Tasks are guaranteed to execute
		 * sequentially, and no more than one task will be active at any
		 * given time. Unlike the otherwise equivalent
		 * {@code newFixedThreadPool(1)} the returned executor is
		 * guaranteed not to be reconfigurable to use additional threads.
		 *
		 * @return the newly created single-threaded Executor
		 *
		 * 所有任务都会放到该Thread中去，排队执行，保证了执行的顺序，保证了共享资源同步
		 */
		ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 5; i++) singleThreadExecutor.execute(new ConCurrent1());
		singleThreadExecutor.shutdown();

	}
}
