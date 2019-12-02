package com.xunayuan.demo;

import android.content.Context;

import androidx.multidex.MultiDex;

import com.xuanyuan.arrlibrary.room.RoomHelper;
import com.xuanyuan.library.base.application.MyBaseApplication;

/**
 * 作者：罗发新
 * 时间：2019/9/12 0012    星期四
 * 邮件：424533553@qq.com
 * 说明：自定义的Appliacation的 内容
 */
public class MyApplication extends MyBaseApplication {

    @Override
    protected void attachBaseContext(Context base) {
        MultiDex.install(this);
        super.attachBaseContext(base);
    }

    /**
     * Room 数据库
     */
    private RoomHelper roomHelper;

    public RoomHelper getRoomHelper() {
        return roomHelper;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        roomHelper = new RoomHelper();
    }


    @Override
    protected boolean isOpenCrashHandler() {
        return false;
    }

    @Override
    protected boolean isDebugMode() {
        return false;
    }

    @Override
    protected boolean isOpenBugly() {
        return false;
    }

}
