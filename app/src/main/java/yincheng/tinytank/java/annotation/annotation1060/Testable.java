package yincheng.tinytank.java.annotation.annotation1060;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:05:12 18:09
 * Github : yincheng.luo
 */
public class Testable {
	public void execute() {
		System.out.println("Executing...");
	}

	@Test
	void testExecute() {
		execute();
	}
}
