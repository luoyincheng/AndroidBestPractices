package yincheng.tinytank.designpatterns.proxy;

public class SellerProxy implements Seller {

	private static final int NUM_SELLER_ACQUIRED = 3;//代理从生产商拿到的货物数量
	private final Seller mSeller;
	private int numOfSoldGoods; // 已经销售的商品数量

	public SellerProxy(Seller seller) {
		this.mSeller = seller;
	}

	@Override
	public void sell(Goods goods) {
		if (numOfSoldGoods < NUM_SELLER_ACQUIRED) {
			mSeller.sell(goods);
			numOfSoldGoods++;
		} else {
			System.out.println("SellerProxy.sell():" + goods + " was sold out");
		}
	}
}