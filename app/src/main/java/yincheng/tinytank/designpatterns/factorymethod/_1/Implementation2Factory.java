package yincheng.tinytank.designpatterns.factorymethod._1;

public class Implementation2Factory implements ServiceFactory {
	@Override
	public Service getService() {
		return new Implementation2();
	}
}
