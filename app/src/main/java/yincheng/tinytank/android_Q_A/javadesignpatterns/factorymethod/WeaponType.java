package yincheng.tinytank.android_Q_A.javadesignpatterns.factorymethod;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:05:17 7:29
 * Github : yincheng.luo
 */
public enum WeaponType {
	SHORT_SWORD("short sword"), SPEAR("spear"), AXE("axe"), UNDEFINED("");
	private String title;

	WeaponType(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "WeaponType{" +
				"title='" + title + '\'' +
				'}';
	}
}
