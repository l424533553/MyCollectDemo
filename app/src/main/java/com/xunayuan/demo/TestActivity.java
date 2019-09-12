package com.xunayuan.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 *  测试 开发 功能
 */
public class TestActivity extends AppCompatActivity {

    /**
     * 记录时间
     */
    private long time;
    private String TAG = this.getClass().getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        findViewById(R.id.test3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestActivity.this, AspectJActivity.class);
                startActivity(intent);
            }
        });
        time = System.currentTimeMillis();
        Log.i("123456", "onCreate=" + time);
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("123456", "onStart=" + time);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("123456", "onResume=" + time);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("123456", "onDestroy=" + time);
    }




}
