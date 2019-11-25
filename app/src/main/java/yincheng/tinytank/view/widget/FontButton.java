package yincheng.tinytank.view.widget;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import yincheng.tinytank.provider.helper.TypefaceHelper;

/**
 * Created by yincheng on 2018/5/31/15:27.
 * github:luoyincheng
 */
public class FontButton extends AppCompatButton {

	public FontButton(@NonNull Context context) {
		super(context);
		init();
	}

	public FontButton(@NonNull Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public FontButton(@NonNull Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
	}

	private void init() {
		if (isInEditMode()) return;
		TypefaceHelper.applyTypeface(this);
	}
}