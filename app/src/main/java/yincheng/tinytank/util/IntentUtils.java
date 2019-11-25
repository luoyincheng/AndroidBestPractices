package yincheng.tinytank.util;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.provider.MediaStore;

import androidx.annotation.NonNull;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class IntentUtils {

	public static Intent getPickImageChooserIntent(
			@NonNull Context context,
			CharSequence title,
			boolean includeDocuments,
			boolean includeCamera) {

		List<Intent> allIntents = new ArrayList<>();
		PackageManager packageManager = context.getPackageManager();

		// collect all camera intents if Camera permission is available
		if (!isExplicitCameraPermissionRequired(context) && includeCamera) {
			allIntents.addAll(getCameraIntents(context, packageManager));
		}

		List<Intent> galleryIntents =
				getGalleryIntents(packageManager, Intent.ACTION_GET_CONTENT, includeDocuments);
		if (galleryIntents.size() == 0) {
			// if no intents found for get-content try pick intent action (Huawei P9).
			galleryIntents = getGalleryIntents(packageManager, Intent.ACTION_PICK, includeDocuments);
		}
		allIntents.addAll(galleryIntents);

		Intent target;
		if (allIntents.isEmpty()) {
			target = new Intent();
		} else {
			target = allIntents.get(allIntents.size() - 1);
			allIntents.remove(allIntents.size() - 1);
		}

		// Create a chooser from the main intent
		Intent chooserIntent = Intent.createChooser(target, title);

		// Add all other intents
		chooserIntent.putExtra(
				Intent.EXTRA_INITIAL_INTENTS, allIntents.toArray(new Parcelable[allIntents.size()]));
		return chooserIntent;
	}

	// region private method start
	private static boolean isExplicitCameraPermissionRequired(@NonNull Context context) {
		return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
				&& hasPermissionInManifest(context, "android.permission.CAMERA")
				&& context.checkSelfPermission(Manifest.permission.CAMERA)
				!= PackageManager.PERMISSION_GRANTED;
	}

	private static boolean hasPermissionInManifest(
			@NonNull Context context, @NonNull String permissionName) {
		String packageName = context.getPackageName();
		try {
			PackageInfo packageInfo =
					context.getPackageManager().getPackageInfo(packageName, PackageManager.GET_PERMISSIONS);
			final String[] declaredPermissions = packageInfo.requestedPermissions;
			if (declaredPermissions != null && declaredPermissions.length > 0) {
				for (String p : declaredPermissions) {
					if (p.equalsIgnoreCase(permissionName)) {
						return true;
					}
				}
			}
		} catch (PackageManager.NameNotFoundException ignored) {
		}
		return false;
	}

	private static List<Intent> getCameraIntents(
			@NonNull Context context, @NonNull PackageManager packageManager) {

		List<Intent> allIntents = new ArrayList<>();

		// Determine Uri of camera image to  save.
		Uri outputFileUri = getCaptureImageOutputUri(context);

		Intent captureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		List<ResolveInfo> listCam = packageManager.queryIntentActivities(captureIntent, 0);
		for (ResolveInfo res : listCam) {
			Intent intent = new Intent(captureIntent);
			intent.setComponent(new ComponentName(res.activityInfo.packageName, res.activityInfo.name));
			intent.setPackage(res.activityInfo.packageName);
			if (outputFileUri != null) {
				intent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);
			}
			allIntents.add(intent);
		}

		return allIntents;
	}

	private static Uri getCaptureImageOutputUri(@NonNull Context context) {
		Uri outputFileUri = null;
		File getImage = context.getExternalCacheDir();
		if (getImage != null) {
			outputFileUri = Uri.fromFile(new File(getImage.getPath(), "pickImageResult.jpeg"));
		}
		return outputFileUri;
	}

	@SuppressLint("IntentReset")
	private static List<Intent> getGalleryIntents(
			@NonNull PackageManager packageManager, String action, boolean includeDocuments) {
		List<Intent> intents = new ArrayList<>();
		Intent galleryIntent =
				action == Intent.ACTION_GET_CONTENT
						? new Intent(action)
						: new Intent(action, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
		galleryIntent.setType("image/*");
		List<ResolveInfo> listGallery = packageManager.queryIntentActivities(galleryIntent, 0);
		for (ResolveInfo res : listGallery) {
			Intent intent = new Intent(galleryIntent);
			intent.setComponent(new ComponentName(res.activityInfo.packageName, res.activityInfo.name));
			intent.setPackage(res.activityInfo.packageName);
			intents.add(intent);
		}
		if (!includeDocuments) {
			for (Intent intent : intents) {
				if (Objects.requireNonNull(intent
						.getComponent())
						.getClassName()
						.equals("com.android.documentsui.DocumentsActivity")) {
					intents.remove(intent);
					break;
				}
			}
		}
		return intents;
	}
	// endregion
}
