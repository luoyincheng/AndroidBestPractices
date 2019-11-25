package yincheng.tinytank.ui.activity;

import java.util.List;

import yincheng.tinytank.common.GenericItemHolder;
import yincheng.tinytank.provider.ItemHolderProvider;
import yincheng.tinytank.ui.activity.base.GenericActivityWithRecyclerView;

/**
 * Created by yincheng on 2018/6/28/14:53.
 * github:luoyincheng
 */
public class ConcurrentActivity extends GenericActivityWithRecyclerView {
	@Override
	protected List<GenericItemHolder> getGenericItemHolders() {
		return ItemHolderProvider.ConcurrentList;
	}
}
