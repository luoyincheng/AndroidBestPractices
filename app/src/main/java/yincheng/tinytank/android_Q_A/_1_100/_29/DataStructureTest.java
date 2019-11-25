package yincheng.tinytank.android_Q_A._1_100._29;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class DataStructureTest {
	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList.add(null);
		arrayList.add(1);
		System.out.println("arrayList size:" + arrayList.size());
		for (Integer integer : arrayList) {
			System.out.println("integer:" + integer);
		}

		Vector<Integer> vector = new Vector<>();
		vector.add(null);
		vector.add(1);
		System.out.println("vector size:" + vector.size());
		for (Integer integer : vector) {
			System.out.println("integer:" + integer);
		}

		HashMap<Integer, Integer> hashMap = new HashMap<>();
		hashMap.put(1, 1);
		hashMap.put(2, 2);
		hashMap.put(null, null);
		hashMap.put(3, null);
		hashMap.put(5, null);
		System.out.println("hashMap size:" + hashMap.size());
		for (Map.Entry<Integer, Integer> integerIntegerEntry : hashMap.entrySet()) {
			System.out.println(integerIntegerEntry.getKey() + ":" + integerIntegerEntry.getValue());
		}
	}
}
