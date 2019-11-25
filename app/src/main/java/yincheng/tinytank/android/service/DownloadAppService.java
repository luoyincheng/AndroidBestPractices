package yincheng.tinytank.android.service;

import android.app.DownloadManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.IBinder;
import android.text.TextUtils;

import androidx.core.content.FileProvider;

import java.io.File;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:04:09 21:38
 * Github : yincheng.luo
 */

public class DownloadAppService extends Service {
	private static DownloadManager downloadManager;
	private static long downloadTaskId;

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// 注册广播, 设置只接受下载完成的广播
		registerReceiver(receiver, new IntentFilter(
				DownloadManager.ACTION_DOWNLOAD_COMPLETE));
		String upgradeurl = intent.getStringExtra("url");
		if (TextUtils.isEmpty(upgradeurl))
			return super.onStartCommand(intent, flags, startId);
		downloadBelowNought(this, upgradeurl);
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		unregisterReceiver(receiver);
	}

	public static void downloadBelowNought(final Context context, final String apkDownloadUrl) {
		downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
		DownloadManager.Request request = new DownloadManager.Request(Uri.parse(apkDownloadUrl));
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
			request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "AndroidInterviewPoint");
		downloadTaskId = downloadManager.enqueue(request);
	}

	BroadcastReceiver receiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			long downloadCompletedId = intent.getLongExtra(
					DownloadManager.EXTRA_DOWNLOAD_ID, 0);
			// 检查是否是本app的下载id
			if (downloadTaskId != downloadCompletedId) {
				return;
			}
			DownloadManager.Query query = new DownloadManager.Query();
			query.setFilterById(downloadTaskId);
			Cursor c = downloadManager.query(query);
			if (c.moveToFirst()) {
				int columnIndex = c.getColumnIndex(DownloadManager.COLUMN_STATUS);
				if (DownloadManager.STATUS_SUCCESSFUL == c.getInt(columnIndex)) {
					if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
						int fileUriIdx = c.getColumnIndex(DownloadManager.COLUMN_LOCAL_URI);
						String fileUri = c.getString(fileUriIdx);
						String fileName = null;
						if (fileUri != null) {
							fileName = Uri.parse(fileUri).getPath();
						}
						noughtAboveInstall(context, new File(fileName));
					} else {
						String uriString = c.getString(c.getColumnIndex(DownloadManager.COLUMN_LOCAL_FILENAME));
						noughtBelowInstall(Uri.parse("file://" + uriString));
					}
				}
			}
		}
	};

	private void noughtBelowInstall(Uri data) {
		Intent intent = new Intent(Intent.ACTION_VIEW)
				.setDataAndType(data, "application/vnd.android.package-archive");
		// FLAG_ACTIVITY_NEW_TASK 可以保证安装成功时可以正常打开 app
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(intent);
	}

	private void noughtAboveInstall(Context context, File file) {
		if (file == null || !file.exists() || !file.isFile()) {
			return;
		}
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		Uri apkUri; // Android 7.0 以上不支持 file://协议 需要通过 FileProvider 访问 sd卡 下面的文件，所以 Uri 需要通过 FileProvider 构造，协议为 content://
		// content:// 协议
		apkUri = FileProvider.getUriForFile(context, "yincheng.tinytank.provider", file);
		//Granting Temporary Permissions to a URI
		intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
		intent.setDataAndType(apkUri, "application/vnd.android.package-archive");
		context.startActivity(intent);
	}
}
