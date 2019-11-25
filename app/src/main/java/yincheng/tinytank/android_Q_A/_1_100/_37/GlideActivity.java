package yincheng.tinytank.android_Q_A._1_100._37;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import yincheng.tinytank.R;

public class GlideActivity extends AppCompatActivity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_glide);
		Glide.with(this).load("http://www.lishiditu.com/wmspic/151225/181126322v.jpg").into((ImageView) findViewById(R.id.iv_img));
		//http://www.wumashe.com/wmspic/160912/190930012j.jpg
		//http://www.lishiditu.com/wmspic/151225/181126316i.jpg
		//http://www.wumashe.com/wmspic/160912/190930004u.jpg
		//http://www.wumashe.com/wmspic/161005/191005002f.jpg
	}
}
