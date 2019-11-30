package yincheng.tinytank.android_Q_A._1_100._32;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import yincheng.tinytank.R;
import yincheng.tinytank.android_Q_A._1_100._4.ServiceCommunicationActivity;

public class HandlerActivity extends AppCompatActivity {
	private TextView mTextView;
	private WorkerHandler mWorkerHandler;
	private MainThreadHandler mMainThreadHandler;
	private int counter = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_handler_test);
		init();
		findViewById(R.id.textView).setOnClickListener(view -> {
			startActivity(new Intent(this, ServiceCommunicationActivity.class));
		});
	}

	private void init() {
		mTextView = findViewById(R.id.textView);
		//1 子线程发送消息给本身
		new Thread() {
			public void run() {
				Looper.prepare();
				//Looper.myLooper()获取当前线程所关联的Looper
				mWorkerHandler = new WorkerHandler(Looper.myLooper());
				Message message = new Message();
				message.obj = "message from workerThread";
				mWorkerHandler.sendMessage(message);
				System.out.println("workerThread send message1");
				Looper.loop();
			}
		}.start();
	}

	private class WorkerHandler extends Handler {
		private WorkerHandler(Looper looper) {
			super(looper);
		}

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			System.out.println("workerThread handle message");
			//2  收到消息后可再发消息到主线程
			mMainThreadHandler = new MainThreadHandler(getMainLooper());
			Message message = new Message();
			message.obj = msg.getData();
			mMainThreadHandler.sendMessage(message);
		}
	}

	private class MainThreadHandler extends Handler {
		private MainThreadHandler(Looper looper) {
			super(looper);
		}

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			System.out.println("MainThreadHandler handle message");
			mTextView.setText(msg.obj.toString());
			//3  收到消息后再发消息到子线程
			if (counter == 0) {
				Message message = new Message();
				message.obj = "主线程发送的消息Xi~Xi";
				mWorkerHandler.sendMessage(message);
				System.out.println("workerThread send message 2");
				counter++;
			}
		}
	}
}

