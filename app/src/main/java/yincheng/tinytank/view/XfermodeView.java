package yincheng.tinytank.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class XfermodeView extends View {

	//PorterDuff模式常量 可以在此更改不同的模式测试
	private static final PorterDuff.Mode MODE = PorterDuff.Mode.DST_OUT;
	private PorterDuffXfermode porterDuffXfermode;
	private int screenW, screenH; //屏幕宽高
	private Bitmap greenBitmap;
	//源图和目标图宽高
	private int hollowWidth = 400;

	public XfermodeView(Context context) {
		this(context, null);
	}

	public XfermodeView(Context context, AttributeSet attrs) {
		super(context, attrs);
		screenW = 1080;
		screenH = 2160;
		//创建一个PorterDuffXfermode对象
		porterDuffXfermode = new PorterDuffXfermode(MODE);
		//创建原图和目标图
		greenBitmap = makeSrc(screenW, screenH);
	}

	// 创建一个矩形bitmap，作为src图
	private Bitmap makeSrc(int w, int h) {
		Bitmap bm = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
		Canvas c = new Canvas(bm);
		Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
		p.setColor(0xFF00FF00);
		c.drawRect(0, 0, w, h, p);
		return bm;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		Paint paint = new Paint();
		paint.setFilterBitmap(false);
		paint.setStyle(Paint.Style.FILL);

		//创建一个图层，在图层上演示图形混合后的效果
		int sc = canvas.saveLayer(0, 0, screenW, screenH, null, Canvas.ALL_SAVE_FLAG);
		canvas.drawBitmap(greenBitmap, 0, 0, paint);
		paint.setXfermode(porterDuffXfermode);
		canvas.drawRect(new RectF(screenW - hollowWidth, screenH - hollowWidth * 2, screenW, screenH), paint);
		paint.setXfermode(null);
		// 还原画布
		canvas.restoreToCount(sc);
	}

	public void invalidateCorner(int width) {
		hollowWidth = width;
		invalidate();
	}
}