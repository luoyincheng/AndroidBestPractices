####Drawable是什么？
- Drawable是Android平台下通用的图形对象,Bitmap就是Drawable的一种,但是Drawable不一定是Drawable
- Drawable内存占用和绘制速度两个方面胜过Bitmap
- Bitmap和Drawable之间可以互相转换，但是Drawable内存占用远远小于Bitmap
- setImageDrawable()方法使用资源文件，setImageBitmap()使用Bitmap图片，该图片可以读取自本地相册，也可以从资源文件转化而来
