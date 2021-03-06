package de.malkusch.validation.constraints.age;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * The Date must be at least 18 years old.
 * 
 * @author Markus Malkusch
 */
@Age(18)
@Constraint(validatedBy={})
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
public @interface Adult {

	String message() default "{de.malkusch.validation.constraints.age.Age.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
	
    /**
	 * Defines several {@link Adult} annotations on the same element.
	 * 
	 * @see Adult
	 */
    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
	@Retention(RUNTIME)
	@Documented
	@interface List {
		Adult[] value();
	}
}
