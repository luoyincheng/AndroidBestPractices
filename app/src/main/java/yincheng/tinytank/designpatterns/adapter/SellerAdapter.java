package yincheng.tinytank.designpatterns.adapter;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:04:02 22:58
 * Github : yincheng.luo
 */

public class SellerAdapter implements Seller {

	private Student student;

	public SellerAdapter() {
		student = new Student();
	}

	@Override
	public void sell() {
		student.studying();
	}
}