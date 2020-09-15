package yincheng.tinytank.designpatterns.proxy;

public class Goods {
	private final String mName;

	public Goods(String name) {
		this.mName = name;
	}

	@Override
	public String toString() {
		return mName;
	}
}