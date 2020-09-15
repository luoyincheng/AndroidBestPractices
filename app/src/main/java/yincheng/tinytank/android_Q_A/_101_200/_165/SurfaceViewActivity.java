package yincheng.tinytank.android_Q_A._101_200._165;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SurfaceViewActivity extends AppCompatActivity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		SparkView sparkView = new SparkView(this);
		setContentView(sparkView);
	}
}
