package yincheng.tinytank.android_Q_A._101_200._139;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import yincheng.tinytank.R;

public class IntentServiceActivity extends AppCompatActivity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intentservice);
		findViewById(R.id.btn_startWork).setOnClickListener(view -> {
			Intent intent = new Intent(this, IIntentService.class);
			intent.putExtra("url", "https://www.google.com");
			startService(intent);
		});
	}
}
