package yincheng.tinytank.java.generic.generic5;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:04:19 8:18
 * Github : yincheng.luo
 */

public class Coffee {
	private static long counter = 0;
	private final long id = counter++;

	@Override
	public String toString() {
		return getClass().getSimpleName() + " " + id;
	}
}
