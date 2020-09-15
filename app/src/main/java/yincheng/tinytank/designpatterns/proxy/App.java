package yincheng.tinytank.designpatterns.proxy;

public class App {
	public static void main(String[] args) {
		/*
		 * SellerProxy 和 Seller 都实现了 Seller 接口
		 */
		SellerProxy proxy = new SellerProxy(new StudentSeller());
		Goods goods = new Goods("iPhone");
		proxy.sell(goods);
		proxy.sell(goods);
		proxy.sell(goods);
		proxy.sell(goods);
		proxy.sell(goods);
	}
}