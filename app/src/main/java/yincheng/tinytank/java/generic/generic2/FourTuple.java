package yincheng.tinytank.java.generic.generic2;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:04:30 17:01
 * Github : yincheng.luo
 */
public class FourTuple<A, B, C, D> extends ThreeTuple<A, B, C> {
	public final D fourth;

	public FourTuple(A first, B second, C c, D d) {
		super(first, second, c);
		this.fourth = d;
	}

	@Override
	public String toString() {
		return "(" + first + "." + second + "." + third + "." + fourth + ")";
	}
}
