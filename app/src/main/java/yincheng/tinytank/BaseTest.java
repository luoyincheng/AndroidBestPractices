package yincheng.tinytank;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by yincheng on 2018/6/20/14:22.
 * github:luoyincheng
 */
public class BaseTest {
	static List<Integer> testList = new ArrayList<>();
	static int[] testArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

	public static void main(String[] args) {
		testList.add(1);
		testList.add(2);
		testList.add(3);
		testList.add(4);
		testList.add(5);
		testList.add(6);
		testList.add(7);
		testList.add(8);
		testList.add(9);
		System.out.println(testList.size() + "");
		testList.remove(5);
		System.out.println(testList.size() + "");

		String a = "abc";
		String b = "abc";
		System.out.println(a == b);
		Iterator<Integer> integerIterator = testList.iterator();
		while (integerIterator.hasNext()) {
			System.out.println("-> " + integerIterator.next());
		}
	}
}