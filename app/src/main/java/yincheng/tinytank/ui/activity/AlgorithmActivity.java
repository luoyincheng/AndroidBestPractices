package yincheng.tinytank.ui.activity;

import java.util.List;

import yincheng.tinytank.common.GenericItemHolder;
import yincheng.tinytank.ui.activity.base.GenericActivityWithRecyclerView;

import static yincheng.tinytank.provider.ItemHolderProvider.AlgorithmList;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:05:10 8:01
 * Github : yincheng.luo
 */
public class AlgorithmActivity extends GenericActivityWithRecyclerView {

	@Override
	protected List<GenericItemHolder> getGenericItemHolders() {
		return AlgorithmList;
	}
}