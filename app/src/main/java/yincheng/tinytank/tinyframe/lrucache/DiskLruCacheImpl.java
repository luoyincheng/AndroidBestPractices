package yincheng.tinytank.tinyframe.lrucache;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;

import com.blankj.utilcode.util.EncryptUtils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import yincheng.tinytank.BuildConfig;

public class DiskLruCacheImpl implements CacheInterface {
	private DiskLruCache mDiskCache;
	private Bitmap.CompressFormat mCompressFormat = Bitmap.CompressFormat.JPEG;
	private int mCompressQuality = 70;
	private static final int APP_VERSION = 1;
	private static final int VALUE_COUNT = 1;
	private static final String TAG = "DiskLruCacheImpl";

	public DiskLruCacheImpl(Context context, String uniqueName, int diskCacheSize) {
		try {
			final File diskCacheDir = getDiskCacheDir(context, uniqueName);
			mDiskCache = DiskLruCache.open(diskCacheDir, APP_VERSION, VALUE_COUNT, diskCacheSize);
//            mCompressFormat = compressFormat;
//            mCompressQuality = quality;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private boolean writeObjectToFile(Bitmap bitmap, DiskLruCache.Editor editor) throws IOException, FileNotFoundException {
		OutputStream out = null;
		try {
			out = new BufferedOutputStream(editor.newOutputStream(0), Utils.IO_BUFFER_SIZE);
			return bitmap.compress(mCompressFormat, mCompressQuality, out);
		} finally {
			if (out != null) {
				out.close();
			}
		}
//
//        BufferedOutputStream bufferedOutputStream;
//        try {
//            bufferedOutputStream = new BufferedOutputStream(editor.newOutputStream(0), Utils.IO_BUFFER_SIZE);
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);
//            objectOutputStream.writeObject(object);
//            return true;
//        } catch (IOException e) {
//            e.printStackTrace();
//            return false;
//        }
	}

	private File getDiskCacheDir(Context context, String uniqueName) {

		// Check if media is mounted or storage is built-in, if so, try and use external cache dir
		// otherwise use internal cache dir
		final String cachePath =
				Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) ||
						!Utils.isExternalStorageRemovable() ?
						Utils.getExternalCacheDir(context).getPath() :
						context.getCacheDir().getPath();

		return new File(cachePath + File.separator + uniqueName);
	}

	@Override
	public Bitmap get(String url) {
		Bitmap bitmap = null;
		DiskLruCache.Snapshot snapshot = null;
		try {
			snapshot = mDiskCache.get(EncryptUtils.encryptMD5ToString(url).toLowerCase());
			if (snapshot == null) {
				return null;
			}
			final InputStream inputStream = snapshot.getInputStream(0);
			if (inputStream != null) {
				final BufferedInputStream buffIn =
						new BufferedInputStream(inputStream, Utils.IO_BUFFER_SIZE);
				bitmap = BitmapFactory.decodeStream(buffIn);
			}
//            if (inputStream != null) {
//                final ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
//                object = objectInputStream.readObject();
//            }
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (snapshot != null) {
				snapshot.close();
			}
		}
		if (BuildConfig.DEBUG) {
			Log.d("cache_test_DISK_", bitmap == null ? "" : "image read from disk " + url);
		}
		return bitmap;
	}

	@Override
	public void put(String url, Bitmap value) {
		DiskLruCache.Editor editor = null;
		try {
			editor = mDiskCache.edit(EncryptUtils.encryptMD5ToString(url).toLowerCase());
			if (editor == null) {
				return;
			}
			if (writeObjectToFile(value, editor)) {
				mDiskCache.flush();
				editor.commit();
				if (BuildConfig.DEBUG) {
					Log.d("cache_test_DISK_", "image put on disk cache " + url);
				}
			} else {
				editor.abort();
				if (BuildConfig.DEBUG) {
					Log.d("cache_test_DISK_", "ERROR on: image put on disk cache " + url);
				}
			}
		} catch (IOException e) {
			if (BuildConfig.DEBUG) {
				Log.d("cache_test_DISK_", "ERROR on: image put on disk cache " + url);
			}
			try {
				if (editor != null) {
					editor.abort();
				}
			} catch (IOException ignored) {
			}
		}
	}

	public boolean containsKey(String key) {
		boolean contained = false;
		DiskLruCache.Snapshot snapshot = null;
		try {
			snapshot = mDiskCache.get(EncryptUtils.encryptMD5ToString(key).toLowerCase());
			contained = snapshot != null;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (snapshot != null) {
				snapshot.close();
			}
		}
		return contained;
	}

	public void clearCache() {
		if (BuildConfig.DEBUG) {
			Log.d("cache_test_DISK_", "disk cache CLEARED");
		}
		try {
			mDiskCache.delete();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public File getCacheFolder() {
		return mDiskCache.getDirectory();
	}

}
