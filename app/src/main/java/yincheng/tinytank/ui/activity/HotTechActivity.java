package yincheng.tinytank.ui.activity;

import android.os.Bundle;

import java.util.List;

import yincheng.tinytank.common.GenericItemHolder;
import yincheng.tinytank.provider.ItemHolderProvider;
import yincheng.tinytank.ui.activity.base.GenericActivityWithRecyclerView;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:04:09 22:16
 * Github : yincheng.luo
 */

public class HotTechActivity extends GenericActivityWithRecyclerView {

	@Override
	protected List<GenericItemHolder> getGenericItemHolders() {
		return ItemHolderProvider.HotTechList;
	}

	@Override
	protected Bundle fillResultData() {
		Bundle bundle = new Bundle();
		bundle.putString("hero", "https://raw.githubusercontent.com/luoyincheng/tinytank/master/app/src/main/assets/app/app-debug.apk");
		return bundle;
	}
}
