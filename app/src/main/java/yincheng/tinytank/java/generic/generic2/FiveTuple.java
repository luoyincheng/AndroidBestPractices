package yincheng.tinytank.java.generic.generic2;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:04:30 17:03
 * Github : yincheng.luo
 */
public class FiveTuple<A, B, C, D, E> extends FourTuple<A, B, C, D> {
	public final E fifth;

	public FiveTuple(A first, B second, C c, D d, E e) {
		super(first, second, c, d);
		this.fifth = e;
	}

	@Override
	public String toString() {
		return "(" + first + "." + second + "." + third + "." + fourth + "." + fifth + ")";
	}
}
