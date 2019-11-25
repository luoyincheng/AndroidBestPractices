package yincheng.tinytank.android_Q_A.javadesignpatterns.factorymethod;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:05:17 7:36
 * Github : yincheng.luo
 */
public class ElfBlackSmith implements BlackSmith {
	@Override
	public Weapon manufactureWeapon(WeaponType weaponType) {
		return new ElfWeapon(weaponType);
	}
}
