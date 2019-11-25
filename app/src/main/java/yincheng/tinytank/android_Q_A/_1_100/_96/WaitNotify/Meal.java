package yincheng.tinytank.android_Q_A._1_100._96.WaitNotify;

import androidx.annotation.NonNull;

public class Meal {
	private final int orderNum;

	Meal(int orderNum) {
		this.orderNum = orderNum;
	}

	@NonNull
	@Override
	public String toString() {
		return "Meal " + orderNum;
	}
}
