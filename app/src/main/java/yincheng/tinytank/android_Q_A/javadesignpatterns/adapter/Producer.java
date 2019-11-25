package yincheng.tinytank.android_Q_A.javadesignpatterns.adapter;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:04:02 22:59
 * Github : yincheng.luo
 */

public class Producer implements Seller {

	private Seller seller;

	public Producer(Seller seller) {
		this.seller = seller;
	}

	@Override
	public void sell() {
		seller.sell();
	}
}