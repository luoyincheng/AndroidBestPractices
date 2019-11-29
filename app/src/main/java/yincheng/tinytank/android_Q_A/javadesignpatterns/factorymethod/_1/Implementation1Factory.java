package yincheng.tinytank.android_Q_A.javadesignpatterns.factorymethod._1;

public class Implementation1Factory implements ServiceFactory {
	@Override
	public Service getService() {
		return new Implementation1();
	}
}
