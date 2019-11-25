package yincheng.tinytank.ui.activity;

import java.util.List;

import yincheng.tinytank.common.GenericItemHolder;
import yincheng.tinytank.ui.activity.base.GenericActivityWithRecyclerView;

import static yincheng.tinytank.provider.ItemHolderProvider.ViewList;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:04:16 22:12
 * Github : yincheng.luo
 */

public class ViewActivity extends GenericActivityWithRecyclerView {
	@Override
	protected List<GenericItemHolder> getGenericItemHolders() {
		return ViewList;
	}
}