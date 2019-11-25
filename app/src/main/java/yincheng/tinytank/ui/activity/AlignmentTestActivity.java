package yincheng.tinytank.ui.activity;

import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import yincheng.tinytank.R;
import yincheng.tinytank.tinyframe.draggablearea.ImageSource;
import yincheng.tinytank.tinyframe.draggablearea.LayerView;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:04:03 23:00
 * Github : yincheng.luo
 */

public class AlignmentTestActivity extends AppCompatActivity {
	public static final String TOUCH_EVENT_TAG = "touchEventTest";

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		try {
//			Thread.sleep(6000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		} finally {
			setContentView(R.layout.activity_test);
//		}
//				setContentView(new SparkView(this));

//        ((SubSamplingScaleImageView) findViewById(R.id.iv_beauty1)).setImage(ImageSource.asset("flame.jpg"));
//        ((SubSamplingScaleImageView) findViewById(R.id.iv_landscape)).setImage(ImageSource.asset("landscape.jpg"));
//        ((SubSamplingScaleImageView) findViewById(R.id.iv_moon)).setImage(ImageSource.asset("beauty.jpg"));
//        ((SubSamplingScaleImageView) findViewById(R.id.iv_beauty2)).setImage(ImageSource.asset("moon.jpg"));
//        ((SubSamplingScaleImageView) findViewById(R.id.iv_beauty1)).setImage(ImageSource.asset("flame.jpg"));
//        ((SubSamplingScaleImageView) findViewById(R.id.iv_landscape)).setImage(ImageSource.asset("landscape.jpg"));
//        ((SubSamplingScaleImageView) findViewById(R.id.iv_moon)).setImage(ImageSource.asset("beauty.jpg"));
//        ((SubSamplingScaleImageView) findViewById(R.id.iv_beauty2)).setImage(ImageSource.asset("moon.jpg"));

//        ((LayerView) findViewById(R.id.iv_beauty1)).setImage(ImageSource.asset("flame.jpg"));
//        ((LayerView) findViewById(R.id.iv_landscape)).setImage(ImageSource.asset("landscape.jpg"));
//        ((LayerView) findViewById(R.id.iv_moon)).setImage(ImageSource.asset("beauty.jpg"));
		ImageSource imageSource = ImageSource.asset("beauty.jpg");
		String uriString = "beauty.jpg";
		uriString = "file:///android_asset/" + uriString;
		Uri uri = Uri.parse(uriString);
		Log.i("uritest", uri == null ? "null" : "not null");
		Log.i("uritest", uri.getPath());

		LayerView target = findViewById(R.id.iv_beauty2);
		target.setOnClickListener(view -> {
			Log.i("uritest", "adfafafa");
			target.setImageURI(uri);
		});

//        mockClick(iv_beauty1, -100, -1400);//x坐标和y坐标随便指定
//        mockClick(iv_landscape, -100, -1400);//x坐标和y坐标随便指定
//        mockClick(iv_moon, -100, -1400);//x坐标和y坐标随便指定
//        mockClick(iv_beauty2, -100, -1400);//x坐标和y坐标随便指定
//        Toast.makeText(this, "模拟点击了", Toast.LENGTH_LONG).show();
	}

	/**
	 * 在模拟点击事件中，只需要保证ACTION_DOWN事件和ACTION_UP事件的point偏移量小于1.0f就可以，
	 * 点击位置的具体位置不需要指定
	 *
	 * @param view，要被点击的View
	 * @param x，MOTION_EVENT事件的 x 坐标
	 * @param y，MOTION_EVENT事件的 y 坐标
	 */
	private void mockClick(View view, float x, float y) {
		long downTime = SystemClock.uptimeMillis();
		MotionEvent downEvent = MotionEvent.obtain(downTime, downTime,
				MotionEvent.ACTION_DOWN, x, y, 0);
		downTime += 100;
		MotionEvent upEvent = MotionEvent.obtain(downTime, downTime,
				MotionEvent.ACTION_UP, x + 0.99f, y + 0.99f, 0);
		view.onTouchEvent(downEvent);
		view.onTouchEvent(upEvent);
		downEvent.recycle();
		upEvent.recycle();
	}

	/**
	 * activity中的dispatchTouchEvent()方法返回false或者true都会让其他方法不执行,
	 * 结果是只执行activity自身的dispatchTouchEvent()方法
	 */
//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        Log.i(TOUCH_EVENT_TAG, "( activity ) ==> dispatchTouchEvent = " + "[false]");
//        return false;
//        Log.i(TOUCH_EVENT_TAG, "( activity ) ==> dispatchTouchEvent = " + "[true]");
//        return true;
//        Log.i(TOUCH_EVENT_TAG, "( activity ) ==> dispatchTouchEvent = " + "[" + super.dispatchTouchEvent(ev) + "]");
//        return super.dispatchTouchEvent(ev);
//    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN://0
//                Log.i(TOUCH_EVENT_TAG, "( activity ) ==> ACTION_DOWN");
//                break;
//            case MotionEvent.ACTION_UP://1
//                Log.i(TOUCH_EVENT_TAG, "( activity ) ==> ACTION_UP");
//                break;
//            case MotionEvent.ACTION_MOVE://2
//                Log.i(TOUCH_EVENT_TAG, "( activity ) ==> ACTION_MOVE");
//                break;
//            case MotionEvent.ACTION_CANCEL://3
//                Log.i(TOUCH_EVENT_TAG, "( activity ) ==> ACTION_CANCEL");
//                break;
//            case MotionEvent.ACTION_OUTSIDE://4
//                Log.i(TOUCH_EVENT_TAG, "( activity ) ==> ACTION_OUTSIDE");
//                break;
//            case MotionEvent.ACTION_POINTER_DOWN://5
//                Log.i(TOUCH_EVENT_TAG, "( activity ) ==> ACTION_POINTER_DOWN");
//                break;
//            case MotionEvent.ACTION_POINTER_UP://6
//                Log.i(TOUCH_EVENT_TAG, "( activity ) ==> ACTION_POINTER_UP");
//                break;
//            case MotionEvent.ACTION_HOVER_MOVE://7
//                Log.i(TOUCH_EVENT_TAG, "( activity ) ==> ACTION_HOVER_MOVE");
//                break;
//            case MotionEvent.ACTION_SCROLL://8
//                Log.i(TOUCH_EVENT_TAG, "( activity ) ==> ACTION_SCROLL");
//                break;
//            case MotionEvent.ACTION_HOVER_ENTER://9
//                Log.i(TOUCH_EVENT_TAG, "( activity ) ==> ACTION_HOVER_ENTER");
//                break;
//            case MotionEvent.ACTION_HOVER_EXIT://10
//                Log.i(TOUCH_EVENT_TAG, "( activity ) ==> ACTION_HOVER_EXIT");
//                break;
//            case MotionEvent.ACTION_BUTTON_PRESS://11
//                Log.i(TOUCH_EVENT_TAG, "( activity ) ==> ACTION_BUTTON_PRESS");
//                break;
//            case MotionEvent.ACTION_BUTTON_RELEASE://12
//                Log.i(TOUCH_EVENT_TAG, "( activity ) ==> ACTION_BUTTON_RELEASE");
//                break;
//        }
//        Log.i(TOUCH_EVENT_TAG, "( activity ) ==> onTouchEvent = " + "[false]");
//        return false;
//        Log.i(TOUCH_EVENT_TAG, "( activity ) ==> onTouchEvent = " + "[true]");
//        return true;
//        Log.i(TOUCH_EVENT_TAG, "( activity ) ==> onTouchEvent = " + "[" + super.onTouchEvent(event) + "]");
//        return super.onTouchEvent(event);
//    }
}
