package yincheng.tinytank.android_Q_A._1_100._40;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

import java.util.List;

public class StringDiffCallback extends DiffUtil.Callback {
	public static final String STRING_KEY = "STRING_KEY";
	private List<String> old_string, new_string;

	public StringDiffCallback(List old_string, List new_string) {
		this.old_string = old_string;
		this.new_string = new_string;
	}

	@Override
	public int getOldListSize() {
		return old_string.size();
	}

	@Override
	public int getNewListSize() {
		return new_string.size();
	}

	//判断item相同
	@Override
	public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
		return old_string.get(oldItemPosition) == new_string.get(newItemPosition);
	}

	//只有在areItemsTheSame()方法返回true时才会调用
	@Override
	public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
		return old_string.get(oldItemPosition).equals(new_string.get(newItemPosition));
	}

	//payload是一个用来描述item变化的对象，也就是item发生了哪些变化，这些变化封装成了一个payload，一般用Bundle来充当。
	//这个方法在areItemsTheSame()方法返回true而areContentsTheSame返回false时调用的。
	//在RecyclerView.Adapter中有两个onBindViewHolder方法，一个是我们必须要重写的，而另一个的第三个参数就是一个payload的列表。
	@Nullable
	@Override
	public Object getChangePayload(int oldItemPosition, int newItemPosition) {
		String s = new_string.get(newItemPosition);
		Bundle bundle = new Bundle();
		bundle.putString(STRING_KEY, s);
		return bundle;
	}
}
