- 当既执行了`startService`又执行了 `binService` 的时候（不区分顺序），只有在 `stopService` 和`unBindService` 都执行后（不区分顺序）才执行 `onDestroy` 方法。
- **任何一个 Service 在整个应用程序范围内都是通用的**。即 MyService 不仅可以和 MainActivity 建立关联，还可以和任何一个 Activity 建立关联。如果 Service 和多个 Activity 绑定，则只有这个 Service 与 所有 Activity 解除绑定后，才会执行 onDestroy 方法。（如果 Activity 被销毁了，也认为 Service 和这个 Activity 解除了绑定）如果在某个 Activity 调用 startService 后，Service 就被启动了，这个时候，无论你在哪个 Activity 内再调用 startService 效果就和上面分析的多次调用 Service 效果是一样的。
- 通过bindService启动的Service的生命周期依附于启动它的Context。因此当前台调用bindService的Context销毁后，那么服务会自动停止。因此当实现一个音乐播放器时，需要同时使用startService和bindService来启动该Service，当启动这个Service的Activity销毁以后，仍能继续播放音乐。

