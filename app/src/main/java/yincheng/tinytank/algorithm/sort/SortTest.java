package yincheng.tinytank.algorithm.sort;

import java.util.Arrays;

public class SortTest {
	static int[] source1 = new int[]{4, 5, 6, 2, 4, 56, 4, 3, 11, 24, 89, 11, 0};
	static int[] source2 = new int[]{1, 2, 3, 4, 5};
	static int[] source3 = new int[]{5, 4, 3, 2, 1};

	public static void main(String[] args) {
		System.out.println("bubbleSort:---------------------------------------------");
		sort(source1, "bubbleSort");
		sort(source2, "bubbleSort");
		sort(source3, "bubbleSort");

		System.out.println("selectionSort:---------------------------------------------");
		sort(source1, "selectionSort");
		sort(source2, "selectionSort");
		sort(source3, "selectionSort");

		System.out.println("quickSort:---------------------------------------------");
		sort(source1, "quickSort");
		sort(source2, "quickSort");
		sort(source3, "quickSort");

		System.out.println("mergeSort:---------------------------------------------");
		sort(source1, "mergeSortA");
		sort(source2, "mergeSortA");
		sort(source3, "mergeSortA");

		System.out.println("mergeSortB:---------------------------------------------");
		sort(source1, "mergeSortB");
		sort(source2, "mergeSortB");
		sort(source3, "mergeSortB");

		System.out.println("sources:---------------------------------------------");
		System.out.println(Arrays.toString(source1));
		System.out.println(Arrays.toString(source2));
		System.out.println(Arrays.toString(source3));
	}

	public static void sort(int[] source, String sortMethod) {
		int[] data = source.clone();
		switch (sortMethod) {
			case "bubbleSort":
				BubbleSort.bubbleSort(data);
				break;
			case "selectionSort":
				SelectionSort.selectionIntSort(data);
				break;
			case "quickSort":
				QuickSort.quickSort(data, 0, data.length - 1);
				break;
			case "mergeSortA":
				MergeSort.mergeSortA(data);
				break;
			case "mergeSortB":
				MergeSort.mergeSortB(data);
				break;
		}
		System.out.println(Arrays.toString(data));
	}
}
