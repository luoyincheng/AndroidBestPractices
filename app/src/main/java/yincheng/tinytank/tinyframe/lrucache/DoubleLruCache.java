package yincheng.tinytank.tinyframe.lrucache;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;

public class DoubleLruCache implements CacheInterface {
	private CacheInterface mLruMemoryCache;
	private CacheInterface mLruDiskCache;

	DoubleLruCache(Context context) {
		mLruMemoryCache = new MemoryLruCacheImpl();
		mLruDiskCache = new DiskLruCacheImpl(context, "AndroidArchitecture", 100 * 1024 * 1024);
	}

	@Override
	public Bitmap get(String url) {
		Bitmap bitmap;
		if ((bitmap = mLruMemoryCache.get(url)) == null) {
			bitmap = mLruDiskCache.get(url);
			mLruMemoryCache.put(url, bitmap);
		} else
			Log.i("cacheOperate", "data from ram...");
		return bitmap;
	}

	@Override
	public void put(String url, Bitmap value) {
		mLruMemoryCache.put(url, value);
		mLruDiskCache.put(url, value);
	}
}
