package yincheng.tinytank.android_Q_A._101_200._137;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import yincheng.tinytank.R;

public class HandlerThreadActivity extends AppCompatActivity {
	private HandlerThread mHandlerThread = new HandlerThread("workerThread");

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_handler_communication);
		mHandlerThread.start();

		Looper looper = mHandlerThread.getLooper();
		WorkerHandler workerHandler = new WorkerHandler(looper);

		findViewById(R.id.btn_start).setOnClickListener(view -> {
			Message message = Message.obtain();
			Bundle bundle = new Bundle();
			bundle.putString("data", "this is data from uiThread");
			message.setData(bundle);
			workerHandler.sendMessage(message);
		});
	}

	class WorkerHandler extends Handler {
		WorkerHandler(Looper looper) {
			super(looper);
		}

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			System.out.println(msg.getData().getString("data"));
		}
	}
}
