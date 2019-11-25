package yincheng.tinytank.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import yincheng.tinytank.R;
import yincheng.tinytank.sourcecode.observer.IObservable;
import yincheng.tinytank.ui.fragment.Observer1Fragment;
import yincheng.tinytank.ui.fragment.Observer2Fragment;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:04:04 7:27
 * Github : yincheng.luo
 */

public class ObserverActivity extends AppCompatActivity {
	@BindView(R.id.click)
	Button click;
	private static WeakHandler weakHandler;
	public static String editext_information;
	public static DrawerLayout drawerLayout;
	public SearchView searchview_main;
	private static EditText edit_query;
	private static int getMessageCount;
	private LinearLayout search_bar;
	private Timer timer;
	private TimerTask timerTask;
	private Runnable runnable;
	Observer1Fragment fragmentMain1;
	Observer2Fragment fragmentMain2;


	private static class WeakHandler extends Handler {
		private final WeakReference<ObserverActivity> activityObserverPatternWeakReference;

		WeakHandler(ObserverActivity activity) {
			activityObserverPatternWeakReference = new WeakReference<ObserverActivity>(activity);
		}

		@Override
		public void handleMessage(Message msg) {
			ObserverActivity activity = activityObserverPatternWeakReference.get();
			if (activity != null) {
				switch (msg.what) {
					case 0:
						IObservable.getObservable().sendMessage(edit_query.getText().toString() + getMessageCount++);//用来发送通知(模拟耗时操作)
						break;
				}
			}
		}
	}

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_observer);
		ButterKnife.bind(this);
		weakHandler = new WeakHandler(this);

		fragmentMain1 = new Observer1Fragment();
		fragmentMain2 = new Observer2Fragment();

		FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
		transaction1.add(R.id.fragmentmain1container, fragmentMain1, null);
		transaction1.commit();
		FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
		transaction2.add(R.id.fragmentmain2container, fragmentMain2, "fragment2");
		transaction2.commit();
		edit_query = (EditText) findViewById(R.id.edit_query);
		editext_information = edit_query.getText().toString();
	}

	@OnClick(R.id.click)
	void click() {
		if (!TextUtils.isEmpty(edit_query.getText())) {
			runnable = new Runnable() {
				@Override
				public void run() {
					IObservable.getObservable().sendMessage("\"" + edit_query.getText().toString() + getMessageCount++ + "\"");//用来发送通知(模拟耗时操作)
					weakHandler.postDelayed(this, 1000);
//                    myHandler.removeCallbacks(runnable);// TODO: 2017/8/28 如果不添加这句，将会一直执行下去，就像用了timertask

				}
			};
			weakHandler.post(runnable);
		}
	}
}
