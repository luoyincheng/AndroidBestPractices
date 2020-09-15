package yincheng.tinytank.designpatterns.builder;

/**
 * Mail : luoyincheng@gmail.com
 * Date   : 2018:04:01 21:09
 * Github : yincheng.luo
 */
//todo 为什么为final
public final class Hero {

	private final Profession profession;// TODO: 2018/4/1 to un 为什么都是final
	private final String name;
	private final HairType hairType;
	private final HairColor hairColor;
	private final Armor armor;
	private final Weapon weapon;

	/**
	 * 由于这里的赋值操作是固定的，因此不会出现任何跟赋值顺序有关的问题，
	 * 在调用Builder的时候不需要按照顺序赋值，很随心所欲
	 *
	 * @param builder
	 */
	private Hero(Builder builder) {
		this.profession = builder.mProfession;
		this.name = builder.mName;
		this.hairType = builder.mHairType;
		this.hairColor = builder.mHairColor;
		this.armor = builder.mArmor;
		this.weapon = builder.mWeapon;
	}

	@Override
	public String toString() {
		return new StringBuilder()
				.append(this.profession.name() + ";")
				.append(this.name + ";")
				.append(this.hairType.name() + ";")
				.append(this.hairColor.name() + ";")
				.append(this.armor.name() + ";")
				.append(this.weapon.name())
				.toString()
				.toLowerCase();
	}

	public static class Builder {
		private final Profession mProfession;// TODO: 2018/4/1 to un 为什么是 final
		private final String mName;// TODO: 2018/4/1 to un 为什么是 final
		private HairType mHairType;
		private HairColor mHairColor;
		private Armor mArmor;
		private Weapon mWeapon;

		public Builder(Profession profession, String name) {
			if (profession == null || name == null) {
				throw new IllegalArgumentException("profession and name cannot be null");
			}
			this.mProfession = profession;
			this.mName = name;
		}

		public Builder withHairType(HairType hairType) {
			this.mHairType = hairType;
			return this;
		}

		public Builder withHairColor(HairColor hairColor) {
			this.mHairColor = hairColor;
			return this;
		}

		public Builder withArmor(Armor armor) {
			this.mArmor = armor;
			return this;
		}

		public Builder withWeapon(Weapon weapon) {
			this.mWeapon = weapon;
			return this;
		}

		public Hero Build() {
			return new Hero(this);
		}
	}

}
