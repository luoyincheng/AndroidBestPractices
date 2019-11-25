package yincheng.tinytank.tinyframe.lrucache;

import android.graphics.Bitmap;

public class CacheRepository implements CacheInterface {
	/**
	 * 引入接口，可以自由实现缓存方式
	 */
	private CacheInterface mCacheInterface;

	public CacheRepository(CacheInterface mCacheInterface) {
		this.mCacheInterface = mCacheInterface;
	}

	@Override
	public Bitmap get(String url) {
		return mCacheInterface.get(url);
	}

	@Override
	public void put(String url, Bitmap value) {
		mCacheInterface.put(url, value);
	}
}
