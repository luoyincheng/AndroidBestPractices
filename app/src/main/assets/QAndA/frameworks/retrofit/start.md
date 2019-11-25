### 基本步骤

```java
private  void getLogin() {  
    Retrofit retrofit = new Retrofit.Builder()  //1、创建Retrofit对象指定域名
            .baseUrl("http://localhost:8080/")  
            .addConverterFactory(GsonConverterFactory.create())  
            .build();  
    ApiManager apiService = retrofit.create(ApiManager.class); //2、对象创建一个API接口对象：
    Call<LoginResult> call = apiService.getData("lyk", "1234");  
    call.enqueue(new Callback<LoginResult>() {  //3、call对象发生同步/异步请求
        @Override  
        public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {  
            if (response.isSuccess()) {  
                // 请求成功  
            } else {  
               //直接操作UI 或弹框提示请求失败  
            }  
        }  
        @Override  
        public void onFailure(Call<LoginResult> call, Throwable t) {  
            //错误处理代码  
        }  
    });  
}
```

> 1.使用builder模式生成一个retrofit对象
>
> 2.构造一个用注解形式封装了请求方式、header、参数、返回值等的请求接口，这里的返回值可以是Observable，也可以是Call<>，这个Call是retrofit中的call对象。
>
> 3.使用第一步的retrofit对象的create(第二步的class对象(因为class对象已经包含了创造这个接口实例的所有信息))方法来创建一个第二部定义的接口实例。
>
> 4.直接调用第三步中生成的实例的方法就可以返回具体的Call对象()，通过这个call对象直接调用嗯queue方法来执行网络访问。