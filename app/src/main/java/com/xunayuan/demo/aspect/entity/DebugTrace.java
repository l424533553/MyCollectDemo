package com.xunayuan.demo.aspect.entity;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 作者：罗发新
 * 时间：2019/7/10 0010    星期三
 * 邮件：424533553@qq.com
 * 说明：自定义Pointcuts可以让我们更加精准的切入一个或多个指定的切入点。
 */
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD})
public @interface DebugTrace {
}


