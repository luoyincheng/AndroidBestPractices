package yincheng.tinytank.algorithm.AlgorithmUtil;

import java.util.ArrayList;

import yincheng.tinytank.algorithm.ListNode;

public class AlgorithmUtil {
	public static void printListNode(ListNode headNode) {
		StringBuilder stringBuilder = new StringBuilder();
		while (headNode != null) {
			stringBuilder.append(headNode.value).append("->");
			headNode = headNode.next;
		}
		System.out.println(stringBuilder.substring(0, stringBuilder.length() - 2));
	}

	public static void printArray(ArrayList<Integer> arrayList) {
		StringBuilder stringBuilder = new StringBuilder();
		for (Integer integer : arrayList) {
			stringBuilder.append(integer + " -> ");
		}
		System.out.println(stringBuilder.substring(0, stringBuilder.length() - 2));
	}
}
