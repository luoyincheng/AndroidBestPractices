package yincheng.tinytank.android_Q_A.javadesignpatterns.factorymethod._2;

public class Implementation2 implements Service {
	private Implementation2() {
	}

	@Override
	public void method() {
		System.out.println("Implementation2.method()");
	}

	public static ServiceFactory factory = new ServiceFactory() {
		@Override
		public Service getService() {
			return new Implementation2();
		}
	};
}
