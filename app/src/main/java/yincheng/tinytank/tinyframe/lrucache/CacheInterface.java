package yincheng.tinytank.tinyframe.lrucache;

import android.graphics.Bitmap;

public interface CacheInterface {

	Bitmap get(String url);

	void put(String url, Bitmap value);

}
