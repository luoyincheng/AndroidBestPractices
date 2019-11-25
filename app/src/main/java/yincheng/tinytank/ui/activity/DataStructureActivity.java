package yincheng.tinytank.ui.activity;

import java.util.List;

import yincheng.tinytank.common.GenericItemHolder;
import yincheng.tinytank.ui.activity.base.GenericActivityWithRecyclerView;

import static yincheng.tinytank.provider.ItemHolderProvider.DataStructureList;


/**
 * Mail : luoyincheng@gmail.com
 * Date   : 2018:04:01 16:38
 * Github : yincheng.luo
 */

public class DataStructureActivity extends GenericActivityWithRecyclerView {

	@Override
	protected List<GenericItemHolder> getGenericItemHolders() {
		return DataStructureList;
	}
}