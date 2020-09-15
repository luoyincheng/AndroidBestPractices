package yincheng.tinytank.designpatterns.builder;

/**
 * Mail : luoyincheng@gmail.com
 * Date   : 2018:04:01 21:07
 * Github : yincheng.luo
 */

public enum Profession {

	ENGINEER, PRIEST, THIEF, WARRIOR;

	@Override
	public String toString() {
		return name().toLowerCase();
	}
}
