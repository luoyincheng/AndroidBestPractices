package yincheng.tinytank.android_Q_A._101_200._107._1;

public class ClassA {
	void testPackageAccess() {
		System.out.println("classA.testPackageAccess()");
	}

	protected void testProtected() {
		System.out.println("classA.testProtected()");
	}

	public static void main(String[] args) {
		ClassD classD = new ClassD();//就算ClassD没有用public修饰，因为ClassA和ClassD处于同一个包下，所以可以访问
		classD.testPackageAccessClass();
	}
}
