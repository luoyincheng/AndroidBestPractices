package yincheng.tinytank.java.annotation.annotation1060;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:05:12 18:11
 * Github : yincheng.luo
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {
	/*
	 * 注解可以提供用来完整地描述程序所需的信息
	 * 注解的定义看起来很像接口的定义，事实上，与其它任何Java接口一样，注解也将会被编译成class文件
	 * 注解享有编译器的类型检查保护
	 * @Target 用来定义注解应用于什么地方(例如一个方法 或者 一个域)
	 * @Retention 用来定义注解在哪一个级别可用，[RetentionPolicy.SOURCE],[RetentionPolicy.CLASS]或者[RetentionPolicy.RUNTIME]
	 * @Test是一个没有元素的注解，也叫标记注解，就是{}里面是空的
	 */
}
