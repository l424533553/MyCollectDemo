package com.xunayuan.demo.aspect.entity;

import android.content.Intent;
import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * 作者：罗发新
 * 时间：2019/7/10 0010    星期三
 * 邮件：424533553@qq.com
 * 说明：
 */
@Aspect
public class AspectTest {

    //TODO 这个切面方法牛逼甩甩，只有奔溃即可执行方法中的代码  ，简直是屌炸天
    //注意：1、@AfterThrowing 不支持 Field -> get & set，一般用在 Method 和 Constructor
    //2、捕获的是抛出异常的方法，即使这个方法的调用方已经处理了此异常。上面例子中即使divideZero()调用了try catch，也能被anyFuncThrows织入。
    @AfterThrowing(pointcut = "call(* *..*(..))", throwing = "throwable")  // "throwable"必须和下面参数名称一样
    public void anyFuncThrows(Throwable throwable) {
        Log.e("luy", "throwable--->" + throwable);   // throwable--->java.lang.ArithmeticException: divide by zero
    }

    private final String TAG = "11111111";
    /**
     * @param joinPoint 切点，拦截 AspectJActivity 以on开头的方法
     *                  Before 在拦截的切点方法执行之前 运行该方法
     *                  1、execution()是表达式主体
     *                  2、第一个*号代表返回类型，*号代表所有的类型。
     *                  3、包名 表示需要拦截的包名，这里使用*.代表匹配所有的包名。
     *                  4、第二个*号表示类名，后面跟.MainActivity是指具体的类名叫MainActivity。
     *                  5、*(..) 最后这个星号表示方法名，+.代表具体的函数名，*号通配符。
     *                  6、**（..）括弧号里面表示方法的参数，两个.代表任意参数。
     */
    @Before("execution(* *..AspectJActivity+.on**(..))")
    public void method(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String className = joinPoint.getThis().getClass().getSimpleName();

        if ("onResume".equals(methodSignature.getName())) {

        }

        Log.e(TAG, "class:" + className);
        Log.e(TAG, "method:" + methodSignature.getName());
    }


    /**
     * After  在拦截的切点方法运行之后再调用
     *
     * @param joinPoint 拦截的切点
     */
    @After("execution(* *..AspectJActivity+.jump2Test(..))")
    public void method2(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String className = joinPoint.getThis().getClass().getSimpleName();
        if ("onResume".equals(methodSignature.getName())) {

        }

        Log.e(TAG, "class==:" + className);
        Log.e(TAG, "method==:" + methodSignature.getName());
    }

    /**
     * @param proceedingJoinPoint 程序连接点
     */
    @Around("execution(* *..AspectJActivity+.jump2Test2(..))")
    public void method3(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            String key = proceedingJoinPoint.getSignature().toString();
            Log.d(TAG, "onActivityMethodAroundFirst:" + key);
            //执行原始的方法jump2Test2()
            proceedingJoinPoint.proceed();
            Log.d(TAG, "onActivityMethodAroundSecond:" + key);
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }


    /**
     * 在方法执行后，返回一个结果再执行，如果没结果，用此修辞符修辞是不会执行的
     */
    @AfterReturning(pointcut = "call(* com.luyao.aop.aspectj.AspectJActivity.getHeight())", returning = "height")
    public void getHeight(int height) {  // height必须和上面"height"一样
        Log.e("luy", "height:" + height);
    }


    public void test() {

    }
}
