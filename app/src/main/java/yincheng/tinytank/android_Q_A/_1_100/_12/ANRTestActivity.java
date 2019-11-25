package yincheng.tinytank.android_Q_A._1_100._12;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import yincheng.tinytank.R;

public class ANRTestActivity extends AppCompatActivity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_one_button);
	}

	@Override
	public void onAttachedToWindow() {
		super.onAttachedToWindow();
		/*
		 * 多按几次就会ANR
		 */
		findViewById(R.id.btnStart).setOnClickListener(view -> {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
	}
}
