package yincheng.tinytank.tinyframe.lrucache;

import android.graphics.Bitmap;

import com.blankj.utilcode.util.EncryptUtils;

public class MemoryLruCacheImpl implements CacheInterface {
	MemoryLruCache<String, Bitmap> mMemoryLruCache;

	public MemoryLruCacheImpl() {
		final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
		final int cacheSize = maxMemory / 4;

		mMemoryLruCache = new MemoryLruCache<String, Bitmap>(cacheSize) {
			@Override
			protected int sizeOf(String key, Bitmap value) {
				return value.getByteCount() / 1024;
			}
		};
	}

	@Override
	public Bitmap get(String url) {
		return mMemoryLruCache.get(EncryptUtils.encryptMD5ToString(url).toLowerCase());
	}

	@Override
	public void put(String url, Bitmap value) {
		if (get(url) == null) {
			mMemoryLruCache.put(EncryptUtils.encryptMD5ToString(url).toLowerCase(), value);
		}
	}
}
