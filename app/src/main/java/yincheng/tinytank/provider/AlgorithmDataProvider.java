package yincheng.tinytank.provider;

import java.util.Random;

import yincheng.tinytank.common.bean.Node;

/**
 * Created by yincheng on 2018/5/31/10:12.
 * github:luoyincheng
 */
public class AlgorithmDataProvider {
	public static int[] genBreakBinarySearchSortedInt(int from1, int to1, int from2, int to2) {
		if (from1 < to2 || from1 > to1 || from2 > to2) throw new IllegalArgumentException("参数不正确");
		return AlgorithmDataProvider.combineBreakIntArray(genSortedIntArray(from1, to1),
				genSortedIntArray(from2, to2));
	}


	private static int[] combineBreakIntArray(int[] a, int[] b) {
		int[] result = new int[a.length + b.length];
		for (int i = 0; i < result.length; i++) {
			if (i < a.length) result[i] = a[i];
			else result[i] = b[i - a.length];
		}
		return result;
	}

	private static int[] genSortedIntArray(int from, int to) {
		int[] result = new int[to - from + 1];
		for (int i = 0; i < result.length; i++) {
			result[i] = from + i;
		}
		return result;
	}

	public static int[] genRandomIntArray(int size) {
		int range = size * 100;
		int[] result = new int[size];
		for (int i = 0; i < size; i++) {
			result[i] = new Random().nextInt(range);
		}
		return result;
	}

	public static Integer[] genRandomIntegerArray(Integer size) {
		int range = size * 100;
		Integer[] result = new Integer[size];
		for (int i = 0; i < size; i++) {
			result[i] = new Random().nextInt(range);
		}
		return result;
	}

	//============================================================================
	public static Node genSingleLinkedList(int linkedListSize) {
		Node node0 = new Node(0, null);
		Node curNode = null;
		Node tempNode = null;
		for (int i = 1; i < linkedListSize; i++) {
			tempNode = new Node(i, null);
			if (i == 1) node0.nextNode = tempNode;
			else curNode.nextNode = tempNode;
			curNode = tempNode;
		}
		return node0;
	}

//   public static void main(String[] args) {
//      StringBuilder result = new StringBuilder();
//      for (int i = 0; i < 10000; i++) {
//         result.append(new Random().nextInt(100000)).append(",");
//      }
//      System.out.println(result.toString());
//   }
}
