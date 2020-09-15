package yincheng.tinytank.designpatterns.Delegation;

public class PrinterController implements Printer {

	private final Printer mPrinter;

	PrinterController(Printer printer) {
		this.mPrinter = printer;
	}

	@Override
	public void print(String message) {
		mPrinter.print(message);
	}
}