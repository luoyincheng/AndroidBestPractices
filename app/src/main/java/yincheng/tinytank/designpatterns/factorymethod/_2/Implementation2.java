package yincheng.tinytank.designpatterns.factorymethod._2;

public class Implementation2 implements Service {
	public static ServiceFactory factory = new ServiceFactory() {
		@Override
		public Service getService() {
			return new Implementation2();
		}
	};

	private Implementation2() {
	}

	@Override
	public void method() {
		System.out.println("Implementation2.method()");
	}
}
