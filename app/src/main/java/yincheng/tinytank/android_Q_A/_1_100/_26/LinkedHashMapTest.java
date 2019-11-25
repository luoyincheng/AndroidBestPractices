package yincheng.tinytank.android_Q_A._1_100._26;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {
	public static void main(String[] args) {
		LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>(5, 0.75f, true);
		linkedHashMap.put(1, "a");
		linkedHashMap.put(2, "b");
		linkedHashMap.put(3, "c");
		linkedHashMap.put(4, "d");
		linkedHashMap.put(5, "e");
		print(linkedHashMap);
		linkedHashMap.get(2);//get一个元素后，这个元素被加到最后，使用了LRU  最近最少被使用的调度算法
		linkedHashMap.put(6, "d3");
		linkedHashMap.put(7, "d11");
		print(linkedHashMap);
	}

	private static void print(LinkedHashMap<Integer, String> linkedHashMap) {
		for (Map.Entry<Integer, String> entry : linkedHashMap.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
		System.out.println("------------------------------------------------");
	}
}
