package yincheng.tinytank.android_Q_A.javadesignpatterns.proxy;

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