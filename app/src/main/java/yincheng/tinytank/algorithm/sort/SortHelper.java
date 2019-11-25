package yincheng.tinytank.algorithm.sort;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:05:10 8:21
 * Github : yincheng.luo
 */
public class SortHelper {
	public static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	public static void swapComparable(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void swapInt(int[] a, int b, int c) {
		int x = a[b];
		a[b] = a[c];
		a[c] = x;
	}
}
