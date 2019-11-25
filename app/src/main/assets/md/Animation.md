- animation的重复属性设置在animationSet中是不起作用的，只能设置在单一的动画中，比如：

    ```
    <?xml version="1.0" encoding="utf-8"?>
    <alpha xmlns:android="http://schemas.android.com/apk/res/android"
        android:duration="1000"
        android:fromAlpha="0.5"
        android:repeatCount="infinite"
        android:repeatMode="reverse"
        android:toAlpha="1.0" />
    ```
- setStartTime中的时间设定应该使用AnimationUtils.currentAnimationTimeMillis(),而不是System.currentTimeMillis()
- setStartTime:When this animation should start. When the start time is set to START_ON_FIRST_FRAME, the animation will start the first time getTransformation(long, Transformation) is invoked. The time passed to this method should be obtained by calling AnimationUtils.currentAnimationTimeMillis() instead of System.currentTimeMillis().

