package yincheng.tinytank.java.generic.generic2;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:04:30 17:07
 * Github : yincheng.luo
 */
public class TupleTest {
	static TwoTuple<String, Integer> two() {
		return new TwoTuple<>("我", 47);//Integer -> int,Autoboxing
	}

	static ThreeTuple<String, String, Integer> three() {
		return new ThreeTuple<>("我", "的", 47);
	}

	static FourTuple<String, String, String, Integer> four() {
		return new FourTuple<>("我", "的", "世", 47);
	}

	static FiveTuple<String, String, String, String, Integer> five() {
		return new FiveTuple<>("我", "的", "世", "界", 47);
	}

	public static void main(String[] args) {
		TwoTuple<String, Integer> twoTuple = two();
//      twoTuple.first = "haha";final声明确实可以保护public元素，在对象被构造出来以后，生命为final的元素便不能被再赋予其它值了
		System.out.println(twoTuple);
		System.out.println(three());
		System.out.println(four());
		System.out.println(five());
	}

}
