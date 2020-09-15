package yincheng.tinytank.designpatterns.builder;

/**
 * Mail : luoyincheng@gmail.com
 * Date   : 2018:04:01 21:01
 * Github : yincheng.luo
 */

public enum HairColor {

	WHITE, BLACK, YELLOW, RED, BROWN;

	@Override
	public String toString() {
		return name().toLowerCase();
	}
}
