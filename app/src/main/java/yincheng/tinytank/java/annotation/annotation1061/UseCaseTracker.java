package yincheng.tinytank.java.annotation.annotation1061;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:05:13 7:40
 * Github : yincheng.luo
 */
public class UseCaseTracker {
	/**
	 * 如果没有用来读取注解的工具，那注解也不会比注释更有用
	 * getDeclaredMethods() 和 getAnnotation()方法是反射方法
	 */
	public static void trackUseCases(List<Integer> useCases, Class<?> clazz) {
		for (Method method : clazz.getDeclaredMethods()) {
			//如果方法使用了UseCase，那就返回该UseCase实例，否则返回空
			UseCase useCase = method.getAnnotation(UseCase.class);//参数:UseCase.class
			if (useCase != null) {
				System.out.println("Found Use case" + useCase.id() + " " + useCase.description());
				useCases.remove(new Integer(useCase.id()));
			}
		}
		for (int i : useCases)
			System.out.println("Warning: Missing use case-" + i);//没有使用id为50的UseCase
	}

	public static void main(String[] args) {
		List<Integer> useCases = new ArrayList<Integer>();
		Collections.addAll(useCases, 47, 48, 49, 50);
		trackUseCases(useCases, PasswordUtils.class);
	}
}
