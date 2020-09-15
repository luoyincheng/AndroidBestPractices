package yincheng.tinytank.ui.activity;


import android.widget.Toast;

import yincheng.tinytank.R;
import yincheng.tinytank.provider.helper.InputHelper;
import yincheng.tinytank.tinyframe.markdownview.MarkdownView;
import yincheng.tinytank.tinyframe.markdownview.css.InternalStyleSheet;
import yincheng.tinytank.tinyframe.markdownview.css.styles.Github;
import yincheng.tinytank.ui.activity.base.BaseActivity;

import static yincheng.tinytank.provider.helper.AssetsHelper.resolveAsset;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:05:18 7:36
 * Github : yincheng.luo
 */
public class MarkdownViewActivity extends BaseActivity {
	private MarkdownView mMarkdownView;
	private InternalStyleSheet mStyle = new Github();

	@Override
	protected int getLayoutId() {
		return R.layout.activity_markdownview;
	}

	@Override
	protected void initData() {
		MyBean myBean = new MyBean();
		myBean.setHello("Olá");
		myBean.setDiasDaSemana(MyBean.DiasDaSemana.DOMINGO);

		mMarkdownView = findViewById(R.id.mark_view);
		mMarkdownView.addStyleSheet(mStyle);
		//http://stackoverflow.com/questions/6370690/media-queries-how-to-target-desktop-tablet-and
		// -mobile
		mStyle.addMedia("screen and (min-width: 320px)");
		mStyle.addRule("h1", "color: green");
		mStyle.endMedia();
		mStyle.addMedia("screen and (min-width: 481px)");
		mStyle.addRule("h1", "color: red");
		mStyle.endMedia();
		mStyle.addMedia("screen and (min-width: 641px)");
		mStyle.addRule("h1", "color: blue");
		mStyle.endMedia();
		mStyle.addMedia("screen and (min-width: 961px)");
		mStyle.addRule("h1", "color: yellow");
		mStyle.endMedia();
		mStyle.addMedia("screen and (min-width: 1025px)");
		mStyle.addRule("h1", "color: gray");
		mStyle.endMedia();
		mStyle.addMedia("screen and (min-width: 1281px)");
		mStyle.addRule("h1", "color: orange");
		mStyle.endMedia();
		mMarkdownView.setBean(myBean);
	}

	@Override
	protected void initView() {
		String s = "md/" + getIntent().getStringExtra("mdName") + ".md";
		if (!InputHelper.isEmpty(s) && resolveAsset(s)) {
			Toast.makeText(this, s + " exists:", Toast.LENGTH_SHORT).show();
			mMarkdownView.loadMarkdownFromAsset(s);
		}
	}

	public static class MyBean {

		private String hello;
		private DiasDaSemana diasDaSemana;

		public String getHello() {
			return hello;
		}

		public void setHello(String hello) {
			this.hello = hello;
		}

		public DiasDaSemana getDiasDaSemana() {
			return diasDaSemana;
		}

		public void setDiasDaSemana(DiasDaSemana diasDaSemana) {
			this.diasDaSemana = diasDaSemana;
		}

		public enum DiasDaSemana {
			DOMINGO,
			SEGUNDA,
			TERCA,
			QUARTA,
			QUINTA,
			SEXTA,
			SABADO
		}
	}
}
