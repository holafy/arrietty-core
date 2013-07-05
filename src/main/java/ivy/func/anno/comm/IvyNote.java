package ivy.func.anno.comm;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author holaivy@gmail.com
 * 
 */
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER,
		ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface IvyNote {

	String title() default "";

	String value() default "";

	boolean visible() default true;

}
