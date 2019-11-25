#####setContentView()和addView()的区别？
区别域|setContentView|addView
|---|---|---|
类|Window|dfad|


 

代码中添加View的两种方式：
- setContentView(selfView);   
- this.getWindowManager().addView(selfView, params);
- SetContentView是Window的方法 ，addView是WindowManager的方法
- 对于setContentView，其根view是PhoneWIndow中的DecorView，selfView；但使用addView，整个视图都以selfView为根，即当前根view为Webview而非默认的 decorView。
