package yincheng.tinytank.ui.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import yincheng.tinytank.R;
import yincheng.tinytank.sourcecode.observer.IObservable;
import yincheng.tinytank.sourcecode.observer.Observable;
import yincheng.tinytank.sourcecode.observer.Observer;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:04:04 7:50
 * Github : yincheng.luo
 */

public class Observer2Fragment extends Fragment implements Observer {
	static TextView tv1;
	public Handler handler;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_observer, null);
		tv1 = (TextView) v.findViewById(R.id.text_showresult);
		IObservable.getObservable().addObserver(this);//
		return v;
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				switch (msg.what) {
					case 0:
						tv1.setText(msg.obj.toString());
						break;
				}
			}
		};
	}

	@Override
	public void update(Observable observable, final Object data) {//观察者收到通知以后来做具体的事情，所以fragment实现了Observer接口
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				Message msg = new Message();
				msg.what = 0;
				msg.obj = data;
				handler.sendMessage(msg);
			}
		}, 1000);
	}
}
