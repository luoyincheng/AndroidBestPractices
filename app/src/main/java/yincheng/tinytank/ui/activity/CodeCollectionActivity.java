package yincheng.tinytank.ui.activity;

import java.util.List;

import yincheng.tinytank.common.GenericItemHolder;
import yincheng.tinytank.ui.activity.base.GenericActivityWithRecyclerView;

import static yincheng.tinytank.provider.ItemHolderProvider.CodeCollectionList;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:04:11 21:22
 * Github : yincheng.luo
 */

public class CodeCollectionActivity extends GenericActivityWithRecyclerView {

	@Override
	protected List<GenericItemHolder> getGenericItemHolders() {
		return CodeCollectionList;
	}
}
