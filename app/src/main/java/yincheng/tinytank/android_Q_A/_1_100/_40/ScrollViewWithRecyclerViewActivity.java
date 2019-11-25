package yincheng.tinytank.android_Q_A._1_100._40;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;

import yincheng.tinytank.R;

public class ScrollViewWithRecyclerViewActivity extends AppCompatActivity {
	RecyclerView mRecyclerView;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recyclerview_scrollview_collision);
		mRecyclerView = findViewById(R.id.recycler_view);
		IAdapter adapter = new IAdapter(this, Arrays.asList("a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d", "a", "b"));
		mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
		mRecyclerView.setAdapter(adapter);
//		mRecyclerView.requestDisallowInterceptTouchEvent(true);
	}
}
