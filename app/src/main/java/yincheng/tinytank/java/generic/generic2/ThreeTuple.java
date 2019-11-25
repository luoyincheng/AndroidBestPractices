package yincheng.tinytank.java.generic.generic2;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:04:30 16:56
 * Github : yincheng.luo
 */
public class ThreeTuple<A, B, C> extends TwoTuple<A, B> {
	public final C third;

	public ThreeTuple(A first, B second, C c) {
		super(first, second);
		third = c;
	}

	@Override
	public String toString() {
		return "(" + first + "." + second + "." + third + ")";
	}
}
