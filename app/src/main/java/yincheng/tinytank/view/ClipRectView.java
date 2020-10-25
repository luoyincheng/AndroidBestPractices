package yincheng.tinytank.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static android.graphics.Canvas.EdgeType.AA;

public class ClipRectView extends View {
    public ClipRectView(Context context) {
        super(context);
        init();
    }

    public ClipRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ClipRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public ClipRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(500, 500);
    }

    float rightBottomDot = 10000.0f;
    RectF rect1 = new RectF(0, 0, 400, 400);
    RectF rect2 = new RectF(401, 401, 500, 500);
    RectF rect3 = new RectF(rightBottomDot - 100, rightBottomDot - 100, rightBottomDot, rightBottomDot);
    Paint paint = new Paint();

    private void init() {
        paint.setAntiAlias(true);
        paint.setColor(Color.parseColor("#ff0000"));
        paint.setStyle(Paint.Style.FILL);
        this.setBackgroundColor(Color.parseColor("#000000"));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawRect(rect1, paint);
        boolean a = false;
        boolean b = false;
//        a = canvas.clipRect(rect1);
//
//        b = canvas.clipRect(rect2, Region.Op.INTERSECT);
//        canvas.drawColor(Color.parseColor("#00ff00"));
        boolean c = canvas.quickReject(rect3, AA);
        Log.i("clipTest", a + " : " + b);
        Log.i("clipTest", c + "");
    }
}
