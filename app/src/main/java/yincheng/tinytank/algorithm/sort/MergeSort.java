package yincheng.tinytank.algorithm.sort;

public class MergeSort {
	private static int[] helperArray;

	public static void mergeSortB(int[] source) {
		int n = source.length;
		helperArray = new int[source.length];
		for (int sz = 1; sz < n; sz = sz + sz)
			for (int left = 0; left < n - sz; left += sz + sz)
				merge(source, left, left + sz - 1, Math.min(left + sz + sz - 1, n - 1));
	}

	public static void mergeSortA(int[] source) {
		helperArray = new int[source.length];
		mergeSort(source, 0, source.length - 1);
	}

	private static void mergeSort(int[] source, int leftIndex, int rightIndex) {
		if (leftIndex >= rightIndex) return;
		int middleIndex = (leftIndex + rightIndex) / 2;
		mergeSort(source, leftIndex, middleIndex);
		mergeSort(source, middleIndex + 1, rightIndex);
		merge(source, leftIndex, middleIndex, rightIndex);
	}

	private static void merge(int[] source, int leftIndex, int middleIndex, int rightIndex) {
		int leftStartIndex = leftIndex, rightStartIndex = middleIndex + 1;
		for (int k = leftIndex; k <= rightIndex; k++)
			helperArray[k] = source[k];
		for (int k = leftIndex; k <= rightIndex; k++) {
			if (leftStartIndex > middleIndex) source[k] = helperArray[rightStartIndex++];
			else if (rightStartIndex > rightIndex) source[k] = helperArray[leftStartIndex++];
			else if (helperArray[leftStartIndex] < helperArray[rightStartIndex])
				source[k] = helperArray[leftStartIndex++];
			else source[k] = helperArray[rightStartIndex++];
		}
	}
}
