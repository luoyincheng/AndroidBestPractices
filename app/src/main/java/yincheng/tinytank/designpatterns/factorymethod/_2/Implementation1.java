package yincheng.tinytank.designpatterns.factorymethod._2;

public class Implementation1 implements Service {

	public static ServiceFactory factory = new ServiceFactory() {
		@Override
		public Service getService() {
			return new Implementation1();
		}
	};

	private Implementation1() {
	}

	@Override
	public void method() {
		System.out.println("Implementation1.method()");
	}
}

