package yincheng.tinytank.java.generic.generic5;

import java.util.Iterator;
import java.util.Random;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:04:19 8:23
 * Github : yincheng.luo
 */

/**
 * 参数化的Geneator接口确保next()的返回值是参数的类型，CoffeeGenerator同时还实现了Iterable接口，所以它可以在循环语句中使用，不过它还需要一个“末端哨兵”来判断何止停止，这正是第二个构造器的功能。
 */
public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {

	private Class[] coffeeTypes = new Class[]{
			Latte.class,
			Mocha.class,
			Cappuccino.class,
			Americano.class,
			Breve.class
	};

	private static Random random = new Random(47);

	public CoffeeGenerator() {
	}

	private int size = 0;

	public CoffeeGenerator(int sz) {
		size = sz;
	}

	@Override
	public Coffee next() {
		try {
			return (Coffee) coffeeTypes[random.nextInt(coffeeTypes.length)].newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	class CoffeeIterator implements Iterator<Coffee> {
		int count = size;

		@Override
		public boolean hasNext() {
			return count > 0;
		}

		@Override
		public Coffee next() {
			count--;
			return CoffeeGenerator.this.next();
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	public CoffeeIterator iterator() {
		return new CoffeeIterator();
	}

	public static void main(String[] args) {
		CoffeeGenerator coffeeGenerator = new CoffeeGenerator();
		for (int i = 0; i < 5; i++) {
			System.out.println(coffeeGenerator.next());
		}

		/**
		 * 之所以这个for语句有效是因为CoffeeGenerator实现了iterable接口
		 */
		for (Coffee coffee : new CoffeeGenerator(5))
			System.out.println(coffee);
	}
}
