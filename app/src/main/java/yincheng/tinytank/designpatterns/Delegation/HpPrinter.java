package yincheng.tinytank.designpatterns.Delegation;

public class HpPrinter implements Printer {
	@Override
	public void print(String message) {
		System.out.println("HpPrinter.print()");
	}
}
