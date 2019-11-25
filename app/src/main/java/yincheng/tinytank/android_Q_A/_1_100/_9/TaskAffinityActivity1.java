package yincheng.tinytank.android_Q_A._1_100._9;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import yincheng.tinytank.R;

public class TaskAffinityActivity1 extends AppCompatActivity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_one_button);
		Log.i("taskAffinity","activity1:taskId:" + getTaskId());
		findViewById(R.id.btnStart).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(TaskAffinityActivity1.this, TaskAffinityActivity2.class));
			}
		});
	}
}
