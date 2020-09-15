package yincheng.tinytank.android_Q_A._101_200._107._1;

class ClassD {
	public static void main(String[] args) {
		ClassA classA = new ClassA();
		classA.testPackageAccess();
		classA.testProtected();//protected修饰符也提供包访问权限
	}

	void testPackageAccessClass() {
		System.out.println("classD:testPackageAccessClass()");
	}
}
