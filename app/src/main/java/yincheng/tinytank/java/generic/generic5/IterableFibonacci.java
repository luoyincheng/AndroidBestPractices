package yincheng.tinytank.java.generic.generic5;

import androidx.annotation.NonNull;

import java.util.Iterator;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:05:01 21:36
 * Github : yincheng.luo
 */
public class IterableFibonacci extends Fibonacci implements Iterable<Integer> {
	private int n;

	public IterableFibonacci(int count) {
		n = count;
	}

	public static void main(String[] args) {
		for (int i : new IterableFibonacci(180))//这将非常耗时，还会造成溢出
			System.out.print(i + " ");
	}

	@NonNull
	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			@Override
			public boolean hasNext() {
				return n > 0;
			}

			@Override
			public Integer next() {
				n--;
				return IterableFibonacci.this.next();
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}
}
