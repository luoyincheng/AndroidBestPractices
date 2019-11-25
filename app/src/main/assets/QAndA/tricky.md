### 不使用额外空间交换两个数字
android_Q_A.tricky.
ExchangeTwoNumber
```java
x = x + y;
y = x - y;
x = x - y; 

x = x^y;// 只能对int,char..
y = x^y;
x = x^y;

x ^= y ^= x;
```

