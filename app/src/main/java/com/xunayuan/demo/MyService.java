package com.xunayuan.demo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import androidx.annotation.Nullable;
import android.util.Log;

/**
 * Created by Carson_Ho on 16/11/5.
 */
public class MyService extends Service {

    private int intId;
    private MyBinder mBinder = new MyBinder();

    @Override
    public void onCreate() {
        super.onCreate();
        intId++;
        System.out.println("执行了onCreat()"+intId);
        Log.i("111", "执行了onCreat()"+intId);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("执行了onStartCommand()"+intId);
        Log.i("111", "执行了onStartCommand()"+intId);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("111", "执行了onDestory()"+intId);
        System.out.println("执行了onDestory()"+intId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        System.out.println("执行了onBind()"+intId);
        Log.i("111", "执行了onBind()"+intId);
        //返回实例
        return mBinder;
    }


    @Override
    public boolean onUnbind(Intent intent) {
        System.out.println("执行了onUnbind()"+intId);
        Log.i("111", "执行了onUnbind()"+intId);
        return super.onUnbind(intent);
    }

    //新建一个子类继承自Binder类，
    class MyBinder extends Binder {
        public void service_connect_Activity() {
            System.out.println("Service关联了Activity,并在Activity执行了Service的方法"+intId);
            Log.i("111", "Service关联了Activity,并在Activity执行了Service的方法()"+intId);
        }
    }
}
