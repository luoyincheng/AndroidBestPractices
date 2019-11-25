package yincheng.tinytank.java.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexEndWithTest {
	public static void main(String[] args) {
		String testString = "fasfasfeasdfadfaf/m";
		Pattern pattern = Pattern.compile(".*/m");
		Matcher matcher = pattern.matcher(testString);
		if (testString.endsWith("/m")) {
			System.out.println(testString.substring(0, testString.length() - 2));
		}
	}
}
