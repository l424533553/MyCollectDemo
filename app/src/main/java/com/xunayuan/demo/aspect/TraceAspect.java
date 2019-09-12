package com.xunayuan.demo.aspect;

import android.annotation.SuppressLint;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


/**
 * Created by Tony Shen on 16/3/22.
 */
//@Aspect
public class TraceAspect {

    private static final String POINTCUT_METHOD = "execution(@com.safframework.aop.annotation.Trace * *(..))";

    private static final String POINTCUT_CONSTRUCTOR = "execution(@com.safframework.aop.annotation.Trace *.new(..))";

    private static final int ns = 1000*1000;

    @Pointcut(POINTCUT_METHOD)
    public void methodAnnotatedWithTrace() {
    }

    @Pointcut(POINTCUT_CONSTRUCTOR)
    public void constructorAnnotatedTrace() {
    }



    /**
     * Create a log message.
     *
     * @param methodName A string with the method name.
     * @param methodDuration Duration of the method in milliseconds.
     * @return A string representing message.
     */
    @SuppressLint("DefaultLocale")
    private static String buildLogMessage(String methodName, long methodDuration) {
        if (methodDuration > 10 * ns) {
            return String.format("%s() take %d ms", methodName, methodDuration / ns);
        } else if (methodDuration > ns) {
            return String.format("%s() take %dms %dns", methodName, methodDuration / ns,
                    methodDuration % ns);
        } else {
            return String.format("%s() take %dns", methodName, methodDuration % ns);
        }
    }
}
