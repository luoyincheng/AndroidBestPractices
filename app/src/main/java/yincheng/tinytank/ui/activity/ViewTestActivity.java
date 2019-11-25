package yincheng.tinytank.ui.activity;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import yincheng.tinytank.R;

public class ViewTestActivity extends AppCompatActivity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_viewtest);
		View view = new View(this);
		view.invalidate();
		view.requestLayout();
	}
}
