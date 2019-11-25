package yincheng.tinytank.android_Q_A._1_100._58;

public class OuterClass {
	public void display(final String name, final String age) {
		class InnerClass {
			int times = 1;

			void display() {
				System.out.println(name + times + age);
			}
		}
	}
}