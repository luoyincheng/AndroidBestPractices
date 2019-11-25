package yincheng.tinytank.java.concurrent;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by yincheng on 2018/6/28/15:55.
 * github:luoyincheng
 */
public class TaskWithResult implements Callable<String> {
	private int id;

	public TaskWithResult(int id) {
		this.id = id;
	}

	@Override
	public String call() throws Exception {
		return "result of TaskWithResult:" + id;
	}

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		ArrayList<Future<String>> results = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			results.add(executorService.submit(new TaskWithResult(i)));
		}
		for (Future<String> result : results) {
			try {
				System.out.println(result.get());
			} catch (InterruptedException e) {
				System.out.println(e.toString());
				return;
			} catch (ExecutionException e) {
				System.out.println(e.toString());
			} finally {
				executorService.shutdown();
			}
		}
	}
}
