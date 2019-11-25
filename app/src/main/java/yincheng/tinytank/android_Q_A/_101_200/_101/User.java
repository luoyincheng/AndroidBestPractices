package yincheng.tinytank.android_Q_A._101_200._101;

import java.io.Serializable;

class User implements Serializable {
	private static final long serialVersionUID = 8294180014912103005L;

	public static String username; //static修饰的变量不会序列化
	private transient String passwd; //transient修饰的变量也不会序列化

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

}
