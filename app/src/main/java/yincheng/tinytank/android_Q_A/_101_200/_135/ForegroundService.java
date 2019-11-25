package yincheng.tinytank.android_Q_A._101_200._135;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import yincheng.tinytank.R;
import yincheng.tinytank.ui.activity.MainActivity;

public class ForegroundService extends Service {
	public static final String CHANNEL_ID = "ForegroundServiceChannel";

	@RequiresApi(api = Build.VERSION_CODES.O)
	@Override
	public void onCreate() {
		super.onCreate();
	}

	@RequiresApi(api = Build.VERSION_CODES.O)
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		String input = intent.getStringExtra("inputExtra");
		createNotificationChannel();
		Intent notificationIntent = new Intent(this, MainActivity.class);
		PendingIntent pendingIntent = PendingIntent.getActivity(this,
				0, notificationIntent, 0);

		Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
				.setContentTitle("Foreground Service")
				.setContentText(input)
				.setSmallIcon(R.drawable.ic_dialpad_black_48dp)
				.setContentIntent(pendingIntent)
				.build();

		startForeground(1, notification);

		//do heavy work on a background thread

		//stopSelf();

		return START_NOT_STICKY;
	}

	private void createNotificationChannel() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
			NotificationChannel serviceChannel = new NotificationChannel(
					CHANNEL_ID,
					"Foreground Service Channel",
					NotificationManager.IMPORTANCE_DEFAULT
			);

			NotificationManager manager = getSystemService(NotificationManager.class);
			manager.createNotificationChannel(serviceChannel);
		}
	}

	@Nullable
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public boolean onUnbind(Intent intent) {
		return super.onUnbind(intent);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}
}
