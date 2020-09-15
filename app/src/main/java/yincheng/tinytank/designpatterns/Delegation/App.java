package yincheng.tinytank.designpatterns.Delegation;

public class App {
	public static void main(String[] args) {
		PrinterController hpController = new PrinterController(new HpPrinter());
		PrinterController epsonController = new PrinterController(new EpsonPrinter());
		PrinterController canonController = new PrinterController(new CanonPrinter());
		hpController.print("勿忘初心");
		epsonController.print("凭心而动");
		canonController.print("雨过天晴，云淡风轻");
	}
}
