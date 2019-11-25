package yincheng.tinytank.android_Q_A.javadesignpatterns.dynamicproxy;

public class StudentSeller implements Seller {
	@Override
	public void sell() {
		System.out.println("StudentSeller.sell()");
	}
}
