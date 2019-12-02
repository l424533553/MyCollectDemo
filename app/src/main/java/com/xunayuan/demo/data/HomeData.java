package com.xunayuan.demo.data;


import com.xuanyuan.arrlibrary.room.RoomTestActivity;
import com.xunayuan.demo.ApkUpdateActivity;
import com.xunayuan.demo.AspectJActivity;
import com.xunayuan.demo.TestActivity;
import com.xunayuan.demo.activity.view.ViewActivity;
import com.xunayuan.demo.config.IDataConstants;
import com.xunayuan.demo.config.IIntentConstants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class HomeData implements IDataConstants, IIntentConstants {

    /**
     * 获取功能界面
     */
    public static Map<String, Class> getHomeMapData() {
        Map<String, Class> map = new HashMap<>();
        map.put("测试页面", TestActivity.class);
        map.put("安装更新", ApkUpdateActivity.class);
        map.put("AspectJ", AspectJActivity.class);
        map.put("View控件", ViewActivity.class);
        map.put("Room数据库", RoomTestActivity.class);

        // 数据功能 测试   
//        map.put("Sqlite操作", SqliteActivity.class);
//        map.put("Service操作", MyServiceActivity.class);
//        map.put("RecyclerView", RecyclerViewActivity.class);
//        map.put("蓝牙", BlueToothActivity.class);
//        map.put("进度刷新", ProgressBarActivity.class);
//        map.put("Socket测试", SocketTestActivity.class);
//        map.put("Kotlin测试", MainActivity.class);
//        map.put("图片测试", FrescoActivity.class);
//        map.put("自定义View", ViewActivity.class);
//        map.put("EventBus测试", EventBusActivity.class);
//        map.put("Replugin插件化", EventBusActivity.class);
//        map.put("WebView菜单", WebMenuActivity.class);
//        map.put("工具类测试", ToolsActivity.class);
////        map.put("Retrofit功能", RetrofitOrRxjavaActivity.class);
//        map.put("手机硬件信息", SystemActivity.class);
//        map.put("APK下载更新测试", ApkUpdateActivity.class);
//        map.put("Bugly框架测试", MyBuglyActivity.class);
//
//        map.put("Test测试", TestActivity.class);
//        map.put("我的设置页面", MineActivity.class);

//        map.put("LiveEventBus", MineActivity.class);
        return map;
    }

    /**
     * ViewActivity   中的数据源
     */
    public static Map<String, String> getViewActivityData() {
        Map<String, String> map = new HashMap<>();
        map.put("CheckTextView", INTENT_JUMP2_CHECK_TEXT_VIEW);
//        map.put("WebView使用", WebViewActivity.class);
//        map.put("Web页面显示", WebActivity.class);
        return map;
    }

    /**
     * @return 获取html  文件
     */
    public static Map<String, Class> getToolsMapData() {
        Map<String, Class> map = new HashMap<>();
//        map.put("Word2Html", Word2HtmlActivity.class);
        return map;
    }

    public static Map<String, Class> getRetrofitMapData() {
        Map<String, Class> map = new HashMap<>();
//        map.put("APK下载更新", ApkUpdateActivity.class);
        return map;
    }

    public static List<String> getRefreshActivityData() {
        List<String> data = new ArrayList<>();
        //官方的刷新方法
        data.add(REFRESH_TYPE_SWIPE);
        data.add(REFRESH_TYPE_SMART);
        return data;
    }

    public static List<String> getRefreshData() {
        List<String> data = new ArrayList<>();
        //官方的刷新方法
        data.add("橙子");
        data.add("菠萝");
        data.add("橘子");
        data.add("葡萄");
        data.add("梨");
        data.add("西瓜");
        data.add("香瓜");
        data.add("哈密瓜");
        data.add("芒果");
        data.add("荔枝");
        return data;
    }

    public static List<String> getRefreshData2() {
        List<String> data = new ArrayList<>();
        //官方的刷新方法
        data.add("橙子2");
        data.add("菠萝2");
        data.add("橘子2");
        data.add("葡萄2");
        data.add("梨2");
        data.add("西瓜2");
        data.add("香瓜2");
        data.add("哈密瓜2");
        data.add("芒果2");
        data.add("荔枝2");
        return data;
    }

    /**
     * @return id  图片的id
     */
    public static List<Integer> getResources() {
        List<Integer> data = new ArrayList<>();
        //官方的刷新方法
//        data.add(R.mipmap.a741);
//        data.add(R.mipmap.a742);
//        data.add(R.mipmap.ic_launcher);
//        data.add(R.mipmap.ic_launcher_round);
        return data;
    }

}
