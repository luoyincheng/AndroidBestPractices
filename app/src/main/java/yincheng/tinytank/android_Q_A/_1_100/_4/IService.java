package yincheng.tinytank.android_Q_A._1_100._4;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class IService extends Service {
	private String data = "默认消息";
	private boolean serviceRunning = false;

	@Override
	public IBinder onBind(Intent intent) {
		System.out.println("onBind()");
		return new MyBinder();
	}

	public class MyBinder extends Binder {
		IService getService() {
			return IService.this;
		}

		public void setData(String data) {
			IService.this.data = data;
		}
	}

	@Override
	public void onCreate() {
		super.onCreate();
		System.out.println("onCreate()");
		serviceRunning = true;
		new Thread() {
			@Override
			public void run() {
				int n = 0;
				while (serviceRunning && n < 10) {
					n++;
					String str = n + data;
					System.out.println(str);
					if (dataChangedListener != null) {
						dataChangedListener.onDataChanged(str);
					}
					try {
						sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		System.out.println("onStartCommand()");
		data = intent.getStringExtra("data");
		return START_NOT_STICKY;
	}

	@Override
	public boolean onUnbind(Intent intent) {
		System.out.println("onUnbind()");
		return super.onUnbind(intent);
	}

	@Override
	public void onDestroy() {
		serviceRunning = false;
		System.out.println("onDestroy()");
		super.onDestroy();
	}

	DataChangedListener dataChangedListener = null;

	public void setDataChangedListener(DataChangedListener dataChangedListener) {
		this.dataChangedListener = dataChangedListener;
	}

	public interface DataChangedListener {
		void onDataChanged(String str);
	}
}