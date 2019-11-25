package yincheng.tinytank.provider.adapter;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import yincheng.tinytank.R;
import yincheng.tinytank.provider.utils.ToastUtils;

/**
 * github : yincheng.luo
 * Date   : 2018:04:01 12:21
 * Author : luoyincheng@gmail.com
 */

public class GenericTextAdapter extends BaseQuickAdapter<Status, BaseViewHolder> {

	public GenericTextAdapter(List<Status> data) {
		super(R.layout.layout_animation, data);
	}

	@Override
	protected void convert(BaseViewHolder helper, Status item) {
		helper.addOnClickListener(R.id.img).addOnClickListener(R.id.tweetName);
		switch (helper.getLayoutPosition() %
				3) {
			case 0:
				helper.setImageResource(R.id.img, R.color.cardview_dark_background);
				break;
			case 1:
				helper.setImageResource(R.id.img, R.color.cardview_light_background);
				break;
			case 2:
				helper.setImageResource(R.id.img, R.color.cardview_shadow_start_color);
				break;
		}
		helper.setText(R.id.tweetName, "Hoteis in Rio de Janeiro");
		String msg = "\"He was one of Australia's most of distinguished artistes, renowned for his portraits\"";
		((TextView) helper.getView(R.id.tweetText)).setText(SpannableStringUtils.getBuilder(msg).append("landscapes and nedes").setClickSpan(clickableSpan).create());
		((TextView) helper.getView(R.id.tweetText)).setMovementMethod(ClickableMovementMethod.getInstance());
		((TextView) helper.getView(R.id.tweetText)).setFocusable(false);
		((TextView) helper.getView(R.id.tweetText)).setClickable(false);
		((TextView) helper.getView(R.id.tweetText)).setLongClickable(false);
	}

	ClickableSpan clickableSpan = new ClickableSpan() {
		@Override
		public void onClick(View widget) {
			ToastUtils.showShortToast("事件触发了 landscapes and nedes");
		}

		@Override
		public void updateDrawState(TextPaint ds) {
			ds.setColor(Utils.getContext().getResources().getColor(R.color.cardview_dark_background));
			ds.setUnderlineText(true);
		}
	};
}
