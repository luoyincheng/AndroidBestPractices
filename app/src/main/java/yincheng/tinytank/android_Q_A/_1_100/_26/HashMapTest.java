package yincheng.tinytank.android_Q_A._1_100._26;

import androidx.annotation.NonNull;

import java.util.HashMap;

public class HashMapTest {
	public static void main(String[] args) {
		HashMap<String, String> hashMap = new HashMap<>();
		hashMap.put("mineCraft", "我的世界");
		System.out.println(Integer.toBinaryString(5));
		System.out.println("0" + Integer.toBinaryString(3));
		System.out.println(5 & 3);
		System.out.println(5 | 3);
		System.out.println(5 ^ 3);

		int hashCode = "mineCraft".hashCode();
		System.out.println(hashCode + " - " + Integer.toBinaryString(hashCode));

		int splitHashCode = hashCode >>> 16;
		System.out.println(splitHashCode + " - " + Integer.toBinaryString(splitHashCode));

		int resultHash = hashCode ^ splitHashCode;
		System.out.println(resultHash + " - " + Integer.toBinaryString(resultHash));

		int resultDecimal = hash("mineCraft");
		System.out.println(resultDecimal + ":" + Integer.toBinaryString(resultDecimal));

		int testA = 0b0000100110001101;
		int testB = 0b10011110101011;
		System.out.println(Integer.toBinaryString(testA ^ testB));
	}

	static final int hash(@NonNull Object key) {
		int h;
		return (h = key.hashCode()) ^ (h >>> 16);
	}
}
