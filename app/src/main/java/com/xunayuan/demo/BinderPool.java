package com.xunayuan.demo;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import java.util.concurrent.CountDownLatch;

/**
 * 作者：罗发新
 * 时间：2019/9/26 0026    星期四
 * 邮件：424533553@qq.com
 * 说明：
 */

public class BinderPool {

    private Context context;
    private CountDownLatch countDownLatch;
    // 数据功能 绑定池
    private static BinderPool binderPool;

    // 时间过程
    private long time;



}

//
//Error:Internal error: (java.lang.ClassNotFoundException) com.google.wireless.android.sdk.stats.IntellijIndexingStats$Index
//        java.lang.ClassNotFoundException: com.google.wireless.android.sdk.stats.IntellijIndexingStats$Index
//        at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
//        at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
//        at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
//        at com.intellij.util.indexing.counters.IndexCounters.<clinit>(IndexCounters.java:34)
//        at com.intellij.util.indexing.impl.MapReduceIndex.<init>(MapReduceIndex.java:85)
//        at org.jetbrains.jps.backwardRefs.index.CompilerReferenceIndex$CompilerMapReduceIndex.<init>(CompilerReferenceIndex.java:232)
//        at org.jetbrains.jps.backwardRefs.index.CompilerReferenceIndex.<init>(CompilerReferenceIndex.java:79)
//        at org.jetbrains.jps.backwardRefs.JavaCompilerBackwardReferenceIndex.<init>(JavaCompilerBackwardReferenceIndex.java:12)
//        at org.jetbrains.jps.backwardRefs.JavaBackwardReferenceIndexWriter.initialize(JavaBackwardReferenceIndexWriter.java:79)
//        at org.jetbrains.jps.incremental.java.JavaBuilder.buildStarted(JavaBuilder.java:148)
//        at org.jetbrains.jps.incremental.IncProjectBuilder.runBuild(IncProjectBuilder.java:363)
//        at org.jetbrains.jps.incremental.IncProjectBuilder.build(IncProjectBuilder.java:178)
//        at org.jetbrains.jps.cmdline.BuildRunner.runBuild(BuildRunner.java:139)
//        at org.jetbrains.jps.cmdline.BuildSession.runBuild(BuildSession.java:302)
//        at org.jetbrains.jps.cmdline.BuildSession.run(BuildSession.java:135)
//        at org.jetbrains.jps.cmdline.BuildMain$MyMessageHandler.lambda$channelRead0$0(BuildMain.java:228)
//        at org.jetbrains.jps.service.impl.SharedThreadPoolImpl.lambda$executeOnPooledThread$0(SharedThreadPoolImpl.java:42)
//        at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
//        at java.util.concurrent.FutureTask.run(FutureTask.java:266)
//        at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
//        at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
//        at java.lang.Thread.run(Thread.java:748)
