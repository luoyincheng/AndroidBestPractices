package yincheng.tinytank.android_Q_A.javadesignpatterns.dynamicproxy;

import java.lang.reflect.Proxy;

public class App {
	public static void main(String[] args) {
		StudentSeller iInterfaceImpl = new StudentSeller();
		Seller seller = (Seller) Proxy.newProxyInstance(
				Seller.class.getClassLoader(),
				new Class[]{Seller.class},
				new DynamicProxyHandler(iInterfaceImpl));
		seller.sell();
	}
}
