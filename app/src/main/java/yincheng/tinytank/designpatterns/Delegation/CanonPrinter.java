package yincheng.tinytank.designpatterns.Delegation;

public class CanonPrinter implements Printer {
	@Override
	public void print(String message) {
		System.out.println("CanonPrinter.print()");
	}
}
