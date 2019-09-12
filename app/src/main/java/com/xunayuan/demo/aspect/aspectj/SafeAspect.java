package com.xunayuan.demo.aspect.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;

/**
 * Created by Tony Shen on 16/3/23.
 */
//@Aspect
public class SafeAspect {

    private static final String POINTCUT_METHOD = "execution(@com.safframework.aop.annotation.Safe * *(..))";

    @Pointcut(POINTCUT_METHOD)
    public void methodAnnotatedWithSafe() {
    }



    private static String getStringFromException(Throwable ex) {
        StringWriter errors = new StringWriter();
        ex.printStackTrace(new PrintWriter(errors));
        return errors.toString();
    }
}
