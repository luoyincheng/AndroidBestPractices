####Bitmap是什么？
- Bitmap是位图，一般位图的文件格式为bmp,编码器有很多,比如RGB565,RGB888,是一种逐像素的显示对象,执行效率高,存储效率低(占空间大),可以理解为一种存储对象，PNG、JPEG图像就是Bitmap
- Bitmap是Drawable的一种,但是Drawable不一定是Bitmap
- Bitmap: the simplest Drawable, a PNG or JPEG image.
####getIntrinsicWidth()
- 同一个图片，所在的位置不同，该方法的返回值也不同，放在mipmap_hdpi下的大小总比mipmap_xxhdpi下要大,该方法的返回值从来不准确，经常比图片的原始分辨率大


