package yincheng.tinytank.java.concurrent.concurrent3;

/**
 * Created by yincheng on 2018/5/30/17:47.
 * github:luoyincheng
 */
public class EventGenerator extends IntGenerator {
	private int currentEventValue = 0;

	public static void main(String[] args) {
		EventChecker.test(new EventGenerator());
	}

	@Override
	public int next() {
		++currentEventValue;
		++currentEventValue;
		return currentEventValue;
	}
}
