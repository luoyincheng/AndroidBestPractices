package yincheng.tinytank.provider;

import java.util.Arrays;
import java.util.List;

import yincheng.tinytank.common.GenericItemHolder;
import yincheng.tinytank.java.concurrent.TaskWithResult;

import static yincheng.tinytank.common.GenericItemHolder.ITEM_CLASS_TYPE.DIALOG;
import static yincheng.tinytank.common.GenericItemHolder.ITEM_CLASS_TYPE.DIALOG_FRAGMENT;

/**
 * Mail : luoyincheng@gmail.com
 * Date   : 2018:04:01 17:17
 * Github : yincheng.luo
 */

public class ItemHolderProvider {

	public static final List<GenericItemHolder> mainList =
			Arrays.asList(
					new GenericItemHolder("DataStructure"),
					new GenericItemHolder("Algorithm"),
					new GenericItemHolder("ProgrammingCornerstone"),
					new GenericItemHolder("JavaBasic"),
					new GenericItemHolder("JavaMiddleLevel"),
					new GenericItemHolder("JavaAdvanced"),
					new GenericItemHolder("JavaExtended"),
					new GenericItemHolder("JavaDesignPattern"),
					new GenericItemHolder("AndroidBasic"),
					new GenericItemHolder("AndroidMiddleLevel"),
					new GenericItemHolder("AndroidAdvanced"),
					new GenericItemHolder("AndroidExtended"),
					new GenericItemHolder("SourceCode"),
					new GenericItemHolder("Kotlin"),
					new GenericItemHolder("Architecture"),
					new GenericItemHolder("CodeCollection"),
					new GenericItemHolder("HotTech"),
					new GenericItemHolder("HardwareRelated"),
					new GenericItemHolder("InterviewQuestion"),
					new GenericItemHolder("MarkdownView"),
					new GenericItemHolder("Test"),
					new GenericItemHolder("Toefl"),
					new GenericItemHolder(""),
					new GenericItemHolder("")
			);

	public static final List<GenericItemHolder> DataStructureList =
			Arrays.asList(
					new GenericItemHolder("Set"),
					new GenericItemHolder("HashSet"),
					new GenericItemHolder("ArraySet"),
					new GenericItemHolder("List"),
					new GenericItemHolder("ArrayList"),
					new GenericItemHolder("LinkedList"),
					new GenericItemHolder("Map"),
					new GenericItemHolder("HashMap"),
					new GenericItemHolder("LinkedHashMap"),
					new GenericItemHolder("ArrayMap"),
					new GenericItemHolder("TreeMap"),
					new GenericItemHolder("WeakHashMap"),
					new GenericItemHolder("Vector"),
					new GenericItemHolder("Stack"),
					new GenericItemHolder("HashTable")
			);

	public static final List<GenericItemHolder> InterviewQuestionList =
			Arrays.asList(
					new GenericItemHolder("为什么说Class.forName()方法用到了反射?", DIALOG_FRAGMENT, false),
					new GenericItemHolder("抽象类和接口的区别", DIALOG_FRAGMENT, false),
					new GenericItemHolder("Object.wait()、Object.notify()、Threwad。sleep()区别？",
							DIALOG_FRAGMENT,
							false)
			);

	public static final List<GenericItemHolder> ArchitectureList =
			Arrays.asList(
					new GenericItemHolder("MVP"),
					new GenericItemHolder("MVVM")
			);

	public static final List<GenericItemHolder> DesignPatternsList =
			Arrays.asList(
					new GenericItemHolder("Builder"),
					new GenericItemHolder("Adapter")

			);
	public static final List<GenericItemHolder> KeyBindingList =
			Arrays.asList(
					new GenericItemHolder("显示所有书签:ctrl + 2(非小键盘)")
			);
	// SourceCodeList ==========================================================
	public static final List<GenericItemHolder> SourceCodeList =
			Arrays.asList(
					new GenericItemHolder("HandlerTestActivity"),
					new GenericItemHolder("Timer"),
					new GenericItemHolder("AsyncTask"),
					new GenericItemHolder("DownloadManager"),
					new GenericItemHolder("LruCache"),
					new GenericItemHolder("Observer"),
					new GenericItemHolder("IntentService"),
					new GenericItemHolder("PendingIntent")
			);

	public static final List<GenericItemHolder> HotTechList =
			Arrays.asList(
					new GenericItemHolder("AppUpgrade"),
					new GenericItemHolder("ViewTest")
			);
	public static final List<GenericItemHolder> CodeCollectionList =
			Arrays.asList(
					new GenericItemHolder("AppAutoStart"),
					new GenericItemHolder("AppUpgrade")
			);

	public static final List<GenericItemHolder> AndroidMiddleLevelList =
			Arrays.asList(
					new GenericItemHolder("Xml"),
					new GenericItemHolder("View"),
					new GenericItemHolder("Animation"),
					new GenericItemHolder("Matrix", false, true)
			);
	public static final List<GenericItemHolder> ViewList =
			Arrays.asList(
					new GenericItemHolder("SmartisanPull"),
					new GenericItemHolder("SmartisanSwitchButton"),
					new GenericItemHolder("FlipView"),
					new GenericItemHolder("SuccessTickView", DIALOG, false),
					new GenericItemHolder("PathView", false, true)
			);

	public static final List<GenericItemHolder> AnimationList =
			Arrays.asList(
					new GenericItemHolder("Demo")
			);

	public static final List<GenericItemHolder> AlgorithmList =
			Arrays.asList(
					new GenericItemHolder("Sort"),
					new GenericItemHolder("InterviewAlgorithm"),
					new GenericItemHolder("LeetCode")
			);
	public static final List<GenericItemHolder> LeetCodeList =
			Arrays.asList(
					new GenericItemHolder("ReverseInteger")
			);

	public static final List<String> testStringList =
			Arrays.asList(
					"afsdffasdfwefasdfwf",
					"wodeshijiejasdjfa",
					"34567832rfs"
			);
	public static final List<GenericItemHolder> JavaAdvancedList =
			Arrays.asList(
					new GenericItemHolder("Generic"),
					new GenericItemHolder("Lambda"),
					new GenericItemHolder("Concurrent"),
					new GenericItemHolder("Reflection", GenericItemHolder.ITEM_CLASS_TYPE
							.DIALOG_FRAGMENT, true)
			);
	public static final List<GenericItemHolder> JavaDesignPatternList =
			Arrays.asList(
					new GenericItemHolder("Singleton"),
					new GenericItemHolder("Builder"),
					new GenericItemHolder("AbstractFactory"),
					new GenericItemHolder("FactoryMethod"),
					new GenericItemHolder("Adapter")
			);

	public static final List<GenericItemHolder> ProgrammingCornerstoneList =
			Arrays.asList(
					new GenericItemHolder("Git"),
					new GenericItemHolder("Protocol"),
					new GenericItemHolder("Network")
			);
	public static final List<GenericItemHolder> NetworkList =
			Arrays.asList(
					new GenericItemHolder("CDN", true, true)
			);
	public static final List<GenericItemHolder> ProtocolList =
			Arrays.asList(
					new GenericItemHolder("Socket"),
					new GenericItemHolder("Http"),
					new GenericItemHolder("WebSocket")
			);
	public static final List<GenericItemHolder> HttpList =
			Arrays.asList(
					new GenericItemHolder("HttpResponseCode", true, true)
			);
	public static final List<GenericItemHolder> ConcurrentList =
			Arrays.asList(
					new GenericItemHolder("Callable", GenericItemHolder.ITEM_CLASS_TYPE
							.DIALOG_FRAGMENT, TaskWithResult.class)
			);
	public static final List<GenericItemHolder> GitList =
			Arrays.asList(new GenericItemHolder("SSH", true, true));

	public static final List<GenericItemHolder> EnglishList =
			Arrays.asList(new GenericItemHolder("9.27", true, false));

}
