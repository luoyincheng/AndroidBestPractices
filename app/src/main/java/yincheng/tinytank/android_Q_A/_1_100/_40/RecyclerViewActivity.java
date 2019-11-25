package yincheng.tinytank.android_Q_A._1_100._40;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import yincheng.tinytank.R;

public class RecyclerViewActivity extends AppCompatActivity {
	RecyclerView mRecyclerView;
	AppCompatButton mButton;
	boolean isChanged = false;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recyclerview_interview);
		mRecyclerView = findViewById(R.id.rv);

		ArrayList<String> data = new ArrayList<>();
		data.add("a");
		data.add("b");
		data.add("c");
		data.add("d");
		data.add("e");
		data.add("f");
		data.add("g");

		ArrayList<String> newData = new ArrayList<>();
		newData.add("b");
		newData.add("e");
		newData.add("a");
		newData.add("d");
		newData.add("c");
		newData.add("f");
		newData.add("g");

		IAdapter adapter = new IAdapter(this, data);
		mRecyclerView.setHasFixedSize(true);
		mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
		mRecyclerView.setAdapter(adapter);


		mButton = findViewById(R.id.btn);
		mButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				isChanged = !isChanged;
				List<String> old_Data = adapter.getData();
				DiffUtil.DiffResult result;
				if (isChanged) {
					result = DiffUtil.calculateDiff(new StringDiffCallback(old_Data, newData), true);
				} else {
					result = DiffUtil.calculateDiff(new StringDiffCallback(old_Data, data), true);
				}
				adapter.setData(data);
				result.dispatchUpdatesTo(adapter);
			}
		});
	}
}