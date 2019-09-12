package com.xunayuan.demo.aspect.entity;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 作者：罗发新
 * 时间：2019/7/10 0010    星期三
 * 邮件：424533553@qq.com
 * 说明：
 */
@Target(ElementType.METHOD) // 修饰的是方法
@Retention(RetentionPolicy.CLASS) // 编译时注解
public @interface BehaviorTrace {
    String value(); // 功能点名称
    int type(); // 唯一确定功能点的值
}

