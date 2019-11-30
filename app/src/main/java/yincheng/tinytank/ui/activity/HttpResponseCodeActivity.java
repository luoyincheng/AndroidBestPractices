package yincheng.tinytank.ui.activity;

import android.widget.Toast;

import com.zzhoujay.richtext.RichText;
import com.zzhoujay.richtext.callback.OnUrlClickListener;

import yincheng.tinytank.ui.activity.base.RichTextActivity;

/**
 * Created by yincheng on 2018/6/27/12:16.
 * github:luoyincheng
 */
public class HttpResponseCodeActivity extends RichTextActivity {
	@Override
	protected void initData() {

	}

	@Override
	protected void initView() {
		RichText.fromMarkdown("- HandlerActivity.post(Runnable runnable)" +
				"方法是有返回值的，只有在Runnable成功放到messageQueue中以后才会返回True，否则返回false\n" +
				"\n" +
				"\n" +
				"|HandlerActivity|Looper|Thread|MessageQueue|\n" +
				"|:-----:|:----:|:----:|:----------:|\n" +
				"|Looper|Looper|Thread|MessageQueue|\n" +
				"\n" +
				"``` \n" +
				"public HandlerActivity(Looper looper) {\n" +
				"    this(looper, null, false);\n" +
				"}\n" +
				"```\n" +
				"    \n" +
				"```\n" +
				"public class UiThreadExecutor implements Executor {\n" +
				"\n" +
				"    private final HandlerActivity uiHandler = new HandlerActivity(Looper.getMainLooper());\n" +
				"\n" +
				"    private Thread mUiThread = Looper.getMainLooper().getThread();\n" +
				"\n" +
				"    @Override\n" +
				"    public void execute(@NonNull Runnable command) {\n" +
				"        if (Thread.currentThread() == mUiThread) {\n" +
				"            // already on main thread, simply execute\n" +
				"            command.run();\n" +
				"        } else {\n" +
				"            uiHandler.post(command);\n" +
				"        }\n" +
				"    }\n" +
				"}\n" +
				"```")
				.urlClick(new OnUrlClickListener() {
					@Override
					public boolean urlClicked(String url) {
						if (url.startsWith("code://")) {
							Toast.makeText(HttpResponseCodeActivity.this, url.replaceFirst("code://",
									""), Toast
									.LENGTH_SHORT).show();
							return true;
						}
						return false;
					}
				})
				.into(richContent);
	}
}
