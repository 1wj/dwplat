package com.digiwin.sampleapp1.frtest.annotation;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 校验触发类
 */
@Slf4j
public class ValidationCheck {

    /**
     * 抛出的所有的校验信息
     */
    private static final StringBuilder message;
    /**
     * 判断是否需要抛出校验信息，默认不抛出
     */
    private static boolean flag;
    //初始化
    static {
        message = new StringBuilder();
        flag=false;
    }

    /**
     * 校验方法
     * 扫描对象中的属性，查看是否有@Validation注解，有注解的进行校验
     *
     * @param o 要校验的对象，如入参对象
     */
    public static void check(Object o) {
        if (null == o) {
            return;
        }
        Class<?> clazz = o.getClass();
        List<Field> fieldList = new ArrayList<>();
        while (clazz != null) {
            fieldList.addAll(new ArrayList<>(Arrays.asList(clazz.getDeclaredFields())));
            clazz = clazz.getSuperclass();
        }
        //变量对象的所有属性
        fieldList.forEach(field -> {
            field.setAccessible(true);
            try {
                Object value = field.get(o);

                //获取属性值
                Validation annotation = field.getAnnotation(Validation.class);
                if (null == annotation) {   //未加注解的不做处理
                    return;
                }
                checkNotNull(value, annotation);
            } catch (IllegalArgumentException | IllegalAccessException e) {
                log.info("Validation验证器数据解析失败:{}", e.getMessage());
            }
        });
        //判断是否需要抛出校验信息
        if(flag)
        {
            throw new RuntimeException(message.toString());
        }
    }

    /**
     * 非空判断
     * @param value      属性值
     * @param validation 注解信息
     */
    private static void checkNotNull(Object value, Validation validation) {
        //开始校验非空
        if (validation != null && (value == null || "".equals(value))) {
            //确认抛出校验信息
            flag=true;
            //校验信息拼接
            message.append(validation.message()).append("   ");
        }
    }

}