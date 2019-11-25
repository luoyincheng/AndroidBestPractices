package yincheng.tinytank.algorithm.interviewQuestion.二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import yincheng.tinytank.algorithm.BinaryTreeNode;

public class BinaryTreeTest {
	public static void main(String[] args) {
		BinaryTreeNode node1 = new BinaryTreeNode("1");
		BinaryTreeNode node2 = new BinaryTreeNode("2");
		BinaryTreeNode node3 = new BinaryTreeNode("3");
		BinaryTreeNode node4 = new BinaryTreeNode("4");
		BinaryTreeNode node5 = new BinaryTreeNode("5");
		BinaryTreeNode node6 = new BinaryTreeNode("6");
		BinaryTreeNode node7 = new BinaryTreeNode("7");
		BinaryTreeNode node8 = new BinaryTreeNode("8");
		BinaryTreeNode node9 = new BinaryTreeNode("9");
		BinaryTreeNode node10 = new BinaryTreeNode("10");

		node1.left = node2;
		node1.right = node8;
		node2.left = node3;
		node2.right = node4;
		node3.right = node5;
		node4.left = node6;
		node4.right = node7;
		node8.left = node9;
		node8.right = node10;

		System.out.println(preorderTraversal(node1));
		System.out.println(middleOrderTraversal(node1));
		System.out.println(postorderTraversal(node1));
	}

	/**
	 * 先序遍历：root -> left -> right
	 * treeNodeStack用来回溯
	 */
	private static List<String> preorderTraversal(BinaryTreeNode rootNode) {
		List<String> result = new ArrayList<>();
		Stack<BinaryTreeNode> binaryTreeNodeStack = new Stack<>();
		BinaryTreeNode node = rootNode;
		while (node != null || !binaryTreeNodeStack.isEmpty()) {
			while (node != null) {
				result.add(node.val);
				binaryTreeNodeStack.push(node);
				node = node.left;
			}
			if (!binaryTreeNodeStack.isEmpty()) {
				node = binaryTreeNodeStack.pop();
				node = node.right;
			}
		}
		return result;
	}

	/**
	 * 中序遍历：left -> root -> right
	 */
	private static List<String> middleOrderTraversal(BinaryTreeNode rootNode) {
		List<String> result = new ArrayList<>();
		Stack<BinaryTreeNode> binaryTreeNodeStack = new Stack<>();
		BinaryTreeNode node = rootNode;
		while (node != null || !binaryTreeNodeStack.isEmpty()) {
			while (node != null) {
				binaryTreeNodeStack.push(node);
				node = node.left;
			}
			if (!binaryTreeNodeStack.isEmpty()) {
				node = binaryTreeNodeStack.pop();
				result.add(node.val);
				node = node.right;
			}
		}
		return result;
	}

	/*
	 * 后序遍历：left -> right -> root
	 */
	private static List<String> postorderTraversal(BinaryTreeNode rootNode) {
		List<String> result = new ArrayList<>();
		Stack<BinaryTreeNode> binaryTreeNodeStack = new Stack<>();
		BinaryTreeNode node = rootNode;
		BinaryTreeNode lastVisit = rootNode;
		while (node != null || !binaryTreeNodeStack.isEmpty()) {
			while (node != null) {
				binaryTreeNodeStack.push(node);
				node = node.left;
			}
			node = binaryTreeNodeStack.peek();
			if (node.right == null || node.right == lastVisit) {
				result.add(node.val);
				binaryTreeNodeStack.pop();
				lastVisit = node;
				node = null;
			} else {
				node = node.right;
			}
		}
		return result;
	}
}