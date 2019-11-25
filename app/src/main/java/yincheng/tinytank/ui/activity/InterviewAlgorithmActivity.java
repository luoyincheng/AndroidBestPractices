package yincheng.tinytank.ui.activity;

import java.util.Arrays;
import java.util.List;

import yincheng.tinytank.algorithm.interviewQuestion.InterviewAlgorithm1;
import yincheng.tinytank.common.GenericItemHolder;
import yincheng.tinytank.ui.activity.base.AlgorithmRunnableRecyclerViewActivity;

import static yincheng.tinytank.provider.AlgorithmDataProvider.genBreakBinarySearchSortedInt;

/**
 * Created by yincheng on 2018/6/25/11:14.
 * github:luoyincheng
 */
public class InterviewAlgorithmActivity extends AlgorithmRunnableRecyclerViewActivity {
	@Override
	protected List<GenericItemHolder> getGenericItemHolders() {
		Runnable BreakBinarySearchRunnable = () -> computationConsumer(
				genMethod(InterviewAlgorithm1.class, "breakBinarySearch", int[].class, int.class),
				genBreakBinarySearchSortedInt(100, 110, 80, 90),
				85);
//      Runnable CopyReverseSingleLinkedListRunnable = () -> BinarySearchConsumer
//            ("CopyReverseSingleLinkedList");
//      Runnable ReverseSingleLinkedListRunnable = () -> BinarySearchConsumer
//            ("TraverseReverseSingleLinkedList");
//      Runnable RecursiveReverseSingleLinkedList = () -> BinarySearchConsumer
//            ("RecursiveReverseSingleLinkedList");

		return Arrays.asList(
				new GenericItemHolder("BreakBinarySearch", true, BreakBinarySearchRunnable)
//            new GenericItemHolder("CopyReverseSingleLinkedList", true,
//                  CopyReverseSingleLinkedListRunnable),
//            new GenericItemHolder("TraverseReverseSingleLinkedList", false,
//                  ReverseSingleLinkedListRunnable),
//            new GenericItemHolder("RecursiveReverseSingleLinkedList", false,
//                  RecursiveReverseSingleLinkedList)
		);
	}

//   public Disposable BinarySearchConsumer(String method) {
//      StringBuilder sourceDataBuilder = new StringBuilder();
//      StringBuilder usedTimeBuilder = new StringBuilder();
//      StringBuilder resultBuilder = new StringBuilder();
//      return ObservableCreate
//            .create((ObservableOnSubscribe<String>) emitter -> {
//               switch (method) {
//                  case "BreakBinarySearch":
//                     int[] data = genBreakBinarySearchSortedInt(100, 110, 80, 90);
//                     for (int i = 0; i < data.length; i++) {
//                        if (i == 0)
//                           sourceDataBuilder.append(String.valueOf(data[i]));
//                        else sourceDataBuilder.append(",").append(String.valueOf(data[i]));
//                     }
//                     resultBuilder.append(String.valueOf(breakBinarySearch
//                           (data, 0, data.length - 1, 85)));
//                     emitter.onNext(resultBuilder.toString());
//                     break;
//                  case "CopyReverseSingleLinkedList":
//                     Node node0 = genSingleLinkedList(30);
//                     Node node0Copy = genSingleLinkedList(30);
//                     Node reversedNode0 = copyReverseSingleLinkedList(node0);
//                     while (node0Copy != null) {
//                        sourceDataBuilder.append(node0Copy.toString()).append(node0Copy
//                              .nextNode == null ? "" : "\n");
//                        node0Copy = node0Copy.nextNode;
//                     }
//                     while (reversedNode0 != null) {
//                        resultBuilder.append(reversedNode0.toString()).append
//                              (reversedNode0.nextNode == null ? "" : "\n");
//                        reversedNode0 = reversedNode0.nextNode;
//                     }
//                     emitter.onNext(resultBuilder.toString());
//                     break;
//                  case "TraverseReverseSingleLinkedList":
//                     Node node1 = genSingleLinkedList(30);
//                     Node node11 = genSingleLinkedList(30);
//                     Node reversedNode1 = traverseReverseSingleLinkedList(node1);
//                     while (node11 != null) {
//                        sourceDataBuilder.append(node11.toString()).append(node11.nextNode ==
//                              null ? "" : "\n");
//                        node11 = node11.nextNode;
//                     }
//                     while (reversedNode1 != null) {
//                        resultBuilder.append(reversedNode1.toString()).append
//                              (reversedNode1.nextNode == null ? "" : "\n");
//                        reversedNode1 = reversedNode1.nextNode;
//                     }
//                     emitter.onNext(resultBuilder.toString());
//                     break;
//                  case "RecursiveReverseSingleLinkedList":
//                     Node node2 = genSingleLinkedList(30);
//                     Node node22 = genSingleLinkedList(30);
//                     Node reversedNode2 = recursiveReverseSingleLinkedList(node2);
//                     while (node22 != null) {
//                        sourceDataBuilder.append(node22.toString()).append(node22.nextNode ==
//                              null ? "" : "\n");
//                        node22 = node22.nextNode;
//                     }
//                     while (reversedNode2 != null) {
//                        resultBuilder.append(reversedNode2.toString()).append
//                              (reversedNode2.nextNode == null ? "" : "\n");
//                        reversedNode2 = reversedNode2.nextNode;
//                     }
//                     emitter.onNext(resultBuilder.toString());
//                     break;
//               }
//            })
//            .subscribeOn(Schedulers.computation())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(s -> MessageDialogView
//                  .newInstance(method + ":",
//                        sourceDataBuilder.toString(),//直接使用变量来传递
//                        usedTimeBuilder.toString(),//直接使用变量来传递
//                        s,//emitter发送而来
//                        false,
//                        Bundler.create()
//                              .put(BundleConstant.YES_EXTRA, false)
//                              .end(), true)
//                  .show(getSupportFragmentManager(), MessageDialogView.TAG));
//   }
}
