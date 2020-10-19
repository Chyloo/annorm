package com.ropz.annorm.annotation;

import com.ropz.annorm.eumBean.ColumnType;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ropz
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TableColumn {
    //字段名
    String columnName();

    //大小
    int size() default 0;

    //字段类型
    ColumnType columnType();
}
