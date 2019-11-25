package yincheng.tinytank.android_Q_A.javadesignpatterns.proxy;

public class StudentSeller implements Seller {
	@Override
	public void sell(Goods goods) {
		System.out.println("StudentSeller.Sell():" + goods + " is selling");
	}
}