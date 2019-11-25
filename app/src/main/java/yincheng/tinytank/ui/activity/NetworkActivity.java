package yincheng.tinytank.ui.activity;

import java.util.List;

import yincheng.tinytank.common.GenericItemHolder;
import yincheng.tinytank.provider.ItemHolderProvider;
import yincheng.tinytank.ui.activity.base.GenericActivityWithRecyclerView;

public class NetworkActivity extends GenericActivityWithRecyclerView {
	@Override
	protected List<GenericItemHolder> getGenericItemHolders() {
		return ItemHolderProvider.NetworkList;
	}
}
