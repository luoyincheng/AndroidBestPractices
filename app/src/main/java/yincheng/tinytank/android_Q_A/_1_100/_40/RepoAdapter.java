package yincheng.tinytank.android_Q_A._1_100._40;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RepoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

	@NonNull
	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		return null;
	}

	@Override
	public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

	}

	@Override
	public int getItemCount() {
		return 0;
	}

	@Override
	public int getItemViewType(int position) {
		return super.getItemViewType(position);
	}

	public static class InnerViewHolder extends RecyclerView.ViewHolder {

		public InnerViewHolder(@NonNull View itemView) {
			super(itemView);
		}
	}
}
