package yincheng.tinytank.designpatterns.Delegation;

public class EpsonPrinter implements Printer {
	@Override
	public void print(String message) {
		System.out.println("EpsonPrinter.print()");
	}
}
