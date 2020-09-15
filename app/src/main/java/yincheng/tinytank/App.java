package yincheng.tinytank;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import yincheng.tinytank.provider.adapter.Utils;
import yincheng.tinytank.provider.helper.TypefaceHelper;

/**
 * Mail : luoyincheng@gmail.com
 * Date   : 2018:04:01 14:31
 * Github : yincheng.luo
 */

public class App extends Application {
	private static App instance;

	public static App getInstance() {
		return instance;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;
		Utils.init(this);
		TypefaceHelper.generateTypeface(this);
		Logger.addLogAdapter(new AndroidLogAdapter());
	}
}
