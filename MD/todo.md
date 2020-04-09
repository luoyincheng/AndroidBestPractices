- SubsamplingScaleImageView  if (!isEnabledOperation) {//是否为选中状态
- SubsamplingScaleImageView public boolean onSingleTapConfirmed(MotionEvent e) {
- 1.http流程，android怎么做一个http请求
  2.view的绘制流程
  3.rxjava的作用
  4.dpi和dp
  5.invalidate和requestlayout的区别
  6.apk压缩方式，原理呢
  7.rxjava网络请求链式调用
  8.retrofit原理
  9.rxjava实现点击事件的过滤

  #### 一个从小到大排好序的数组，从某一个位置断开分为两个有序的数组，将后面的数组放到前面形成一个新的有了“断层”的数组，现在在新生成的数组中进行查找，能否使用二分查找？？？
  - 可以,
  要查找的数字:tar_num,
  第一部分有序数组:fir_array,
  第二部分数组:sen_array,
  中间数字:mid_num,
  最后一个数字:end_num,
  第一个数字:fir_num

  - 第一步:比较tar_num和mid_num
  - 第二步:根据下标获取中间数字，将mid_num和end_num进行比较，
  如果mid_num > end_num,表明fir_array比sen_array数据多，mid_num位于fir_array中，
  如果mid_num < end_num,表明 sen_array比fir_array数据多，mid_num位于sen_array中。
  如果mid_num == end_num,直接返回该数字(有可能出现连续相同的几个数字，此时需要从该位置往前，往后分别查找)
  - 第三步:
  当fir_array数量更多时:
  如果tar_num比mid_num小，需要将数组从mid_num处分为两部分，分别对这两部分进行查找，其中左边使用常规的二分查找，右边递归(因为fir_array数量更多，从mid_num往后的数据形成了一个同样有断层的新数组)
  如果tar_num比mid_num大，直接对右边新生成的数组递归
  如果sen_array数量更多时:
  and so on...

####Bitmap是什么？
- Bitmap是位图，一般位图的文件格式为bmp,编码器有很多,比如RGB565,RGB888,是一种逐像素的显示对象,执行效率高,存储效率低(占空间大),可以理解为一种存储对象，PNG、JPEG图像就是Bitmap
- Bitmap是Drawable的一种,但是Drawable不一定是Bitmap
- Bitmap: the simplest Drawable, a PNG or JPEG image.
####getIntrinsicWidth()
- 同一个图片，所在的位置不同，该方法的返回值也不同，放在mipmap_hdpi下的大小总比mipmap_xxhdpi下要大,该方法的返回值从来不准确，经常比图片的原始分辨率大


####Drawable是什么？
- Drawable是Android平台下通用的图形对象,Bitmap就是Drawable的一种,但是Drawable不一定是Drawable
- Drawable内存占用和绘制速度两个方面胜过Bitmap
- Bitmap和Drawable之间可以互相转换，但是Drawable内存占用远远小于Bitmap
- setImageDrawable()方法使用资源文件，setImageBitmap()使用Bitmap图片，该图片可以读取自本地相册，也可以从资源文件转化而来

#####setContentView()和addView()的区别？
区别域|setContentView|addView
|---|---|---|
类|Window|dfad|




代码中添加View的两种方式：
- setContentView(selfView);
- this.getWindowManager().addView(selfView, params);
- SetContentView是Window的方法 ，addView是WindowManager的方法
- 对于setContentView，其根view是PhoneWIndow中的DecorView，selfView；但使用addView，整个视图都以selfView为根，即当前根view为Webview而非默认的 decorView。


### RequestManager(glide)
- 创建RequestBuilder

- 通过生命周期管理请求的启动与结束

  > 使用 Glide 加载图片时，如果当前页面被销毁或者不可见时会停止加载图片，但我们使用 Glide 加载图片时并没有显示的去设置 Glide 与当前页面的生命周期关联起来，只是传了个 Context 对象，那么 Glide 是如何通过一个上下文对象就能获取到页面生命周期的呢？
  >
  > 创建 RequestManager 时需要一个 FragmentManager 参数（全局 RequestManager 除外），那么再创建 RequestManager 时会**先创建一个不可见的 Fragment** ，通过 FM 加入到当前页面，用这个不可见的 Fragment 即可检测页面的生命周期。代码中保证了每个 Activity/Fragment 中只包含一个 RequestManagerFragment 与 一个 RequestManager。

### ActiveResources

- 第一级缓存，表示正在活动中的资源。

- 生命周期较短，因此没有大小限制。

-  ActiveResources 中通过一个 HashMap 来存储数据，数据保存在一个虚引用中：

  ```java
  Map<Key, ResourceWeakReference> activeEngineResources = new HashMap<>();
  static final class ResourceWeakReference extends WeakReference<EngineResource<?>>
  ```

- 使用一个引用队列：

  ```java
  private final ReferenceQueue<EngineResource<?>> resourceReferenceQueue = new ReferenceQueue<>();
  ```

  > 每当向 activeEngineResources 中添加一个 WeakReference 对象时都会将 resourceReferenceQueue 和这个 WeakReference 关联起来，用来跟踪这个 WeakReference 的 gc，一旦这个弱引用被 gc 掉，就会将它从 activeResource 中移除，ReferenceQueue 的具体作用大概就是用来**跟踪弱引用（或者软引用、虚引用）是否被 gc 的。**

### 内存缓存

### 磁盘缓存


(rxjava:)
### 两次嵌套的网络请求
### 事件流发送过快，如何只接受一个事件，后续的事件都不接收了

手写实现:
1.所有的单例模式
2.实现栈

<h3 style="text-align:center">待做</h3>

### 用户自定义启动页面内容，内容由公司提供，并且有排行，用户也可以分享自己制作的页面，只要这些用户给我们的内容下载量超过一定的值时，创作者就可以获取一定的报酬（根据比例）
### 用户的提醒设置一样可以自定义，可以设置成自己的语音提醒，或者以动画的形式展现出来，内容可以自由定义。同样有排行，也可以是明星的，可以是电影里面的截图或者截取的片段（当心版权）
###
### 2.

收费方式

如如果列表滑动很快，但是图片还没加载出来时导致
所有会重复使用的类都缓存起来，下次再使用就直接从缓存中读取，避免重复创建类

设置中添加用户可以配置的选项，比如侧边栏宽度
任何有图片的控件，长按以后都显示查看图片，编辑图片