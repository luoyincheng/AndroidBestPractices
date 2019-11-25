package yincheng.tinytank.provider.helper;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

import androidx.annotation.NonNull;

/**
 * Mail : luoyincheng@gmail.com
 * Date   : 2018:04:01 16:20
 * Github : yincheng.luo
 */

public class TypefaceHelper {

	private static Typeface typeface;

	public static void generateTypeface(@NonNull Context context) {
		typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Arial_Rounded_MT_Bold.ttf");
	}

	public static void applyTypeface(TextView textView) {
		textView.setTypeface(typeface);
	}

	public static Typeface getTypeface() {
		return typeface;
	}
}
