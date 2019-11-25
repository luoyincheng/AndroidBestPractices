package yincheng.tinytank.provider.adapter;

import android.content.Context;
import android.view.View;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;
import java.util.Random;

import yincheng.tinytank.R;
import yincheng.tinytank.common.GenericItemHolder;

/**
 * Mail : luoyincheng@gmail.com
 * Date   : 2018:04:01 15:31
 * Github : yincheng.luo
 */

public class GenericAdapter extends BaseQuickAdapter<GenericItemHolder, BaseViewHolder> implements BaseQuickAdapter.OnItemChildClickListener {
	private Context mContext;
	private Random random = new Random();
	private int[] drawables = new int[]{
			R.drawable.ic_more_vert_black_48dp,
			R.drawable.ic_near_me_black_48dp,
			R.drawable.ic_fiber_pin_black_48dp,
			R.drawable.ic_local_offer_black_48dp,
			R.drawable.ic_dialpad_black_48dp
	};

	public GenericAdapter(Context context, @Nullable List<GenericItemHolder> data) {
		super(R.layout.item_single_text, data);
		this.mContext = context;
	}

	@Override
	protected void convert(BaseViewHolder helper, GenericItemHolder item) {
		helper.setText(R.id.tv_desc, item.getTitle());
		if (item.isHasDoc()) {
			helper.setVisible(R.id.iv_doc, true);
			helper.setImageDrawable(R.id.iv_doc, mContext.getResources().getDrawable(drawables[random.nextInt(5)]));
			helper.addOnClickListener(R.id.iv_doc);

//         helper.setVisible(R.id.color_tv_desc, true);
//         helper.addOnClickListener(R.id.color_tv_desc);
		}
	}

	@Override
	public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
// TODO: 2018/5/24 这里设置不起作用
	}
}
