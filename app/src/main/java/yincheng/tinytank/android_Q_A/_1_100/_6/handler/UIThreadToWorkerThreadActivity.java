package yincheng.tinytank.android_Q_A._1_100._6.handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import yincheng.tinytank.R;

public class UIThreadToWorkerThreadActivity extends AppCompatActivity {

	public class mThread extends Thread {
		public Handler workerHandler;

		@Override
		public void run() {
			Looper.prepare();
			workerHandler = new Handler() {
				@Override
				public void handleMessage(Message msg) {
					super.handleMessage(msg);
					System.out.println("get a message from uiThread");
				}
			};
			Looper.loop();
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_handler_communication);
		final mThread mthread = new mThread();
		mthread.start();
		findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Message msg = new Message();
				mthread.workerHandler.sendMessage(msg);
			}
		});
	}
}