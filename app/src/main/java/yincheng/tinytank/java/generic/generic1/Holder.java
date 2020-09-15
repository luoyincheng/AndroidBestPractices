package yincheng.tinytank.java.generic.generic1;

import yincheng.tinytank.java.generic.Automobile;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:04:30 16:29
 * Github : yincheng.luo
 */

/**
 * 泛型的主要目的之一就是用来指定容器要持有什么类型的对象，而且由编译器来保证类型的正确性
 *
 * @param <T>
 */
public class Holder<T> {
	private T a;

	public Holder(T t) {
		this.a = t;
	}

	public static void main(String[] args) {
		Holder<Automobile> holder = new Holder<>(new Automobile());
		Automobile automobile = holder.get();
		System.out.print(automobile.getClass().getSimpleName());
	}

	public T get() {
		return a;
	}

	public void set(T a) {
		this.a = a;
	}
}
