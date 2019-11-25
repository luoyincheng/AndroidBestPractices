package yincheng.tinytank.algorithm.interviewQuestion.一个数组从左到右从上到下都生序求指定的数字的位置;

import java.util.Arrays;

public class App {

	public static void main(String[] args) {
		int[][] source = new int[][]{
				{1, 2, 3, 4, 5},
				{2, 3, 4, 5, 6},
				{3, 4, 5, 6, 7}
		};
		System.out.println(Arrays.toString(findIndex(source, 2)));
	}

	private static int[] findIndex(int[][] source, int target) {
		int[] result = new int[2];
		int startX = 0;
		int startY = 0;
		int endX = source[0].length;
		int endY = source.length;
		int middleX = (startX + endX) / 2;
		int middleY = (startY + endY) / 2;
		System.out.println(endX + ":" + endY);
		System.out.println(endX + ":" + endY + ":" + middleX + ":" + middleY);
		while (startX <= endX && startY <= endY) {
			if (source[middleX][middleY] > target) {
				endX = middleX + 1;
				endY = middleY + 1;
			} else if (source[middleX][middleY] < target) {

			} else {
				result[0] = middleX;
				result[1] = middleY;
			}
		}
		return result;
	}
}
