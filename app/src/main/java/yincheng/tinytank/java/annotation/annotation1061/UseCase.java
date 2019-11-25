package yincheng.tinytank.java.annotation.annotation1061;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:05:12 18:23
 * Github : yincheng.luo
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase {
	/**
	 * id 和 description类似方法定义，编译器会对id进行类型检查
	 * description元素有一个默认值，如果在注解某个方法时没有给出description的值，则该注解的处理器就会使用此元素的默认值
	 *
	 * @return
	 */
	public int id();

	public String description() default "no description";
}