package yincheng.tinytank.android_Q_A.javadesignpatterns.Delegation;

public class CanonPrinter implements Printer {
	@Override
	public void print(String message) {
		System.out.println("CanonPrinter.print()");
	}
}
