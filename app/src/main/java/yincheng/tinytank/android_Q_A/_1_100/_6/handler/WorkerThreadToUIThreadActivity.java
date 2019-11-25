package yincheng.tinytank.android_Q_A._1_100._6.handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import yincheng.tinytank.R;

public class WorkerThreadToUIThreadActivity extends AppCompatActivity {
	public Handler uiHandler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_handler_communication);
		uiHandler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				((TextView)findViewById(R.id.tv_result)).setText("result");
			}
		};
		findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				new Thread() {
					@Override
					public void run() {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						Message msg = new Message();
						uiHandler.sendMessage(msg);
					}
				}.start();
			}
		});
	}
}