package yincheng.tinytank.designpatterns.dynamicproxy;

public class StudentSeller implements Seller {
	@Override
	public void sell() {
		System.out.println("StudentSeller.sell()");
	}
}
