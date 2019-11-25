package yincheng.tinytank.android_Q_A.frameworks.retrofit;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.Gson;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import yincheng.tinytank.android_Q_A.frameworks.retrofit.annotations.GET;
import yincheng.tinytank.android_Q_A.frameworks.retrofit.annotations.QUERY;

public class RequestHandler implements InvocationHandler {
	@RequiresApi(api = Build.VERSION_CODES.O)
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Annotation[] annotations = method.getAnnotations();
		if (annotations != null && annotations.length > 0) {
			Annotation annotation = annotations[0];
			if (annotation instanceof GET) {
				GET get = (GET) annotation;
				return handleGetRequest(method, get, args);
			}
		}
		return null;
	}

	@RequiresApi(api = Build.VERSION_CODES.O)
	private Observable handleGetRequest(Method method, GET get, Object[] params) {
		String url = get.value();
		Type genericReturnType = method.getGenericReturnType();
		Parameter[] parameters = method.getParameters();

		ParameterizedType parameterizedType = (ParameterizedType) genericReturnType;
		Class returnedGenericClazz = null;
		if (parameterizedType != null) {
			Type[] types = parameterizedType.getActualTypeArguments();
			for (Type type : types) {
				Class cls = (Class) type;
				returnedGenericClazz = cls;
				break;
			}
		}

		if (params != null) {
			url += "?";
			for (int i = 0; i < params.length; i++) {
				QUERY query = parameters[i].getAnnotation(QUERY.class);
				url += query.value() + "=" + params[0].toString();
				if (i < params.length - 1) {
					url += "&";
				}
			}
		}
		final String getUrl = url;
		final Class returnClazz = returnedGenericClazz;
		System.out.println("--->");
		return Observable.create(observableEmitter -> {
			Request request = new Request.Builder().url(getUrl).build();
			Response response = new OkHttpClient()
					.newCall(request).execute();
			System.out.println("===>");

			if (response.isSuccessful()) {
//                    String responseStr = response.body().string();
				//这里mock返回数据
				String responseStr = response.body().string();
				System.out.println("rawResult:" + responseStr);
				Object result = new Gson().fromJson(responseStr, returnClazz);
				observableEmitter.onNext(result);
			} else {
				System.out.println("failed:");
				observableEmitter.onError(new IllegalStateException("http request failed!"));
			}
			observableEmitter.onComplete();
		});
	}
}