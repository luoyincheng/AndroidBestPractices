package yincheng.tinytank.java.generic.generic2;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:04:30 16:39
 * Github : yincheng.luo
 */

/**
 * Tuple:元组，它是将一组对象直接打包存储于其中的一个单一对象(就是<>中包含的部分)，这个容器允许队形读取其中的元素，但是不允许向其中存放新的对象，通常，元组允许任意长度，同时，元组中的对象可以是任意不同的类型。
 * 元组隐含的的保持了其中元素的次序
 *
 * @param <A> 类型为public final，保证了客户端程序可以读取和随心所欲的使用的同时也保证了无法将其他值赋予first和second，因为final声明为你卖了相同的安全保险，而且这种格式更加简洁了
 * @param <B> 如果确实希望允许客户端程序员改变first和second所引用的对象，想要使用具有不同元素的元组，就强制要求另外创新一个新的TwoTuple对象
 */
public class TwoTuple<A, B> {
	public final A first;
	public final B second;

	public TwoTuple(A first, B second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public String toString() {
		return "(" + first + "." + second + ")";
	}
}
