package yincheng.tinytank.java.concurrent;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by yincheng on 2018/5/30/15:47.
 * github:luoyincheng
 */
public class ConCurrent2 implements Callable<String> {
	private int id;

	public ConCurrent2(int id) {
		this.id = id;
	}

	@Override
	public String call() throws Exception {
		return "任务 " + id + " 执行结束了";
	}

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		ArrayList<Future<String>> results = new ArrayList<>();// TODO: 2018/5/30
		for (int i = 0; i < 10; i++) {
			results.add(executorService.submit(new ConCurrent2(i)));
		}
		for (Future<String> result : results) {
			try {
				System.out.println(result.get());
			} catch (InterruptedException e) {
				System.out.println(e);
				return;
			} catch (ExecutionException e) {
				System.out.println(e);
			} finally {
				executorService.shutdown();
			}
		}
	}
}
