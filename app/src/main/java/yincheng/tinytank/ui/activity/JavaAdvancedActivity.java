package yincheng.tinytank.ui.activity;

import java.util.List;

import yincheng.tinytank.common.GenericItemHolder;
import yincheng.tinytank.ui.activity.base.GenericActivityWithRecyclerView;

import static yincheng.tinytank.provider.ItemHolderProvider.JavaAdvancedList;

/**
 * Created by yincheng on 2018/5/24/15:16.
 * github:luoyincheng
 */
public class JavaAdvancedActivity extends GenericActivityWithRecyclerView {
	@Override
	protected List<GenericItemHolder> getGenericItemHolders() {
		return JavaAdvancedList;
	}
}
