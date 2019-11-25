package yincheng.tinytank.ui.activity;

import java.util.List;

import yincheng.tinytank.common.GenericItemHolder;
import yincheng.tinytank.ui.activity.base.GenericActivityWithRecyclerView;

import static yincheng.tinytank.provider.ItemHolderProvider.GitList;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:07:29 10:56
 * Github : yincheng.luo
 */
public class GitActivity extends GenericActivityWithRecyclerView {
	@Override
	protected List<GenericItemHolder> getGenericItemHolders() {
		return GitList;
	}
}
