package yincheng.tinytank.tinyframe.lrucache;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.BaseObservable;

import java.io.InputStream;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.observable.ObservableCreate;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import yincheng.tinytank.R;

public class LruCacheViewModel extends BaseObservable {
	private static final String URL1 = "http://static.simpledesktops.com/uploads/desktops/2018/12/15/Watermelon.png.625x385_q100.png";
	private static final String URL2 = "https://i.pinimg.com/564x/c7/49/c4/c749c49b8ce2c6f16fbfd4c1b3a3de11.jpg";
	private static final String URL3 = "https://i.pinimg.com/564x/ad/36/11/ad361106c39b64ed84681036a7197701.jpg";
	private static final String URL4 = "https://i.pinimg.com/564x/61/60/ec/6160ec12ca6562ee5fc1401b39115644.jpg";
	private static final String URL5 = "https://i.pinimg.com/564x/8e/04/25/8e0425b381aa0e68a935214318efbd23.jpg";
	private static final String URL_LONG_IMG = "https://images.pexels.com/photos/459225/pexels-photo-459225.jpeg?cs=srgb&dl=daylight-environment-forest-459225.jpg&fm=jpg";

	private LruCacheActivity mLruCacheActivity;
	private CacheRepository mCacheRepository;

	LruCacheViewModel(LruCacheActivity LRUCacheActivity) {
		mLruCacheActivity = LRUCacheActivity;
		mCacheRepository = new CacheRepository(new DoubleLruCache(mLruCacheActivity));
	}

	protected void onActivityCreated() {

	}

	public void startWork() {
		Bitmap bitmap;
		if ((bitmap = mCacheRepository.get(URL5)) == null)
			getFromNetwork(URL5, new ValueCallback() {
				@Override
				public void onReceiveValue(Object value) {
					Log.i("cacheOperate", "data from network...");
					if (value instanceof Bitmap) {
						((AppCompatImageView) mLruCacheActivity.findViewById(R.id.iv_top)).setImageBitmap((Bitmap) value);
					}
				}
			});
		else {
			Log.i("cacheOperate", "data from rom...");
			((AppCompatImageView) mLruCacheActivity.findViewById(R.id.iv_top)).setImageBitmap(bitmap);
		}
	}

	private void getFromNetwork(String url, ValueCallback valueCallback) {
		OkHttpClient mOkHttpClient = new OkHttpClient();
		Request request1 = new Request
				.Builder()
				.url(url)
				.build();
		ObservableCreate
				.create(new ObservableOnSubscribe<Bitmap>() {
					@Override
					public void subscribe(ObservableEmitter<Bitmap> emitter) throws Exception {
						ResponseBody responseBody = mOkHttpClient.newCall(request1).execute().body();
						InputStream inputStream = responseBody.byteStream();
						emitter.onNext(BitmapFactory.decodeStream(inputStream));
					}
				})
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Observer<Bitmap>() {
					@Override
					public void onSubscribe(Disposable d) {
						Log.i("cacheOperate", "onSubscribe");
					}

					@Override
					public void onNext(Bitmap bitmap) {
						Log.i("cacheOperate", "onNext");
						mCacheRepository.put(url, bitmap);
						valueCallback.onReceiveValue(bitmap);
					}

					@Override
					public void onError(Throwable e) {
						Log.i("cacheOperate", "onError:" + e.getMessage());
					}

					@Override
					public void onComplete() {
						Log.i("cacheOperate", "onComplete");
					}
				});
	}
}
