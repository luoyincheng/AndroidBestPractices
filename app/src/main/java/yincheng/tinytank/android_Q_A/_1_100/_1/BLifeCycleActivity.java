package yincheng.tinytank.android_Q_A._1_100._1;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static yincheng.tinytank.android_Q_A.constants.LIFE_CYCLE;

public class BLifeCycleActivity extends AppCompatActivity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(LIFE_CYCLE, "(B):onCreate");
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.i(LIFE_CYCLE, "(B):onStart");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.i(LIFE_CYCLE, "(B):onResume");
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.i(LIFE_CYCLE, "(B):onPause");
	}

	@Override
	protected void onSaveInstanceState(@NonNull Bundle outState) {
		super.onSaveInstanceState(outState);
		Log.i(LIFE_CYCLE, "(B):onSaveInstanceState");
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		Log.i(LIFE_CYCLE, "(B):onRestoreInstanceState");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.i(LIFE_CYCLE, "(B):onStop");

	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.i(LIFE_CYCLE, "(B):onDestroy");
	}
}
