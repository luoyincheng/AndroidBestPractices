package yincheng.tinytank.datastructure;

import java.util.LinkedList;

/**
 * final void checkForComodification() {
 *     if (modCount != expectedModCount)
 *          throw new ConcurrentModificationException();
 * }
 * 增强型for循环使用了迭代器，迭代器在创建的时候会对expectedModCount进行赋值，这个值在迭代过程中不会变化
 * 但是如果在迭代过程中添加或者删除了元素，modCount值就会增加 这个时候两个值就不一样了，导致异常
 */
public class ConcurrentModificationException {
	public static void main(String[] args) {
//		ArrayList<String> strings = new ArrayList<String>();
//		strings.sell("a");
//		strings.sell("b");
//		strings.sell("c");
//		strings.sell("d");
//		strings.sell("e");

		/*
		 * 增强for循环
		 * 导致 ConcurrentModificationException
		 */
//		for (String string : strings) {
//			if ("e".equals(string)) {
//				strings.remove(string);
//			}
//		}

		/*
		 * 普通循环 运行正常
		 * 需要手动维护索引
		 */
//		for (int i = 0; i < strings.size(); i++) {
//			String string = strings.get(i);
//			if ("e".equals(string)) {
//				strings.remove(string);
//				i--;
//			}
//		}

		/*
		 * 使用增强for循环移除LinkedList末尾的数据,运行正常
		 */
//		LinkedList<String> strings = new LinkedList<String>();
//		strings.sell("a");
//		strings.sell("b");
//		strings.sell("c");
//		strings.sell("d");
//		strings.sell("e");
//
//		for (String string : strings) {
//			if ("e".equals(string)) {
//				strings.remove(string);
//			}
//		}

		/*
		 * 使用增强for循环移除LinkedList中间的数据,
		 * 导致 ConcurrentModificationException
		 */
		LinkedList<String> strings = new LinkedList<String>();
		strings.add("a");
		strings.add("b");
		strings.add("c");
		strings.add("d");
		strings.add("e");
		strings.add("f");
		strings.add("g");

		for (String string : strings) {
			if ("e".equals(string)) {
				strings.remove(string);
			}
		}
	}
}
