package yincheng.tinytank.provider.helper;

import android.content.res.AssetManager;

import com.orhanobut.logger.Logger;

import java.io.IOException;

import yincheng.tinytank.App;

/**
 * Created by yincheng on 2018/6/4/11:14.
 * github:luoyincheng
 */
public class AssetsHelper {
	public static boolean resolveAsset(String path) {
		AssetManager assetManager = App.getInstance().getAssets();
		String[] resultFiles;
		try {
			resultFiles = assetManager.list(path.substring(0, path.lastIndexOf("/")));
		} catch (IOException e) {
			Logger.e("HelperLog", e.toString());// TODO: 2018/6/4 异常之后会不会继续往下走
			return false;
		}
		for (String resultFile : resultFiles) {
			if (resultFile.equals(path.substring(path.lastIndexOf("/") + 1)))
				return true;
		}
		return false;
	}
}
