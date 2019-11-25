package yincheng.tinytank;


/**
 * Created by yincheng on 2018/6/4/18:40.
 * github:luoyincheng
 */
public class Test3 {
	public static int getNum() {
		try {
			int a = 1 / 0;
			return 1;
		} catch (Exception e) {
			return 2;
		} finally {
			System.out.println("3");
			return 3;
		}
	}

	public static void main(String[] args) {
		System.out.println("结果为：" + getNum());
	}
}
