package yincheng.tinytank.algorithm.sort;

import static yincheng.tinytank.algorithm.sort.SortHelper.less;
import static yincheng.tinytank.algorithm.sort.SortHelper.swapComparable;
import static yincheng.tinytank.algorithm.sort.SortHelper.swapInt;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:06:28 21:53
 * Github : yincheng.luo
 */
public class QuickSort {
	public static int[] quickSort(int[] sources, int low, int high) {
		if (high <= low) return sources;
		int pivot = partition(sources, low, high);
		quickSort(sources, low, pivot - 1);
		quickSort(sources, pivot + 1, high);
		return sources;
	}

	public static Comparable[] quickSort(Comparable[] comparables, int low, int high) {
		if (high <= low) return comparables;
		int pivot = partition(comparables, low, high);
		quickSort(comparables, low, pivot - 1);
		quickSort(comparables, pivot + 1, high);
		return comparables;
	}

	private static int partition(int[] sources, int low, int high) {
		int i = low, j = high + 1;
		int settledInt = sources[low];
		while (true) {
			while (sources[++i] < settledInt) if (i == high) break;
			while (settledInt < sources[--j]) if (j == low) break;
			if (i >= j) break;
			swapInt(sources, i, j);
		}
		swapInt(sources, low, j);
		return j;
	}

	private static int partition(Comparable[] comparables, int low, int high) {
		int i = low, j = high + 1;
		Comparable comparable = comparables[low];
		while (true) {
			while (less(comparables[++i], comparable)) if (i == high) break;
			while (less(comparable, comparables[--j])) if (j == low) break;
			if (i >= j) break;
			swapComparable(comparables, i, j);
		}
		swapComparable(comparables, low, j);
		return j;
	}
}
