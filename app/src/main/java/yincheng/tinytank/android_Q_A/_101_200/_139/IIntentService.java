package yincheng.tinytank.android_Q_A._101_200._139;

import android.content.Intent;
import android.os.Looper;

import androidx.annotation.Nullable;

import yincheng.tinytank.sourcecode.IntentService;

public class IIntentService extends IntentService {

	public IIntentService() {
		super("IIntentService");
	}

	@Override
	protected void onHandleIntent(@Nullable Intent intent) {
		if (intent == null) return;
		String url = intent.getStringExtra("url");
		if (Looper.myLooper() == Looper.getMainLooper()) {
			System.out.println("主线程:" + url);
		} else {
			try {
				Thread.sleep(1000);
				System.out.println("service线程:" + url);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
