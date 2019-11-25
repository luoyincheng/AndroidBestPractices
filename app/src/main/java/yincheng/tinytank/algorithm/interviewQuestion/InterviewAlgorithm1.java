package yincheng.tinytank.algorithm.interviewQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import yincheng.tinytank.common.bean.Node;
import yincheng.tinytank.provider.data.Student;

import static java.util.Arrays.binarySearch;

/**
 * Created by yincheng on 2018/6/25/10:47.
 * github:luoyincheng
 */
public class InterviewAlgorithm1 {
	/**
	 * 一个从小到大排好序的数组，从某一个位置断开分为两个有序的数组，
	 * 将后面的数组放到前面形成一个新的有了“断层”的数组，现在在新生成的数组中进行查找，
	 * 能否使用二分查找？？？
	 * <p>
	 * 原始数据:1,2,3,4,5,6,7,8,9,10,11,12,13,14,15
	 *
	 * @param data:6,7,8,9,10,11,12,13,14,15,1,2,3,4,5,打乱以后的情况1，第一部分数据较多，有10个
	 * @param data:11,12,13,14,15,1,2,3,4,5,6,7,8,9,10,打乱以后的情况2，第一部分数据较少，只有5个
	 */
	public static int breakBinarySearch(int[] data, int targetNum) {
		return breakBinarySearch(data, 0, data.length - 1, targetNum);
	}

	private static int breakBinarySearch(int[] data, int startIndex, int endIndex, int targetNum) {
		int middleIndex = (startIndex + endIndex) / 2;
		if (data[middleIndex] > data[endIndex]) {//情况1,第一部分数据较多
			if (targetNum < data[middleIndex] && targetNum >= data[startIndex]) {
				return binarySearch(data, 0, middleIndex, targetNum);
			} else {
				return breakBinarySearch(data, middleIndex, endIndex, targetNum);
			}
		} else if (data[middleIndex] < data[endIndex]) {//情况2，第二部分数据较多
			if (targetNum > data[middleIndex] && targetNum <= data[endIndex]) {
				return binarySearch(data, middleIndex, endIndex, targetNum);
			} else {
				return breakBinarySearch(data, 0, middleIndex, targetNum);
			}
		} else return middleIndex;
	}

	//-----------------------------------------------------------------------------
	public static Node copyReverseSingleLinkedList(Node headNode) {//向右的链表
		if (headNode == null || headNode.nextNode == null) return headNode;
		Node nextNode = headNode.nextNode;
		Node tempNode = headNode;
		headNode.nextNode = null;
		while (nextNode != null) {
			tempNode = new Node(nextNode.value, tempNode);
			nextNode = nextNode.nextNode;
		}
		return tempNode;
	}

	public static Node traverseReverseSingleLinkedList(Node headNode) {
		if (headNode == null || headNode.nextNode == null) return headNode;
		Node preNode = headNode;
		Node currentNode = headNode.nextNode;
		Node nextNode;
		while (currentNode != null) {
			nextNode = currentNode.nextNode;
			currentNode.nextNode = preNode;
			preNode = currentNode;
			currentNode = nextNode;
		}
		headNode.nextNode = null;
		return preNode;
	}

	public static Node recursiveReverseSingleLinkedList(Node headNode) {
		if (headNode == null || headNode.nextNode == null) return headNode;
		Node nextNode = headNode.nextNode;
		headNode.nextNode = null;//切断链表中Node之间的联系
		Node node = recursiveReverseSingleLinkedList(nextNode);
		nextNode.nextNode = headNode;
		return node;
	}
	//-----------------------------------------------------------------------------

	private static void hashMapSort() {
		HashMap hashMapToSort = new HashMap<Integer, Student>();
		hashMapToSort.put(1, new Student(3, "3", Arrays.asList("a")));
		hashMapToSort.put(4, new Student(1, "1", Arrays.asList("a")));
		hashMapToSort.put(3, new Student(4, "4", Arrays.asList("a")));
		hashMapToSort.put(2, new Student(2, "2", Arrays.asList("a")));

		ArrayList<Map.Entry<Integer, Student>> arrayList = new ArrayList<Map.Entry<Integer, Student>>(hashMapToSort.entrySet());
		Collections.sort(arrayList, new Comparator<Map.Entry<Integer, Student>>() {
			@Override
			public int compare(Map.Entry<Integer, Student> o1, Map.Entry<Integer, Student> o2) {
				return o2.getValue().getAge() - o1.getValue().getAge();
			}
		});

		LinkedHashMap<Integer, Student> result = new LinkedHashMap<>();

		for (Map.Entry<Integer, Student> entry : arrayList) {
			result.put(entry.getKey(), entry.getValue());
		}
		System.out.println(arrayList);
		System.out.println(result);
	}

	public static void main(String[] args) {
		hashMapSort();
	}
}
