package yincheng.tinytank.android_Q_A._1_100._8;


import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import java.lang.ref.WeakReference;

public class WeakReferenceHandler extends Handler {
	private WeakReference<Callback> mWeakReference;

	public WeakReferenceHandler(Callback callback) {
		mWeakReference = new WeakReference<Handler.Callback>(callback);
	}

	public WeakReferenceHandler(Callback callback, Looper looper) {
		super(looper);
		mWeakReference = new WeakReference<Handler.Callback>(callback);
	}

	@Override
	public void handleMessage(Message msg) {
		if (mWeakReference != null && mWeakReference.get() != null) {
			Callback callback = mWeakReference.get();
			callback.handleMessage(msg);
		}
	}
}
