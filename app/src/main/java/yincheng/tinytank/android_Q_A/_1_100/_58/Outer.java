package yincheng.tinytank.android_Q_A._1_100._58;

class Outer {
	private int a;

	public class Inner {

		private int a;

		public void method(int a) {
			a++;                // 局部变量
			this.a++;           // Inner类成员变量
			Outer.this.a++;     // Outer类成员变量
		}
	}
}
