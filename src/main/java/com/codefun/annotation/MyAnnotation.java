package com.codefun.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Administrator on 2017/2/6.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String hello() default "gege";
    String world();
    int[] array() default { 2, 4, 5, 6 };

    Class style() default String.class;
}
