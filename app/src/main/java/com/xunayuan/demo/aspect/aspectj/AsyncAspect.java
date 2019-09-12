package com.xunayuan.demo.aspect.aspectj;

import android.os.Looper;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Tony Shen on 16/3/23.
 * 异步的Aspect, 注意他们的书写方式
 */
//@Aspect
public class AsyncAspect {

    @Around("execution(!synthetic * *(..)) && onAsyncMethod()")
    public void doAsyncMethod(final ProceedingJoinPoint joinPoint) throws Throwable {
        asyncMethod(joinPoint);
    }

    @Pointcut("@within(com.safframework.aop.annotation.Async)||@annotation(com.safframework.aop.annotation.Async)")
    public void onAsyncMethod() {
    }


    @Pointcut("@within(com.safframework.aop.annotation.Cacheable)||@annotation(com.safframework.aop.annotation.Cacheable)")
    public void onCacheMethod() {
    }

    // withincode: 在functionB方法内
    @Pointcut("withincode(void org.sdet.aspectj.AspectJActivity.functionB(..))")
    public void invokeFunctionB() {}

    // call: 调用dummy方法
    @Pointcut("call(void org.sdet.aspectj.AspectJActivity.dummy(..))")
    public void invokeDummy() {}

    // 在functionB内调用dummy方法
    @Pointcut("invokeDummy() && invokeFunctionB()")
    public void invokeDummyInsideFunctionB() {}

    // 在functionB方法内，调用dummy方法之前invoke下面代码（目前仅打印xxx）
    @Before("invokeDummyInsideFunctionB()")
    public void beforeInvokeDummyInsideFunctionB(JoinPoint joinPoint) {
        System.out.printf("Before.InvokeDummyInsideFunctionB.advice() called on '%s'", joinPoint);
    }


    private void asyncMethod(final ProceedingJoinPoint joinPoint) {
        Flowable.create(new FlowableOnSubscribe<Object>() {
                            @Override
                            public void subscribe(FlowableEmitter<Object> e) {
                                Looper.prepare();
                                try {
                                    joinPoint.proceed();
                                } catch (Throwable throwable) {
                                    throwable.printStackTrace();
                                }
                                Looper.loop();
                            }
                        }
                , BackpressureStrategy.BUFFER)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }
}
