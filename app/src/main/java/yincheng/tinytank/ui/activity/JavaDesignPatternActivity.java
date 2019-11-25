package yincheng.tinytank.ui.activity;

import java.util.List;

import yincheng.tinytank.common.GenericItemHolder;
import yincheng.tinytank.provider.ItemHolderProvider;
import yincheng.tinytank.ui.activity.base.GenericActivityWithRecyclerView;

/**
 * Created by yincheng on 2018/6/26/10:13.
 * github:luoyincheng
 */
public class JavaDesignPatternActivity extends GenericActivityWithRecyclerView {
	@Override
	protected List<GenericItemHolder> getGenericItemHolders() {
		return ItemHolderProvider.JavaDesignPatternList;
	}

//   Hero hero = new Hero
//         .Builder.md(Profession.ENGINEER, "yincheng")
//         .withHairColor(HairColor.BLACK)
//         .withHairType(HairType.SHORT)
//         .withArmor(Armor.LEATHER)
//         .withWeapon(Weapon.KEYBOARD)
//         .Build();
//   Bundle bundle = new Bundle();
//        bundle.putString("hero", hero.toString());
//        return bundle;
}
