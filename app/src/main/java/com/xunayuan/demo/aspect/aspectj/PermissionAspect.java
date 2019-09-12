package com.xunayuan.demo.aspect.aspectj;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;
import java.security.Permission;


//@Aspect
public class PermissionAspect {

    private static final String POINTCUT_METHOD = "execution(@com.safframework.aop.annotation.Permission * *(..))";

    @Pointcut(POINTCUT_METHOD)
    public void methodAnnotatedWithPermission() {
    }

    @Around("methodAnnotatedWithPermission()")
    public Object permissionMethod(final ProceedingJoinPoint joinPoint) throws Throwable {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        Permission permission ;



        Object object = joinPoint.getThis();

        Context context = null;

        if (object instanceof Activity) {
            context = (Activity) object;
        } else if (object instanceof FragmentActivity) {
            context = (FragmentActivity) object;
        } else if (object instanceof Fragment) {
            context = ((Fragment) object).getContext();
        } else if (object instanceof Service) {
            context = (Service) object;
        }

        Object o = null;
        return o;
    }

    private boolean checkPermission(Context context, String permission) {

        if (ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED) {
            return true;
        }
        return false;
    }

    private boolean checkPermissions(Context context, String[] permissions) {

        for(String permission : permissions) {
            if (!checkPermission(context, permission)) {
                return false;
            }
        }
        return true;
    }

}
