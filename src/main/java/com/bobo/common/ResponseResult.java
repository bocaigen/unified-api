package com.bobo.common;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Administrator on 2020/12/19.
 * 自建注解类，用来标记方法的返回值是否需要包装
 */
@Retention(RUNTIME)
@Target({TYPE, METHOD})
@Documented
public @interface ResponseResult {
}
