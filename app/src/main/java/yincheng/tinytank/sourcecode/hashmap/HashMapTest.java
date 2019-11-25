package yincheng.tinytank.sourcecode.hashmap;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;

public class HashMapTest {
	public static void main(String[] args) {
		for (int binCount = 0; binCount < 10; ++binCount) {
			System.out.println("fadfafd");
		}

		Hashtable hashtable = new Hashtable();
		HashMap hashMap = new HashMap<String, String>();
		hashMap.put("ｗ", "w");
		hashMap.put("o", "o");
		hashMap.put("d", "d");
		hashMap.put("e", "e");
		hashMap.put("s", "s");
		for (Object value : hashMap.values()) {
			System.out.println(value);
		}
		LinkedHashMap linkedHashMap = new LinkedHashMap();
		String toHash = "wodeshijie";
		System.out.println(toHash);
		System.out.println(Integer.toBinaryString(((Object) toHash).hashCode()));
//		System.out.println(Integer.toBinaryString(toHash));
//		System.out.println(Integer.toBinaryString(toHash >>> 16));
		int hashKey = hash(toHash);
		System.out.println(Integer.toBinaryString(hashKey));
		System.out.println(hashKey);
		System.out.println(Integer.toBinaryString(2));
		System.out.println(Integer.toBinaryString(6));
		System.out.println(Integer.toBinaryString(2 | 6));
		System.out.println(Integer.toBinaryString(10 & 8));
		System.out.println(Integer.toBinaryString(2 ^ 6));
		System.out.println(Integer.toBinaryString(tableSizeFor(30)));
		int n = 9;
//		n = (n | n >>> 1);
//		System.out.println(n);
		System.out.println(Integer.toBinaryString(n));
		System.out.println(Integer.toBinaryString(n >>> 1));
		System.out.println(Integer.toBinaryString(n >>> 1 | n));
		System.out.println((n >>> 1 | n));
		System.out.println(tableSizeFor(n));
	}

	static int hash(Object key) {
		int h;
		return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
	}

	static int tableSizeFor(int cap) {
		int n = cap - 1;
		n |= n >>> 1;
		System.out.println("a" + n);
		n |= n >>> 2;
		System.out.println("b" + n);

		n |= n >>> 4;
		System.out.println("c" + n);

		n |= n >>> 8;
		System.out.println("d" + n);

		n |= n >>> 16;
		System.out.println("e" + n);

		return (n < 0) ? 1 : (n >= 1 << 30) ? 1 << 30 : n + 1;
	}
}
