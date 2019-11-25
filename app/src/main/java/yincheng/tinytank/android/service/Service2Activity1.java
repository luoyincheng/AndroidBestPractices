package yincheng.tinytank.android.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

/**
 * Created by yincheng on 2018/3/23.
 */

public class Service2Activity1 extends Service {

	public static final int MAX_PROGRESS = 100;

	private int progress = 0;

	public int getProgress() {
		return progress;
	}

	public void startDownLoad() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (progress < MAX_PROGRESS) {
					progress += 1;
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	@Override
	public IBinder onBind(Intent intent) {
		return new MsgBinder();
	}

	public class MsgBinder extends Binder {

		public Service2Activity1 getService() {
			return Service2Activity1.this;
		}
	}
}

