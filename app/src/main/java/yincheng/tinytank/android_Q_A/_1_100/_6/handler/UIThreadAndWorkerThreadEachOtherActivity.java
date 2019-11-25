package yincheng.tinytank.android_Q_A._1_100._6.handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import yincheng.tinytank.R;

public class UIThreadAndWorkerThreadEachOtherActivity extends AppCompatActivity {
	private Handler uiHandler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_handler_communication);
		final WorkerThread workerThread = new WorkerThread();
		workerThread.start();
		uiHandler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				if (msg.what == 0x124) {
					((TextView) findViewById(R.id.tv_result)).setText(msg.getData().getString("result"));
				}
			}
		};
		findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Message msg = new Message();
				Bundle bundle = new Bundle();
				bundle.putString("sourceString", "this is the data from uiThread");
				((TextView) findViewById(R.id.tv_result)).setText("this is the data from uiThread");
				msg.setData(bundle);
				msg.what = 0x123;
				workerThread.workerHandler.sendMessage(msg);
			}
		});
	}

	class WorkerThread extends Thread {
		Handler workerHandler;

		@Override
		public void run() {
			Looper.prepare();
			workerHandler = new Handler() {
				@Override
				public void handleMessage(Message msg) {
					if (msg.what == 0x123) {
						try {
							Thread.sleep(1000);
							String sourceData = msg.getData().getString("sourceString");
							Message msg_send = new Message();
							msg_send.what = 0x124;
							Bundle bundle_send = new Bundle();
							bundle_send.putString("result", "workerThread have got the data from uiThread:" + sourceData);
							msg_send.setData(bundle_send);
							uiHandler.sendMessage(msg_send);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			};
			Looper.loop();
		}
	}
}
