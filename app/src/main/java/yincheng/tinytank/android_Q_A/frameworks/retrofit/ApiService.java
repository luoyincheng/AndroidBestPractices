package yincheng.tinytank.android_Q_A.frameworks.retrofit;

import io.reactivex.Observable;
import yincheng.tinytank.android_Q_A._101_200._154.User;
import yincheng.tinytank.android_Q_A.frameworks.retrofit.annotations.GET;
import yincheng.tinytank.android_Q_A.frameworks.retrofit.annotations.POST;
import yincheng.tinytank.android_Q_A.frameworks.retrofit.annotations.QUERY;

public interface ApiService {
	@POST("http://www.baidu.com/login")
	Observable<User> login(@QUERY("username") String username, @QUERY("password") String password);

	@GET("http://www.baidu.com/checkupdate")
	Observable<CheckUpdate> checkUpdate(@QUERY("version") String version);
}
