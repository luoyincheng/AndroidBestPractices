package yincheng.tinytank.algorithm.interviewQuestion.二分查找;

public class BinarySearch {
	//source必须是有序的
	public static int binarySearch(int target, int[] source) {
		int left = 0, right = source.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (target < source[mid]) right = mid - 1;
			else if (target > source[mid]) left = mid + 1;
			else return mid;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] source = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println(binarySearch(3, source));
	}
}
