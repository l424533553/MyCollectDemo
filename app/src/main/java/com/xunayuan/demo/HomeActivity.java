package com.xunayuan.demo;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;

import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.View;

import com.xuanyuan.library.MyToast;
import com.xuanyuan.library.adapter.AdvertiseLinearLayoutManager;
import com.xuanyuan.library.base.activity.MyAppCompatActivity;
import com.xunayuan.demo.adapter.InspectAdapter;
import com.xunayuan.demo.adapter.OnItemClickListener;
import com.xunayuan.demo.data.HomeData;
import com.xunayuan.demo.databinding.ActivityHomeBinding;

import java.util.Map;

/**
 * 数据功能，测试环境
 */
public class HomeActivity extends MyAppCompatActivity implements OnItemClickListener<String> {
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
        adapter.setOnItemClickListener(this);
        binding.homeList.setAdapter(adapter);
    }

    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        initData();

//      NotificationHelpter notificationHelpter = new NotificationHelpter(this);
//      notificationHelpter.createNotification(this, "test_id");
    }

    @Override
    protected String[] getPermissionsArray() {
        return new String[0];
    }

    @Override
    public void onItemClick(String s) {
        Intent intent = new Intent();
        Class classT = map.get(s);
        if (classT != null) {
            intent.setClass(this, classT);
            startActivity(intent);
        }
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
