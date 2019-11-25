package yincheng.tinytank.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by yincheng on 2018/6/19/17:16.
 * github:luoyincheng
 */
@Target({
		ElementType.METHOD,
		ElementType.CONSTRUCTOR,
		ElementType.FIELD,
		ElementType.LOCAL_VARIABLE,
		ElementType.PACKAGE,
		ElementType.PARAMETER,
		ElementType.TYPE
})
@Retention(RetentionPolicy.RUNTIME)
public @interface Recite {
}
