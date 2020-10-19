package com.ropz.annorm.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ropz
 * 字段约束
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Constraints {
    //是否是主键
    boolean primary() default false;

    //是否必填
    boolean allowNull() default false;

    //是否唯一
    boolean isUnique() default false;
}
