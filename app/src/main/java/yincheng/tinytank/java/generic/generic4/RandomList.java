package yincheng.tinytank.java.generic.generic4;

import java.util.ArrayList;
import java.util.Random;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:05:01 20:34
 * Github : yincheng.luo
 */
public class RandomList<T> {
	private ArrayList<T> storage = new ArrayList<>();
	private Random random = new Random(47);

	public static void main(String[] args) {
		RandomList<String> randomList = new RandomList<>();
		for (String s : "Trust nothing but your strength!".split(" ")) {
			randomList.add(s);
		}

		for (int i = 0; i < 11; i++) {
			System.out.print(randomList.randomSelect() + " ");
		}
	}

	public void add(T item) {
		storage.add(item);
	}

	public T randomSelect() {
		return storage.get(random.nextInt(storage.size()));
	}
}
