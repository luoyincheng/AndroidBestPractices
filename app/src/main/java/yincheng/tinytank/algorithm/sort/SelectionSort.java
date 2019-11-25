package yincheng.tinytank.algorithm.sort;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:05:10 8:17
 * Github : yincheng.luo
 */
public class SelectionSort {
	/**
	 * 比如数组{4,6,3,8,0,2,5,1},从小到大排序,“|”为分割线，表示当前排好的序列的终点
	 * 1. 找出所有数中最小的，这里是0，然后将他放到最左边:{0,|6,3,8,2,5,1}
	 * 2. 找出“|”右边所有数中最小的，这里是1，然后将他放到“|”左边:{0,1,|6,3,8,2,5}
	 * 3. 找出“|”右边所有数中最小的，这里是2，然后将他放到“|”左边:{0,1,2,|6,3,8,5}
	 * ...
	 */
	public static int[] selectionIntSort(int[] intArgs) {
		int argsSize = intArgs.length;
		for (int i = 0; i < argsSize; i++) {
			int minIndex = i;
			for (int j = i + 1; j < argsSize; j++)
				if (intArgs[j] < intArgs[minIndex]) minIndex = j;
			SortHelper.swapInt(intArgs, i, minIndex);
		}
		return intArgs;
	}
}
