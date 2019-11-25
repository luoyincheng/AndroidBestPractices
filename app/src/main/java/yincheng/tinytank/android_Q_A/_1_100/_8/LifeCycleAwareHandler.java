package yincheng.tinytank.android_Q_A._1_100._8;

import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

import java.util.Objects;

public class LifeCycleAwareHandler extends Handler implements LifecycleObserver {

	private LifecycleOwner lifecycleOwner;

	public LifeCycleAwareHandler(final LifecycleOwner lifecycleOwner) {
		this.lifecycleOwner = lifecycleOwner;
		addObserver();
	}

	public LifeCycleAwareHandler(final Callback callback, final LifecycleOwner lifecycleOwner) {
		super(callback);
		this.lifecycleOwner = lifecycleOwner;
		addObserver();
	}

	public LifeCycleAwareHandler(final Looper looper, final LifecycleOwner lifecycleOwner) {
		super(looper);
		this.lifecycleOwner = lifecycleOwner;
		addObserver();
	}

	public LifeCycleAwareHandler(final Looper looper, final Callback callback, final LifecycleOwner lifecycleOwner) {
		super(looper, callback);
		this.lifecycleOwner = lifecycleOwner;
		addObserver();
	}

	private void addObserver() {
		Objects.requireNonNull(lifecycleOwner);
		lifecycleOwner.getLifecycle().addObserver(this);
	}

	@OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
	private void onDestroy() {
		removeCallbacksAndMessages(null);
		lifecycleOwner.getLifecycle().removeObserver(this);
	}
}
