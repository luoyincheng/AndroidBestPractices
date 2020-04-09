#### DialogFragment中设置回调,应该在onCreate()方法中进行。
- mOnDialogListener = (onDialogListener) getActivity();

#### DialogFragment的两种创建方式：
+ onCreateDialog()方式:用来替代传统的 Dialog 对话框的场景，UI 简单，功能单一。
- 示例1:(创建一个Dialog并返回即可)
```
@Override
public Dialog onCreateDialog(Bundle savedInstanceState) {
  	//为了样式统一和兼容性，可以使用 V7 包下的 AlertDialog.Builder
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
  	// 设置主题的构造方法
	// AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.CustomDialog);
    builder.setTitle("注意：")
           .setMessage("是否退出应用？")
           .setPositiveButton("确定", null)
           .setNegativeButton("取消", null)
           .setCancelable(false);
           //builder.show(); // 不能在这里使用 show() 方法
    return builder.create();
}
```
- 示例2:(自定义View)
```
@Override
public Dialog onCreateDialog(Bundle savedInstanceState) {
	AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//	  AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.CustomDialog);
	LayoutInflater inflater = getActivity().getLayoutInflater();  
    View view = inflater.inflate(R.layout.fragment_dialog, null);  
    builder.setView(view) 
// 	 Do Someting,eg: TextView tv = view.findViewById(R.id.tv);
    return builder.create();
}

```

```
@Override
public Dialog onCreateDialog(Bundle savedInstanceState) {
//      LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context
// .LAYOUT_INFLATER_SERVICE);
//      LayoutInflater inflater = LayoutInflater.from(getActivity());
//      LayoutInflater inflater = getLayoutInflater();
	LayoutInflater inflater = getActivity().getLayoutInflater();
    View view = inflater.inflate(R.layout.fragment_dialog, null);
	Dialog dialog = new Dialog(getActivity());
//      设置主题的构造方法
// 	 Dialog dialog = new Dialog(getActivity(), R.style.CustomDialog);
    dialog.setContentView(view);
	return dialog;
}

```
+ onCreateView()方式:一般用于创建复杂内容弹窗或全屏展示效果的场景，UI 复杂，功能复杂，一般有网络请求等异步操作。
示例1:
```
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	View rootView = inflater.inflate(R.layout.fragment_dialog, container, false);
	// Do Someting
	return rootView;
}
/**
 * 设置主题需要在 onCreate() 方法中调用 setStyle() 方法
 */
@Override
public void onCreate(@Nullable Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setStyle(DialogFragment.STYLE_NO_TITLE, R.style.CustomDialog);
}
```
####无标题栏设置
- 对于方式1:
```
@Override
public Dialog onCreateDialog(Bundle savedInstanceState) {
	LayoutInflater inflater = getActivity().getLayoutInflater();
	View view = inflater.inflate(R.layout.fragment_dialog, null);
	Dialog dialog = new Dialog(getActivity(), R.style.CustomDialog);
  	// 关闭标题栏，setContentView() 之前调用
	dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
	dialog.setContentView(view);
	dialog.setCanceledOnTouchOutside(true);
	return dialog;
}
```
- 对于方式2:
```
@Override
public void onCreate(@Nullable Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	/**
	 * setStyle() 的第一个参数有四个可选值：
	 * STYLE_NORMAL|STYLE_NO_TITLE|STYLE_NO_FRAME|STYLE_NO_INPUT
	 * 其中 STYLE_NO_TITLE 和 STYLE_NO_FRAME 可以关闭标题栏
	 * 每一个参数的详细用途可以直接看 Android 源码的说明
	 */
	setStyle(DialogFragment.STYLE_NO_TITLE, R.style.CustomDialog);
}
```
####全屏实现
- 方式1:
```
@Override
public Dialog onCreateDialog(Bundle savedInstanceState) {
	LayoutInflater inflater = getActivity().getLayoutInflater();
	View view = inflater.inflate(R.layout.fragment_dialog, null);
	Dialog dialog = new Dialog(getActivity(), R.style.CustomDialog);
	dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
	dialog.setContentView(view);
	dialog.setCanceledOnTouchOutside(true);
	//Do something
    // 设置宽度为屏宽、位置靠近屏幕底部
	Window window = dialog.getWindow();
	window.setBackgroundDrawableResource(R.color.transparent);
	WindowManager.LayoutParams wlp = window.getAttributes();
	wlp.gravity = Gravity.BOTTOM;
	wlp.width = WindowManager.LayoutParams.MATCH_PARENT;
  	wlp.height = WindowManager.LayoutParams.WRAP_CONTENT;
	window.setAttributes(wlp);
	return dialog;
}
```
- 方式2:
```
@Override
public void onCreate(@Nullable Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setStyle(DialogFragment.STYLE_NO_TITLE, R.style.CustomDialog);
}
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().setCanceledOnTouchOutside(true);
        View rootView = inflater.inflate(R.layout.fragment_dialog, container, false);
        //Do something
        // 设置宽度为屏宽、靠近屏幕底部。
        final Window window = getDialog().getWindow();
        window.setBackgroundDrawableResource(R.color.transparent);
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams wlp = window.getAttributes();
        wlp.gravity = Gravity.BOTTOM;
        wlp.width = WindowManager.LayoutParams.MATCH_PARENT;
        wlp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(wlp);
        return rootView;
}
```
####居中

####应用场景

- onCreateDialog()为简单的替代 Dialog 提供了非常方便的创建方式，比onCreateView()有优势.
- onCreateDialog()在使用了多线程(例如网络请求)的情况下，不能正确的获取当前 Fragment 的状态，会产生空指针异常。onCreateView()则没有此问题，而且，其创建方式默认使用了自定义 View，更便于应对复杂 UI 的场景。

