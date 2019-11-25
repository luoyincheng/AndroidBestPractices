package yincheng.tinytank.java.generic.generic3;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:05:01 9:48
 * Github : yincheng.luo
 */
public class LinkedStack<T> {
	private static class Node<N> {
		N item;
		Node<N> next;

		Node() {
			item = null;
			next = null;
		}

		Node(N a, Node<N> b) {
			this.item = a;
			this.next = b;
		}

		boolean end() {
			return item == null && next == null;
		}
	}

	/**
	 * 必须为private
	 */
	private Node<T> top = new Node<>();//end sentinel(末端哨兵)

	/**
	 * 做两件事：1.将当前Node作为顶端node 2.将操作之前的topNode链接到被push的Node后面
	 */
	public void push(T item) {
		top = new Node<>(item, top);
	}

	/**
	 * 做两件事: 1.返回topNode 2.判断当前topNode下面还有没有Node，如果有就将下面的Node作为topNode
	 *
	 * @return
	 */
	public T pop() {
		T result = top.item;
		if (!top.end())
			top = top.next;
		return result;
	}

	public static void main(String[] args) {
		LinkedStack<String> linkedStack = new LinkedStack<String>();
		for (String s : "what is broken can be reforged!".split(" ")) {
			linkedStack.push(s);
		}
		String s;
		while ((s = linkedStack.pop()) != null)
			System.out.println(s);//打印的顺序将反序
	}
}
