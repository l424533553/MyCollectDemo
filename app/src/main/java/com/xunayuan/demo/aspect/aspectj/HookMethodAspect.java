package com.xunayuan.demo.aspect.aspectj;



import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;


/**
 * Created by Tony Shen on 2016/12/7.
 */
//@Aspect
public class HookMethodAspect {

    private static final String POINTCUT_METHOD = "execution(@com.safframework.aop.annotation.HookMethod * *(..))";

    private static final String POINTCUT_CONSTRUCTOR = "execution(@com.safframework.aop.annotation.HookMethod *.new(..))";

    @Pointcut(POINTCUT_METHOD)
    public void methodAnnotatedWithHookMethod() {
    }

    @Pointcut(POINTCUT_CONSTRUCTOR)
    public void constructorAnnotatedHookMethod() {
    }

}
