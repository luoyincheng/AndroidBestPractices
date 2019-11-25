#### backgrounds属性和src属性:
```
<?xml version="1.0" encoding="utf-8"?>
<ImageView xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:scaleType="fitCenter">
</ImageView>

```
```
private View genView(int drawable) {
      LayoutInflater layoutInflater = LayoutInflater.from(App.getInstance());
      View view = layoutInflater.inflate(R.layout.drawableview, this,
            false);// TODO: 2018/6/5
      ((ImageView) view).setImageDrawable(getResources().getDrawable(drawable));
      Log.i("genView", view.getWidth() + "::" + view.getHeight());
      return view;
   }
```
- 用上面的xml布局文件生成一个View的时候,不能使用setBackgroundDrawable,这样会导致xml中的layout_width和layout_height属性不起所用,因为setBackgroundDrawable是在设置背景
- 应该使用setImageDrawable方法,这是在设置src
#### 