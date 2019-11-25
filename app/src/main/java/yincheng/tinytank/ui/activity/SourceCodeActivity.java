package yincheng.tinytank.ui.activity;

import java.util.List;

import yincheng.tinytank.common.GenericItemHolder;
import yincheng.tinytank.ui.activity.base.GenericActivityWithRecyclerView;

import static yincheng.tinytank.provider.ItemHolderProvider.SourceCodeList;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:04:04 7:22
 * Github : yincheng.luo
 */

public class SourceCodeActivity extends GenericActivityWithRecyclerView {

	@Override
	protected List<GenericItemHolder> getGenericItemHolders() {
		return SourceCodeList;
	}
}
