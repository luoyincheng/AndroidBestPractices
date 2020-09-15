package yincheng.tinytank.android_Q_A._1_100._40;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import yincheng.tinytank.R;
import yincheng.tinytank.view.FontTextView;

import static yincheng.tinytank.android_Q_A._1_100._40.StringDiffCallback.STRING_KEY;

public class IAdapter extends RecyclerView.Adapter<IAdapter.ViewHolder> {
	private Context mContext;
	private List<String> mData;

	public IAdapter(Context mContext, List<String> data) {
		this.mContext = mContext;
		//这里必须根据数据新建一个ArrayList,因为如果在这里直接保存引用，那么在外部通过Adapter.getData()方法获取到mData后修改就直接修改了mData中的数据了。
		this.mData = new ArrayList<>(data);
	}

	public List<String> getData() {
		return mData;
	}

	public void setData(List<String> mData) {
		this.mData = mData;
	}

	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		// java.lang.IllegalStateException: ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)
//		View view = LayoutInflater.from(mContext).inflate(R.layout.item_single_text, parent);
		View view = LayoutInflater.from(mContext).inflate(R.layout.item_single_text, parent, false);
		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
		View itemView = holder.itemView;
		((FontTextView) (itemView.findViewById(R.id.tv_desc))).setText(mData.get(position));
	}

	@Override
	public void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull List<Object> payloads) {
		if (payloads.isEmpty()) {
			onBindViewHolder(holder, position);
		} else {
			ViewHolder viewHolder = holder;
			Bundle bundle = (Bundle) payloads.get(position);
			if (bundle.getString(STRING_KEY) != null) {
				viewHolder.mFontTextView.setText(bundle.getString(STRING_KEY));
				viewHolder.mFontTextView.setTextColor(Color.RED);
			}
		}
	}

	@Override
	public int getItemCount() {
		return mData == null ? 0 : mData.size();
	}

	public static class ViewHolder extends RecyclerView.ViewHolder {
		private FontTextView mFontTextView;

		public ViewHolder(@NonNull View itemView) {
			super(itemView);
			mFontTextView = itemView.findViewById(R.id.tv_desc);
		}
	}
}
