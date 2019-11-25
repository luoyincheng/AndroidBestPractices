package yincheng.tinytank.android_Q_A.javadesignpatterns.builder;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:05:16 7:56
 * Github : yincheng.luo
 */
public class App {
	public static void main(String[] args) {
		Hero engineer = new Hero
				.Builder(Profession.ENGINEER, "luoyincheng")
				.withWeapon(Weapon.KEYBOARD)
				.withArmor(Armor.CLOTHES)
				.withHairColor(HairColor.BLACK)
				.withHairType(HairType.SHORT)
				.Build();
		System.out.println(engineer.toString());
	}
}
