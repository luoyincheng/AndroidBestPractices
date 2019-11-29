package yincheng.tinytank.android_Q_A._101_200._107._2;

import yincheng.tinytank.android_Q_A._101_200._107._1.ClassA;

public class ClassB {
	void test() {
		System.out.println("classB.test()");
	}

	public static void main(String[] args) {
		ClassA classA = new ClassA();
//		classA.testPackageAccess();//不在同一个包下不能访问‘包访问权限’修饰的方法。
	}
}
