package yincheng.tinytank.android_Q_A.javadesignpatterns.builder;

/**
 * Mail : luoyincheng@gmail.com
 * Date   : 2018:04:01 21:09
 * Github : yincheng.luo
 */

public enum Weapon {

	KEYBOARD, DAGGER, SWORD, AXE, WARHAMMER, BOW;

	@Override
	public String toString() {
		return name().toLowerCase();
	}
}
