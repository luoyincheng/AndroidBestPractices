package yincheng.tinytank.common.bean;

/**
 * Created by yincheng on 2018/6/26/11:44.
 * github:luoyincheng
 */
public class Node {//单链表只有nextNode和当前节点的值
	public int value;
	public Node nextNode;

	public Node(int value, Node nextNode) {
		super();
		this.value = value;
		this.nextNode = nextNode;
	}

	public Node(Node node) {
		this.value = node.value;
		this.nextNode = node.nextNode;
	}

	@Override
	public String toString() {
		return "[" +
				"value:" + value + "," +
				"nextNodeValue:" + (nextNode == null ? "null" : nextNode.value) +
				"]";
	}
}
