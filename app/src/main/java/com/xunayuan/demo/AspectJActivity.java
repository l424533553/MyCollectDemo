package com.xunayuan.demo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.xunayuan.demo.aspect.entity.BehaviorTrace;

public class AspectJActivity extends AppCompatActivity implements View.OnClickListener {

    String TAG = getClass().getName();
    private int count;
    //创建ServiceConnection的匿名类
    private ServiceConnection connection = new ServiceConnection() {
        //重写onServiceConnected()方法和onServiceDisconnected()方法
        //在Activity与Service建立关联和解除关联的时候调用
        @Override
        public void onServiceDisconnected(ComponentName name) {
            // 使用场景， 测试开发 功能
        }

        //在Activity与Service解除关联的时候调用
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //实例化Service的内部类myBinder
            //通过向下转型得到了MyBinder的实例
            MyService.MyBinder myBinder = (MyService.MyBinder) service;
            //在Activity调用Service类的方法
            myBinder.service_connect_Activity();
        }
    };

    private void gggg() {
        boolean is1 = false;
        boolean is2 = unbindService.isActivated();
        boolean is4 = false;//True   固定
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            is4 = unbindService.isAttachedToWindow();
        }
        //点击事件
        boolean is5 = unbindService.isClickable();
        boolean is6 = unbindService.isCursorVisible();
        boolean is7 = unbindService.isDirty();    // 不一样

        boolean is8 = test.isEnabled();
        boolean is9 = test.isFocusable();
        boolean is10 = test.isFocused();
        boolean is11 = test.isSelected();

        boolean as2 = test.isActivated();
        boolean as4 = false;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            as4 = test.isAttachedToWindow();
        }
        boolean as5 = test.isClickable();
        boolean as6 = test.isCursorVisible();
        boolean as7 = test.isDirty();

        boolean as8 = test.isEnabled();
        boolean as9 = test.isFocusable();
        boolean as10 = test.isFocused();
        boolean as11 = test.isSelected();

        System.out.println("##########  " +
                "is2=" + is2 + " " +
                " is4=" + is4 +
                " is5=" + is5 +
                " is6=" + is6 +
                " is7=" + is7 +
                " is8=" + is8 +
                " is9=" + is9 +
                " is10=" + is10 +
                " is11=" + is11);

        System.out.println(
                "*************** " +
                        "as2=" + as2 + " " +

                        " as4=" + as4 +
                        " as5=" + as5 +
                        " as6=" + as6 +
                        " as7=" + as7 +
                        " as8=" + as8 +
                        " as9=" + as9 +
                        " as10=" + as10 +
                        " as11=" + as11);
    }

    private Button unbindService;
    private Button test;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        unbindService = findViewById(R.id.unbindService);
        test = findViewById(R.id.test);
        findViewById(R.id.test1).setOnClickListener(this);
        findViewById(R.id.test2).setOnClickListener(this);

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gggg();
            }
        });
        count = 1;

        unbindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gggg();
            }
        });

//        Button startService = findViewById(R.id.startService);
//        Button stopService = findViewById(R.id.stopService);
//
//        startService.setOnClickListener(this);
//        stopService.setOnClickListener(this);
//
//        Button bindService = findViewById(R.id.bindService);
//        Button unbindService = findViewById(R.id.unbindService);
//
//        bindService.setOnClickListener(this);
//        unbindService.setOnClickListener(this);


/*        GridView gv=findViewById(R.id.gv);
        DigitalAdapter   digitalAdapter = new DigitalAdapter(this);
        gv.setAdapter(digitalAdapter);*/

//        gv.setOnItemClickListener();
    }

    /**
     * @param v 视图控件
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //点击启动Service
            case R.id.startService:
                //构建启动服务的Intent对象
                Intent startIntent = new Intent(this, MyService.class);
                //调用startService()方法-传入Intent对象,以此启动服务
                startService(startIntent);
                break;
            //点击停止Service
            case R.id.stopService:
                //构建停止服务的Intent对象
                Intent stopIntent = new Intent(this, MyService.class);
                //调用stopService()方法-传入Intent对象,以此停止服务
                stopService(stopIntent);
                break;
            //点击绑定Service
            case R.id.bindService:
                //构建绑定服务的Intent对象
                Intent bindIntent = new Intent(this, MyService.class);
                //调用bindService()方法,以此停止服务
                bindService(bindIntent, connection, BIND_AUTO_CREATE);
                //参数说明
                //第一个参数:Intent对象
                //第二个参数:上面创建的Serviceconnection实例
                //第三个参数:标志位
                //这里传入BIND_AUTO_CREATE表示在Activity和Service建立关联后自动创建Service
                //这会使得MyService中的onCreate()方法得到执行，但onStartCommand()方法不会执行
                break;
            //点击停止Service
            case R.id.unbindService:
                //调用unbindService()解绑服务
                //参数是上面创建的Serviceconnection实例
                unbindService(connection);
                break;
            case R.id.test1:
                jump2Test();
//                shake(v);
                break;
            case R.id.test2:
                jump2Test2();
//                friend(v);
                break;
            default:
                break;
        }
    }

    private void jump2Test() {
        Log.i("11111", "before  jump2Test() ");
        Intent intent = new Intent(this, TestActivity.class);
        startActivity(intent);
        Log.i("11111", "after  jump2Test() ");
    }

    private void jump2Test2() {
        Log.i("11111", "before  jump2Test() ");
        Intent intent = new Intent(this, TestActivity.class);
        startActivity(intent);
        Log.i("11111", "after  jump2Test() ");
    }

    @BehaviorTrace(value = "摇一摇", type = 1)
    public void shake(View view) {
        Log.i(TAG, "进入摇一摇方法体");
        SystemClock.sleep(3000);
    }

    @BehaviorTrace(value = "朋友圈", type = 2)
    public void friend(View view) {
        Log.i(TAG, "进入朋友圈方法体");
        SystemClock.sleep(2000);
    }


    @Override
    protected void onStart() {
        Log.i("11111", "before  onStart() ");
        super.onStart();
        count++;
        Log.i("11111", "after   onStart() ");
    }

    @Override
    protected void onResume() {
        Log.i("11111", "before  onResume() ");
        super.onResume();
        count++;
        Log.i("11111", "after  onResume() ");
    }

    /**
     *
     */
    private void test() {
        System.out.println("使用 功能 测试");
    }









}


