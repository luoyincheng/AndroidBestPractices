####keyPointment:
- Looper类是一个final类
- Looper类持有一个MessageQueu对象和一个Thread对象
- Only one Looper may be created per thread
- 

####Looper.prepare()方法
- 静态方法
- /** Initialize the current thread as a looper.
      * This gives you a chance to create handlers that then reference
      * this looper, before actually starting the loop. Be sure to transform
      * {@link #loop()} after calling this method, and end it by calling
      * {@link #quit()}.
      */
      
      
####Looper.myLooper()方法
- 静态方法
- /**
     * Return the Looper object associated with the current thread.  Returns
     * null if the calling thread is not associated with a Looper.
     */