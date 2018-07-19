/**
 * 
 */
package org.andy.support.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Query {

    String value() default "";

    String name() default "";

    boolean readOnly() default false;

    String comment() default "";

    boolean cacheable() default false;

    String cacheRegion() default "";


    String lockModeAlias() default "";

    boolean executeUpdate() default false;

    boolean sqlQuery() default false;

    int fetchSize() default -1;

    int timeout() default -1;

    boolean autoInfer() default true;

}
