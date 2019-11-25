package yincheng.tinytank.android_Q_A.javadesignpatterns.builder;

/**
 * Mail : luoyincheng@gmail.com
 * Date   : 2018:04:01 21:04
 * Github : yincheng.luo
 */

public enum HairType {

	BALD("bald"), SHORT("short"), CURLY("curly"), LONG_STRIGHT("long_stright"), LONG_CURLY("long_curly");

	private String type;

	HairType(String type) {
		this.type = type;
	}


	@Override
	public String toString() {
		return type;
	}
}
