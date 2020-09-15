package yincheng.tinytank.android_Q_A._1_100._4;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import yincheng.tinytank.R;

public class ServiceCommunicationActivity extends Activity implements View.OnClickListener {

	IServiceConnection iServiceConnection;
	IService.MyBinder binder = null;
	private Intent intent = null;
	private Button btn_start_service;
	private Button btn_stop_service;
	private Button btn_bind_service;
	private Button btn_unbind_service;
	private Button btn_sync_data;
	private EditText et_data;
	private TextView tv_out;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_service_communication);
		intent = new Intent(this, IService.class);
		iServiceConnection = new IServiceConnection();
		setOnClick();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.btn_start_service:
				intent.putExtra("data", et_data.getText().toString());
				startService(intent);
				break;
			case R.id.btn_stop_service:
				stopService(intent);
				break;
			case R.id.btn_bind_service:
				bindService(intent, iServiceConnection, Context.BIND_AUTO_CREATE);
				break;
			case R.id.btn_unbind_service:
				if (binder != null) {
					unbindService(iServiceConnection);
				}
				break;
			case R.id.btn_sync_data:
				if (binder != null) {
					binder.setData(et_data.getText().toString());
				}
				break;
			default:
				break;
		}
	}

	private void loadUI() {
		btn_start_service = findViewById(R.id.btn_start_service);
		btn_stop_service = findViewById(R.id.btn_stop_service);
		btn_bind_service = findViewById(R.id.btn_bind_service);
		btn_unbind_service = findViewById(R.id.btn_unbind_service);
		btn_sync_data = findViewById(R.id.btn_sync_data);
		et_data = findViewById(R.id.et_data);
		tv_out = findViewById(R.id.tv_out);
	}

	private void setOnClick() {
		loadUI();
		btn_start_service.setOnClickListener(this);
		btn_stop_service.setOnClickListener(this);
		btn_bind_service.setOnClickListener(this);
		btn_unbind_service.setOnClickListener(this);
		btn_sync_data.setOnClickListener(this);
	}

	class IServiceConnection implements ServiceConnection {
		@SuppressLint("HandlerLeak")
		Handler handler = new Handler() {
			public void handleMessage(android.os.Message msg) {
				tv_out.setText(msg.getData().getString("str"));
			}
		};

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			binder = (IService.MyBinder) service;
			binder.getService().setDataChangedListener(string -> {
				Message msg = new Message();
				Bundle bundle = new Bundle();
				bundle.putString("str", string);
				msg.setData(bundle);
				handler.sendMessage(msg);
			});
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			binder = null;
		}
	}
}