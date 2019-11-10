import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.CLASS;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target(METHOD)
@Retention(CLASS)
public @interface MyAnnotation {
	int count();
	String name() default "Zabee";
	String[] skills() default {"Java","J2EE","Cloud"};
}
