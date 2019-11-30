package yincheng.tinytank.android_Q_A.javadesignpatterns.factorymethod._1;

public class App {
	private static void serviceConsumer(ServiceFactory serviceFactory) {
		Service service = serviceFactory.getService();
		service.method();
	}

	public static void main(String[] args) {
		serviceConsumer(new Implementation1Factory());
		serviceConsumer(new Implementation2Factory());
	}
}
