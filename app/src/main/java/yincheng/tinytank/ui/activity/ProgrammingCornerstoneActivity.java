package yincheng.tinytank.ui.activity;

import java.util.List;

import yincheng.tinytank.common.GenericItemHolder;
import yincheng.tinytank.ui.activity.base.GenericActivityWithRecyclerView;

import static yincheng.tinytank.provider.ItemHolderProvider.ProgrammingCornerstoneList;

/**
 * Created by yincheng on 2018/6/27/12:11.
 * github:luoyincheng
 */
public class ProgrammingCornerstoneActivity extends GenericActivityWithRecyclerView {
	@Override
	protected List<GenericItemHolder> getGenericItemHolders() {
		return ProgrammingCornerstoneList;
	}
}
