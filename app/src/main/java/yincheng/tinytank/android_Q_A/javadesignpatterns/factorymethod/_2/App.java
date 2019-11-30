package yincheng.tinytank.android_Q_A.javadesignpatterns.factorymethod._2;

public class App {
	public static void serviceConsumer(ServiceFactory serviceFactory) {
		Service service = serviceFactory.getService();
		service.method();
	}

	public static void main(String[] args) {
		serviceConsumer(Implementation1.factory);
		serviceConsumer(Implementation2.factory);
	}
}
