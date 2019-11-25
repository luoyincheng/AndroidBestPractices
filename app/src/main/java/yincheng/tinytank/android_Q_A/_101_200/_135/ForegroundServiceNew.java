package yincheng.tinytank.android_Q_A._101_200._135;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import yincheng.tinytank.R;
import yincheng.tinytank.ui.activity.MainActivity;

public class ForegroundServiceNew extends Service {
	public static String MAIN_ACTION = "com.truiton.foregroundservice.action.main";
	public static String PREV_ACTION = "com.truiton.foregroundservice.action.prev";
	public static String PLAY_ACTION = "com.truiton.foregroundservice.action.play";
	public static String NEXT_ACTION = "com.truiton.foregroundservice.action.next";
	public static String STARTFOREGROUND_ACTION = "com.truiton.foregroundservice.action.startforeground";
	public static String STOPFOREGROUND_ACTION = "com.truiton.foregroundservice.action.stopforeground";
	private static final String LOG_TAG = "ForegroundService";

	@Override
	public void onCreate() {
		super.onCreate();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		if (intent.getAction().equals(STARTFOREGROUND_ACTION)) {
			Log.i(LOG_TAG, "Received Start Foreground Intent");
			Intent notificationIntent = new Intent(this, MainActivity.class);
			notificationIntent.setAction(MAIN_ACTION);
			notificationIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
					| Intent.FLAG_ACTIVITY_CLEAR_TASK);
			PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
					notificationIntent, 0);

			Intent previousIntent = new Intent(this, ForegroundService.class);
			previousIntent.setAction(PREV_ACTION);
			PendingIntent ppreviousIntent = PendingIntent.getService(this, 0,
					previousIntent, 0);

			Intent playIntent = new Intent(this, ForegroundService.class);
			playIntent.setAction(PLAY_ACTION);
			PendingIntent pplayIntent = PendingIntent.getService(this, 0,
					playIntent, 0);

			Intent nextIntent = new Intent(this, ForegroundService.class);
			nextIntent.setAction(NEXT_ACTION);
			PendingIntent pnextIntent = PendingIntent.getService(this, 0,
					nextIntent, 0);

			Notification notification = new NotificationCompat.Builder(this,"channelId")
					.setContentTitle("Truiton Music Player")
					.setTicker("Truiton Music Player")
					.setContentText("My Music")
					.setSmallIcon(R.drawable.ic_dialpad_black_48dp)
					.setContentIntent(pendingIntent)
					.setOngoing(true)
					.addAction(android.R.drawable.ic_media_previous,
							"Previous", ppreviousIntent)
					.addAction(android.R.drawable.ic_media_play, "Play",
							pplayIntent)
					.addAction(android.R.drawable.ic_media_next, "Next",
							pnextIntent).build();
			startForeground(101, notification);
		} else if (intent.getAction().equals(PREV_ACTION)) {
			Log.i(LOG_TAG, "Clicked Previous");
		} else if (intent.getAction().equals(PLAY_ACTION)) {
			Log.i(LOG_TAG, "Clicked Play");
		} else if (intent.getAction().equals(NEXT_ACTION)) {
			Log.i(LOG_TAG, "Clicked Next");
		} else if (intent.getAction().equals(
				STOPFOREGROUND_ACTION)) {
			Log.i(LOG_TAG, "Received Stop Foreground Intent");
			stopForeground(true);
			stopSelf();
		}
		return START_STICKY;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.i(LOG_TAG, "In onDestroy");
	}

	@Override
	public IBinder onBind(Intent intent) {
		// Used only in case of bound services.
		return null;
	}
}
