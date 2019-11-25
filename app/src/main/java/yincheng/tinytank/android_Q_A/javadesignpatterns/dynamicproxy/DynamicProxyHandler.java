package yincheng.tinytank.android_Q_A.javadesignpatterns.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxyHandler implements InvocationHandler {
	private Object proxied; //被代理的对象

	public DynamicProxyHandler(Object proxied) {
		this.proxied = proxied;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (args != null) {
			for (Object arg : args) {
				System.out.println("" + arg);
			}
		}
		System.out.println("before invoke() ...");
		Object object = method.invoke(proxied, args);
		System.out.println("after invoke() ...");
		return object;
	}
}
