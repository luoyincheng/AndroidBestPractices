package yincheng.tinytank.android_Q_A._101_200._145;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import yincheng.tinytank.R;
import yincheng.tinytank.android_Q_A._101_200._145.demochannel.ChannelActivity;
import yincheng.tinytank.android_Q_A._101_200._145.demodrag.DragActivity;

public class RecyclerViewDragActivity extends AppCompatActivity implements View.OnClickListener {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button mBtnDrag = (Button) findViewById(R.id.btn_drag);
		Button mBtnChannel = (Button) findViewById(R.id.btn_channl);
		mBtnDrag.setOnClickListener(this);
		mBtnChannel.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.btn_drag:
				startActivity(new Intent(RecyclerViewDragActivity.this, DragActivity.class));
				break;
			case R.id.btn_channl:
				startActivity(new Intent(RecyclerViewDragActivity.this, ChannelActivity.class));
				break;
		}
	}
}
