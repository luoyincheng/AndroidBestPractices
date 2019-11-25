package yincheng.tinytank.ui.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import yincheng.tinytank.R;
import yincheng.tinytank.sourcecode.observer.IObservable;
import yincheng.tinytank.sourcecode.observer.Observable;
import yincheng.tinytank.sourcecode.observer.Observer;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:04:04 7:48
 * Github : yincheng.luo
 */

public class Observer1Fragment extends Fragment implements Observer {//观察者收到通知以后来做具体的事情，所以fragment实现了Observer接口
	TextView tv;
	Handler handler;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_observer, null);
		tv = (TextView) v.findViewById(R.id.text_showresult);
		IObservable.getObservable().addObserver(this);//
		return v;
	}

//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        handler = new HandlerTestActivity() {
//            @Override
//            public void handleMessage(Message msg) {
//                switch (msg.what) {
//                    case 0:
//                        tv.setText(msg.obj.toString());
//                        break;
//                }
//            }
//        };
//    }

	@Override
	public void update(Observable observable, final Object data) {//观察者收到通知以后来做具体的事情，所以fragment实现了Observer接口
		tv.setText(data.toString());//执行具体的方法

	}

//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        rx.Observable.create(new rx.Observable.OnSubscribe<String>() {
//            @Override
//            public void transform(final Subscriber<? super String> subscriber) {
//                tv.addTextChangedListener(new TextWatcher() {
//                    @Override
//                    public void beforeTextChanged(CharSequence s, int create, int count, int after) {
//
//                    }
//
//                    @Override
//                    public void onTextChanged(CharSequence s, int create, int before, int count) {
//                        subscriber.onNext(s.toString());
//                    }
//
//                    @Override
//                    public void afterTextChanged(Editable s) {
//
//                    }
//                });
//            }
//        })
//                .debounce(1000, TimeUnit.MICROSECONDS)
//                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<String>() {
//            @Override
//            public void transform(String s) {
//                tv1.setText(s);
//            }
//        });
//    }
}