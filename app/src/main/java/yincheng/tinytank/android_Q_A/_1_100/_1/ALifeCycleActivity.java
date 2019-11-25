package yincheng.tinytank.android_Q_A._1_100._1;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import yincheng.tinytank.R;

import static yincheng.tinytank.android_Q_A.constants.LIFE_CYCLE;

public class ALifeCycleActivity extends AppCompatActivity {
	Button buttonStart;
	LifeCycleFragment lifeCycleFragment;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_life_cycle);
		buttonStart = findViewById(R.id.btnStart);
		initFragment();
		if (savedInstanceState != null) {
			Log.i(LIFE_CYCLE, "(A):savedInstanceState存在");
			if (buttonStart != null) {
				buttonStart.setText(savedInstanceState.getString("btnStart"));
			}
		} else Log.i(LIFE_CYCLE, "(A):savedInstanceState不存在");
		Log.i(LIFE_CYCLE, "(A):onCreate");

		buttonStart.setOnClickListener(v -> {
			buttonStart.setText("已经启动了");
			startActivity(new Intent(ALifeCycleActivity.this, BLifeCycleActivity.class));
		});
	}

	private void initFragment() {
		Log.i(LIFE_CYCLE, ">>>>>>>> initFragment");
		lifeCycleFragment = new LifeCycleFragment();
		FragmentManager fragmentManager = this.getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		fragmentTransaction.add(R.id.container, lifeCycleFragment);
		fragmentTransaction.commitNow();
	}

	@Override
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
		Log.i(LIFE_CYCLE, "(A):onNewIntent");
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.i(LIFE_CYCLE, "(A):onStart");
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Log.i(LIFE_CYCLE, "(A):onRestart");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.i(LIFE_CYCLE, "(A):onResume");
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.i(LIFE_CYCLE, "(A):onPause");
	}

	//	@Override
//	public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
//		super.onSaveInstanceState(outState, outPersistentState);
//		Log.i(LIFE_CYCLE, "(A):onSaveInstanceState");
//	}
//
	@Override
	protected void onSaveInstanceState(@NonNull Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putString("btnStart", "onSaveInstanceState()");
		Log.i(LIFE_CYCLE, "(A):onSaveInstanceState");
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
//		if (buttonStart != null && savedInstanceState != null) {
//			buttonStart.setText(savedInstanceState.getString("btnStart"));
//		}
		Log.i(LIFE_CYCLE, "(A):onRestoreInstanceState");
	}

	@Override
	public void onConfigurationChanged(@NonNull Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		Log.i(LIFE_CYCLE, "(A):onConfigurationChanged");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.i(LIFE_CYCLE, "(A):onStop");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.i(LIFE_CYCLE, "(A):onDestroy");
	}
}