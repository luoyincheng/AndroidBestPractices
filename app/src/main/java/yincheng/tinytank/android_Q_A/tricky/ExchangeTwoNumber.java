package yincheng.tinytank.android_Q_A.tricky;

public class ExchangeTwoNumber {
	public static void main(String[] args) {
		int num1 = 1;
		int num2 = 2;

		System.out.println(num1 + ":" + num2);//1:2
		num1 = num1 + num2;
		num2 = num1 - num2;
		num1 = num1 - num2;
		System.out.println(num1 + ":" + num2);//2:1
		num1 = num1 ^ num2;
		num2 = num1 ^ num2;
		num1 = num1 ^ num2;
		System.out.println(num1 + ":" + num2);//1:2
	}
}
