package com.xunayuan.demo;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.xuanyuan.library.MyToast;
import com.xuanyuan.library.adapter.AdvertiseLinearLayoutManager;
import com.xuanyuan.library.base.activity.MyAppCompatActivity;
import com.xunayuan.demo.adapter.InspectAdapter;
import com.xunayuan.demo.data.HomeData;
import com.xunayuan.demo.databinding.ActivityHomeBinding;

import java.util.Map;


public class HomeActivity extends MyAppCompatActivity {

    private ObservableArrayList<String> data = new ObservableArrayList<>();
    Map<String, Class> map;

    private void initData() {
        data.clear();
        map = HomeData.getHomeMapData();
        if (map != null) {
            data.addAll(map.keySet());
        }


        AdvertiseLinearLayoutManager linearLayoutManager = new AdvertiseLinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        binding.homeList.setLayoutManager(linearLayoutManager);

        InspectAdapter adapter = new InspectAdapter(data);
        binding.homeList.setAdapter(adapter);


//        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(this);

    }


    public  void onItem(View view){

        MyToast.toastShort(this,"点击了项目内容");

    }

    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
//        setContentView(R.layout.activity_home);


        initData();

        // 数据功能功能  开发测试
        // 测试消息栏通知的 帮助类
//        NotificationHelpter notificationHelpter = new NotificationHelpter(this);
//        notificationHelpter.createNotification(this, "test_id");

    }

    @Override
    protected String[] getPermissionsArray() {
        return new String[0];
    }


//    //    数据 数据功能  开发使用者  数据回修
//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Intent intent = new Intent();
//        Class classT = map.get(data.get(position));
//        if (classT != null) {
//            intent.setClass(this, classT);
//            startActivity(intent);
//        }
//    }


}
