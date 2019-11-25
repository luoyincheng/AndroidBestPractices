package yincheng.tinytank.android_Q_A._1_100._3;

public class InterfaceTest implements InterfaceA ,InterfaceB{
	@Override
	public void functionA() {

	}

	@Override
	public void functionDefault() {
		InterfaceA.super.functionDefault();
		InterfaceB.super.functionDefault();
		System.out.println("functionDefault from InterfaceTest");
	}
	//functionB()用default修饰，有默认方法实现，不用再次实现也可以（java8新特性）
}
