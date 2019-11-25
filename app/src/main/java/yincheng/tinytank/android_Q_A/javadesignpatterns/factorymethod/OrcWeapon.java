package yincheng.tinytank.android_Q_A.javadesignpatterns.factorymethod;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:05:17 7:32
 * Github : yincheng.luo
 */
public class OrcWeapon implements Weapon {
	private WeaponType weaponType;

	public OrcWeapon(WeaponType weaponType) {
		this.weaponType = weaponType;
	}

	@Override
	public WeaponType getWeaponType() {
		return weaponType;
	}

	@Override
	public String toString() {
		return "OrcWeapon{" +
				"weaponType=" + weaponType +
				'}';
	}
}
