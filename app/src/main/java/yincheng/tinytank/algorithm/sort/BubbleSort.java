package yincheng.tinytank.algorithm.sort;

public class BubbleSort {
	public static int[] bubbleSort(int[] data) {
		if (data == null || data.length == 0) {
			return null;
		}
		int temp;
		for (int i = 0; i < data.length - 1; i++) {
			for (int j = 0; j < data.length - 1 - i; j++) {
				if (data[j] > data[j + 1]) {
					temp = data[j];
					data[j] = data[j + 1];
					data[j + 1] = temp;
				}
			}
		}
		return data;
	}
}
