package yincheng.tinytank.android.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import yincheng.tinytank.R;

/**
 * Created by commi on 2018/3/23.
 */

public class ActivityWithBinder1 extends AppCompatActivity {

	private Service2Activity1 service2Activity1;
	private int progress = 0;
	private ProgressBar mProgressBar;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_with_binder);

		mProgressBar = (ProgressBar) findViewById(R.id.pb);
		Button mButton = (Button) findViewById(R.id.btn_openservice);
		mButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				//开始下载
				service2Activity1.startDownLoad();
				//监听进度
				listenProgress();
			}
		});

		Intent intent = new Intent("com.yincheng.action.service.testbinder");
		intent.setPackage(getPackageName());
		bindService(intent, conn, Context.BIND_AUTO_CREATE);

	}

	public void listenProgress() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (progress < service2Activity1.MAX_PROGRESS) {
					progress = service2Activity1.getProgress();
					mProgressBar.setProgress(progress);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		}).start();
	}

	ServiceConnection conn = new ServiceConnection() {
		@Override
		public void onServiceDisconnected(ComponentName name) {

		}

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			service2Activity1 = ((Service2Activity1.MsgBinder) service).getService();

		}
	};

	@Override
	protected void onDestroy() {
		unbindService(conn);
		super.onDestroy();
	}
}
