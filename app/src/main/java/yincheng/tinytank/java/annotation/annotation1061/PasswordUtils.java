package yincheng.tinytank.java.annotation.annotation1061;

import java.util.List;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:05:13 7:10
 * Github : yincheng.luo
 */
public class PasswordUtils {
	@UseCase(id = 47, description = "Password must contain at least one numeric")
	public boolean validatePassword(String password) {
		return (password.matches("\\w*\\d\\w"));// TODO: 2018/5/13 这个regex什么意思
	}

	/**
	 * 这里没有给出description元素的值，因此，在UseCase的注解处理器分析处理这个类时会使用该元素的默认值
	 */
	@UseCase(id = 48)
	public String encryptPassword(String password) {
		return new StringBuilder(password).reverse().toString();
	}

	@UseCase(id = 49, description = "New password cannot equals to previously used ones")
	public boolean checkForNewPassword(List<String> prevPasswords, String password) {
		return !prevPasswords.contains(password);
	}

	/**
	 *
	 * public static void main(String[] args) {
	 * String t = "a||b||c||d";
	 * //“\\”会转义成反斜杠，反斜杠本身就是转义符，所有就成了“\|”，再进行转义就是“|”，所以\\|实际上是“|”。
	 * String[] temp = t.split("\\|\\|");
	 * System.out.println(temp.length);
	 * //String 没有reverse()方法
	 * System.out.println(new StringBuilder("我的世界").reverse().toString());
	 * }
	 */
}
