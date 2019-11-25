package yincheng.tinytank.provider.utils;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Arrays;
import java.util.List;

import yincheng.tinytank.BuildConfig;

/**
 * Created by yincheng on 2018/5/31/15:34.
 * github:luoyincheng
 */
public class Logger {

	private final static String TAG = Logger.class.getSimpleName();

	private static final boolean DEBUG = BuildConfig.DEBUG;

	private static void e(@NonNull String tag, @Nullable Object text) {
		if (!DEBUG) return;
		Log.e(tag, text != null ? text.toString() : "LOGGER IS NONE");//avoid null
	}

	private static void d(@NonNull String tag, @Nullable Object text) {
		if (!DEBUG) return;
		Log.d(tag, text != null ? text.toString() : "LOGGER IS NONE");//avoid null
	}

	private static void i(@NonNull String tag, @Nullable Object text) {
		if (!DEBUG) return;
		Log.i(tag, text != null ? text.toString() : "LOGGER IS NONE");//avoid null
	}

	public static void d(@Nullable Object text) {
		d(getCurrentClassName() + " || " + getCurrentMethodName(), text);//avoid null
	}

	public static void i(@Nullable Object text) {
		i(getCurrentClassName() + " || " + getCurrentMethodName(), text);//avoid null
	}

	public static void e(Object... objects) {
		if (objects != null && objects.length > 0) {
			e(getCurrentClassName() + " || " + getCurrentMethodName(), Arrays.toString(objects));
		} else {
			e(getCurrentClassName() + " || " + getCurrentMethodName(), getCurrentMethodName());
		}
	}

	public static void e(List<Object> objects) {
		if (objects != null) {
			e(getCurrentClassName() + " || " + getCurrentMethodName(), Arrays.toString(objects
					.toArray()));
		} else {
			e(TAG, null);
		}
	}

	private static String getCurrentMethodName() {
		try {
			return Thread.currentThread().getStackTrace()[4].getMethodName() + "()";
		} catch (Exception ignored) {
		}
		return TAG;
	}

	private static String getCurrentClassName() {
		try {
			String className = Thread.currentThread().getStackTrace()[4].getClassName();
			String[] temp = className.split("[.]");
			className = temp[temp.length - 1];
			return className;
		} catch (Exception ignored) {
		}
		return TAG;
	}
}