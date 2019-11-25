package yincheng.tinytank.android_Q_A._101_200._135;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import yincheng.tinytank.R;

import static yincheng.tinytank.android_Q_A._101_200._135.ForegroundServiceNew.STARTFOREGROUND_ACTION;
import static yincheng.tinytank.android_Q_A._101_200._135.ForegroundServiceNew.STOPFOREGROUND_ACTION;

public class ForegroundServiceActivity extends AppCompatActivity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_foreground_service);
		findViewById(R.id.btn_foreground_service).setOnClickListener(view -> {
			Intent serviceIntent = new Intent(this, ForegroundService.class);
			serviceIntent.putExtra("inputExtra", "Foreground Service Example in Android");
			ContextCompat.startForegroundService(this, serviceIntent);
		});

		findViewById(R.id.btn_start_service).setOnClickListener(view -> {
			Intent startIntent = new Intent(ForegroundServiceActivity.this, ForegroundServiceNew.class);
			startIntent.setAction(STARTFOREGROUND_ACTION);
			startService(startIntent);
		});
		findViewById(R.id.btn_stop_service).setOnClickListener(view -> {
			Intent stopIntent = new Intent(ForegroundServiceActivity.this, ForegroundServiceNew.class);
			stopIntent.setAction(STOPFOREGROUND_ACTION);
			startService(stopIntent);
		});
	}
}
