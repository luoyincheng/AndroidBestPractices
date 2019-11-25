package yincheng.tinytank.provider.helper;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.annotation.NonNull;

import yincheng.tinytank.provider.BundleConstant;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:05:24 21:38
 * Github : yincheng.luo
 */
public class ActivityHelper {
	public static void startActivity(@NonNull Context context, @NonNull Intent intent) {
		if (context.getPackageManager().resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY)
				!= null)
			context.startActivity(intent);
	}

	public static Intent editBundle(@NonNull Intent intent, boolean isEnterprise) {
		Bundle bundle = intent.getExtras();
		if (bundle != null) {
			bundle.putBoolean(BundleConstant.IS_ENTERPRISE, isEnterprise);
			intent.putExtras(bundle);
		}
		return intent;
	}
}
