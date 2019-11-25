package yincheng.tinytank.android_Q_A.javadesignpatterns.factorymethod;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:05:17 7:39
 * Github : yincheng.luo
 */
public class App {
	private BlackSmith blackSmith;

	public App(BlackSmith blackSmith) {
		this.blackSmith = blackSmith;
	}

	public static void main(String[] args) {
		App app = new App(new OrcBlackSmith());
		app.manufactureWeapons();
		app = new App(new ElfBlackSmith());
		app.manufactureWeapons();
	}

	private void manufactureWeapons() {
		Weapon weapon;
		weapon = blackSmith.manufactureWeapon(WeaponType.SPEAR);
		System.out.println(weapon.toString());
		weapon = blackSmith.manufactureWeapon(WeaponType.AXE);
		System.out.println(weapon.toString());

	}
}
