package yincheng.tinytank.ui.activity;

import java.util.Arrays;
import java.util.List;

import yincheng.tinytank.algorithm.sort.QuickSort;
import yincheng.tinytank.algorithm.sort.SelectionSort;
import yincheng.tinytank.common.GenericItemHolder;
import yincheng.tinytank.ui.activity.base.AlgorithmRunnableRecyclerViewActivity;

import static yincheng.tinytank.provider.AlgorithmDataProvider.genRandomIntArray;
import static yincheng.tinytank.provider.AlgorithmDataProvider.genRandomIntegerArray;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:05:30 21:40
 * Github : yincheng.luo
 */
public class SortActivity extends AlgorithmRunnableRecyclerViewActivity {
	@Override
	protected List<GenericItemHolder> getGenericItemHolders() {
		Runnable selectionSortIntRunnable = () -> computationConsumer(
				genMethod(SelectionSort.class, "selectionIntSort", int[].class), genRandomIntArray
						(1000), null);
		Runnable selectionSortIntegerRunnable = () -> computationConsumer(
				genMethod(SelectionSort.class, "selectionIntegerSort", Comparable[].class),
				genRandomIntegerArray(1000),
				null);
		Runnable quickSortRunnable = () -> computationConsumer(
				genMethod(QuickSort.class, "quickSort", int[].class), genRandomIntArray(1000),
				null);
		Runnable quickSortIntRunnable = () -> computationConsumer(
				genMethod(QuickSort.class, "quickIntSort", int[].class), genRandomIntArray(1000),
				null);
		Runnable quickSortIntegerRunnable = () -> computationConsumer(
				genMethod(QuickSort.class, "quickIntegerSort", Comparable[].class),
				genRandomIntegerArray(1000),
				null);
		return Arrays.asList(
				new GenericItemHolder("SelectionSortInt", true, selectionSortIntRunnable),
				new GenericItemHolder("SelectionSortInteger", true, selectionSortIntegerRunnable),
				new GenericItemHolder("quickSort", true, quickSortRunnable),
				new GenericItemHolder("quickSortInt", true, quickSortIntRunnable),
				new GenericItemHolder("quickSortInteger", true, quickSortIntegerRunnable)
		);
	}
}