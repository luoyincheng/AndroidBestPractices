### disposable和subscription的区别

- Subscription具备Disposable参数的作用，即Disposable.dispose()切断连接, 同样的调用Subscription.cancel()切断连接
- Subscription增加了void request(long n)

---

