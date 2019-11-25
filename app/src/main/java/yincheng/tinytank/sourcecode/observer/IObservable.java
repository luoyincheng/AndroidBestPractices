package yincheng.tinytank.sourcecode.observer;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:04:04 7:41
 * Github : yincheng.luo
 */

public class IObservable extends Observable {


	private static IObservable observable;

	public static IObservable getObservable() {
		if (observable == null) {
			observable = new IObservable();
		}
		return observable;
	}

	public void sendMessage(Object objMsg) {
		observable.setChanged();
		observable.notifyObservers(objMsg);
	}
}
