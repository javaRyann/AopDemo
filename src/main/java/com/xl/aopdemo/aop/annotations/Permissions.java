package com.xl.aopdemo.aop.annotations;

import java.lang.annotation.*;


/**
 * 自定义注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Permissions {
}
