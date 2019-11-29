package yincheng.tinytank.android_Q_A._101_200._107;

import yincheng.tinytank.android_Q_A._101_200._107._1.ClassA;

public class ClassC extends ClassA{
	public static void main(String[] args) {
		ClassC classC = new ClassC();
//		classC.testPackageAccess();//包访问权限修饰的方法只能被同一个包下的类访问。
		classC.testProtected();//子类可以访问父类的protected修饰的方法,即使不在同一个包下。
	}
}
