package yincheng.tinytank.android_Q_A._1_100._3;

public interface InterfaceA {
	//java7中没有
	static void staticFunction() {

	}

	public void functionA();

	//java7中没有
	default void functionDefault() {
		System.out.println("functionDefault from InterfaceA");
	}
}
