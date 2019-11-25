package yincheng.tinytank.android_Q_A.javadesignpatterns.factorymethod;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:05:17 7:34
 * Github : yincheng.luo
 */
public class ElfWeapon implements Weapon {
	WeaponType weaponType;

	public ElfWeapon(WeaponType weaponType) {
		this.weaponType = weaponType;
	}

	@Override
	public WeaponType getWeaponType() {
		return weaponType;
	}

	@Override
	public String toString() {
		return "ElfWeapon{" +
				"weaponType=" + weaponType +
				'}';
	}
}
