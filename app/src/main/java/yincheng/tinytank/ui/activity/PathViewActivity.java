package yincheng.tinytank.ui.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import yincheng.tinytank.R;
import yincheng.tinytank.view.PathView;

public class PathViewActivity extends AppCompatActivity {
	private PathView pathView;
	private RecyclerView recyclerView;
	private float downY;
	private float nowY;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pathview);
		pathView = findViewById(R.id.path_view);
		recyclerView = findViewById(R.id.recycler_view);
		recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
		recyclerView.setAdapter(new DataAdapter());
		recyclerView.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				pathView.answerFinger(event);
				return true;
			}
		});
	}

	class DataAdapter extends RecyclerView.Adapter {

		@NonNull
		@Override
		public myHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
			return new myHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_test, parent, false));
		}

		@Override
		public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
			((myHolder) holder).text_desc.append(":" + position);
		}

		@Override
		public int getItemCount() {
			return 10;
		}

		class myHolder extends RecyclerView.ViewHolder {
			public AppCompatTextView text_desc;

			public myHolder(View itemView) {
				super(itemView);
				text_desc = itemView.findViewById(R.id.text_desc);
			}
		}
	}
}
