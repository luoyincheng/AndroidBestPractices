package yincheng.tinytank.android_Q_A._101_200._145.demodrag;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import yincheng.tinytank.R;
import yincheng.tinytank.android_Q_A._101_200._145.helper.OnDragVHListener;
import yincheng.tinytank.android_Q_A._101_200._145.helper.OnItemMoveListener;

public class DragAdapter extends RecyclerView.Adapter<DragAdapter.DragViewHolder> implements OnItemMoveListener {
	private List<String> mItems;
	private LayoutInflater mInflater;

	public DragAdapter(Context context, List<String> items) {
		mInflater = LayoutInflater.from(context);
		this.mItems = items;
	}

	@Override
	public DragViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		return new DragViewHolder(mInflater.inflate(R.layout.item_drag, parent, false));
	}

	@Override
	public void onBindViewHolder(DragViewHolder holder, int position) {
		holder.tv.setText(mItems.get(position));
	}

	@Override
	public int getItemCount() {
		return mItems.size();
	}

	@Override
	public void onItemMove(int fromPosition, int toPosition) {
		String item = mItems.get(fromPosition);
		mItems.remove(fromPosition);
		mItems.add(toPosition, item);
		notifyItemMoved(fromPosition, toPosition);
	}

	class DragViewHolder extends RecyclerView.ViewHolder implements OnDragVHListener {
		TextView tv;

		public DragViewHolder(View itemView) {
			super(itemView);
			tv = (TextView) itemView.findViewById(R.id.tv);
		}

		@Override
		public void onItemSelected() {
			itemView.setBackgroundColor(Color.LTGRAY);
		}

		@Override
		public void onItemFinish() {
			itemView.setBackgroundColor(0);
		}
	}
}
