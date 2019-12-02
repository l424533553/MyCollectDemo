package com.xunayuan.demo.activity

import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*

import android.view.ViewGroup
import com.xunayuan.demo.R

/**
 * 1.进行沉浸式测试,有xml方式和java 代码方式
 * XML方式：1)先在res包下新建values-v19和values-v21两个包，为了兼容Android高低版本
 *          2)在activity.xml文件中配置     android:fitsSystemWindows="true"
 *          3)在AndroidManifest中配置style设置
 * Java方式：如下方法看 initBar（）即为沉浸式
 *
 */
class ImmersiveActivity : AppCompatActivity() {

    //
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        StatusBarUtilKt.setImageTranslucent(this,Color.TRANSPARENT,0)
        setContentView(R.layout.activity_immersive)

//        /**
//         * 第二种方案
//         */
//        initBar(true)
//        setContentView(com.xunayuan.demo.R.layout.activity_immersive)
//        setRootView(this)

    }

    /**
     * 需要将其放在  setContentView 的前面，否则报错
     * SDK<19的无法获得沉浸式
     */
    @SuppressLint("ObsoleteSdkInt")
    private fun initBar(isHidebar: Boolean) {
        //取消状态栏的标题
        window.requestFeature(Window.FEATURE_NO_TITLE)
        //将actionBar隐藏
        when {
            Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT -> return
            Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP ->
                //让contentView延伸到状态栏并且设置状态栏颜色透明
                window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            //判断SDK的版本是否>=21
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP -> {
                //清除 Activity的状态栏和导航栏的 半透明转态，便于后面设置透明的状态
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS or WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)            //允许页面可以拉伸到顶部状态栏并且定义顶部状态栏透名
                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or                        //设置全屏显示
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                //状态栏覆盖在contentView上面，设置透明使contentView的背景透出来
                window.statusBarColor = Color.TRANSPARENT
                window.navigationBarColor = Color.TRANSPARENT        //设置虚拟键为透明
            }
        }

        //是否将actionBar隐藏
        if (isHidebar) {
            supportActionBar?.hide()
        }
    }


    /**
     * 设置根布局参数
     */
    private fun setRootView(activity: Activity) {
        val parent = activity.findViewById<ViewGroup>(android.R.id.content)
        run {
            var i = 0
            val count = parent.childCount
            while (i < count) {
                val childView = parent.getChildAt(i)
                if (childView is ViewGroup) {
                    childView.setFitsSystemWindows(true)
                    childView.clipToPadding = true
                }
                i++
            }
        }
    }
}

/**
 * 实验第二种xml方式的沉浸式，有人建议将V21的 文件删除掉，不然会有坑
 */
class ImmersiveActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusBarUtilKt.setImageTranslucent(this, Color.TRANSPARENT, 0)
        setContentView(R.layout.activity_immersive2)
    }


}

