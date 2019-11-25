package yincheng.tinytank.cornerstone.xml;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:06:09 13:39
 * Github : yincheng.luo
 */
public class XmlHelper {
	private static Animation createAnimationFromXml(Context c, XmlPullParser parser,
	                                                AnimationSet parent, AttributeSet attrs) throws XmlPullParserException, IOException {

		Animation anim = null;

		// Make sure we are on a create tag.
		int type;
		int depth = parser.getDepth();

		while (((type = parser.next()) != XmlPullParser.END_TAG || parser.getDepth() > depth)
				&& type != XmlPullParser.END_DOCUMENT) {

			if (type != XmlPullParser.START_TAG) {
				continue;
			}

			String name = parser.getName();

			if (name.equals("set")) {
				anim = new AnimationSet(c, attrs);
				createAnimationFromXml(c, parser, (AnimationSet) anim, attrs);
			} else if (name.equals("alpha")) {
				anim = new AlphaAnimation(c, attrs);
			} else if (name.equals("scale")) {
				anim = new ScaleAnimation(c, attrs);
			} else if (name.equals("rotate")) {
				anim = new RotateAnimation(c, attrs);
			} else if (name.equals("translate")) {
				anim = new TranslateAnimation(c, attrs);
			} else {
				throw new RuntimeException("Unknown animation name: " + parser.getName());
			}

			if (parent != null) {
				parent.addAnimation(anim);
			}
		}

		return anim;

	}
}
