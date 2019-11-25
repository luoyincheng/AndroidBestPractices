package yincheng.tinytank.java.generic.generic5;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:05:01 21:25
 * Github : yincheng.luo
 */
public class Fibonacci implements Generator<Integer> {
	private int count = 0;

	@Override
	public Integer next() {//自动打包
		return fib(count++);
	}

	private int fib(int n) {
		if (n < 2) return 1;
		return fib(n - 2) + fib(n - 1);//每产生一个数字，都是采用前面数字叠加的方式，数字越大，生成该数字需要的时间越大，到后面会非常非常非常慢，数字是多大就要运行该数字一半的(1+1)运算
	}

	public static void main(String[] args) {
		Fibonacci fibonacci = new Fibonacci();
		for (int i = 0; i < 18; i++) {
			System.out.print(fibonacci.next() + " ");
		}
	}
}
