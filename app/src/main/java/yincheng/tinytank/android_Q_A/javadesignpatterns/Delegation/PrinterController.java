package yincheng.tinytank.android_Q_A.javadesignpatterns.Delegation;

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