package yincheng.tinytank.android_Q_A._1_100._1;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BLifeCycleActivity extends AppCompatActivity {
	private final String TAG = "LifeCycleActivity";

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(TAG, "(B):onCreate");
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.i(TAG, "(B):onStart");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.i(TAG, "(B):onResume");
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.i(TAG, "(B):onPause");
	}

	@Override
	protected void onSaveInstanceState(@NonNull Bundle outState) {
		super.onSaveInstanceState(outState);
		Log.i(TAG, "(B):onSaveInstanceState");
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		Log.i(TAG, "(B):onRestoreInstanceState");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.i(TAG, "(B):onStop");

	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.i(TAG, "(B):onDestroy");
	}
}
