package yincheng.tinytank.tinyframe.draggablearea;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;

import androidx.annotation.NonNull;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

import java.security.MessageDigest;

import yincheng.tinytank.framework.BitmapTransformation;

public class RotateTransformation extends BitmapTransformation {

	@Override
	protected Bitmap transform(@NonNull Context context, @NonNull BitmapPool pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {
		Matrix matrix = new Matrix();
		//旋转
		matrix.postRotate(60f);
		//生成新的Bitmap
		return Bitmap.createBitmap(toTransform, 0, 0, toTransform.getWidth(), toTransform.getHeight(), matrix, true);
	}

	@Override
	public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {

	}

	@Override
	public boolean equals(Object o) {
		return false;
	}

	@Override
	public int hashCode() {
		return 0;
	}
}
