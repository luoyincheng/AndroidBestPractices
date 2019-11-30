package yincheng.tinytank.android_Q_A.javadesignpatterns.factorymethod._2;

public class Implementation1 implements Service {

	private Implementation1() {
	}

	@Override
	public void method() {
		System.out.println("Implementation1.method()");
	}

	public static ServiceFactory factory = new ServiceFactory() {
		@Override
		public Service getService() {
			return new Implementation1();
		}
	};
}

