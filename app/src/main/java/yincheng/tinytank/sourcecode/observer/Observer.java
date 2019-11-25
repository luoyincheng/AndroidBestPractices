package yincheng.tinytank.sourcecode.observer;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:04:04 7:30
 * Github : yincheng.luo
 */


/**
 * A class can implement the <code>Observer</code> interface when it
 * wants to be informed of changes in observable objects.
 *
 * @author Chris Warth
 * @see java.util.Observable
 * @since JDK1.0
 */
public interface Observer {
	/**
	 * This method is called whenever the observed object is changed. An
	 * application calls an <tt>Observable</tt> object's
	 * <code>notifyObservers</code> method to have all the object's
	 * observers notified of the change.
	 *
	 * @param o   the observable object.
	 * @param arg an argument passed to the <code>notifyObservers</code>
	 *            method.
	 */
	void update(Observable o, Object arg);
}
