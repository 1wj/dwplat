package com.digiwin.sampleapp1.frtest.annotation;

import java.lang.annotation.*;

/**
 * 自定义校验类
 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE,
        ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Validation {

    //错误信息
    String message() default "参数不能为空";
}
