package yincheng.tinytank.android_Q_A.javadesignpatterns.factorymethod;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:05:17 7:27
 * Github : yincheng.luo
 */
public interface BlackSmith {
	Weapon manufactureWeapon(WeaponType weaponType);
}
