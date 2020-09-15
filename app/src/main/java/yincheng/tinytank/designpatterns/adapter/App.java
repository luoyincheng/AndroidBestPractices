package yincheng.tinytank.designpatterns.adapter;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:05:16 8:29
 * Github : yincheng.luo
 */
public class App {
	public static void main(String[] args) {
		Producer producer = new Producer(new SellerAdapter());
		producer.sell();
	}
}