package com.xunayuan.demo.activity

import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.xuanyuan.library.MyToast
import com.xunayuan.demo.R
import com.xunayuan.demo.databinding.ActivityHomeBinding
import com.xunayuan.demo.databinding.ActivityMenuBinding

/**
 * 作者：罗发新
 * 时间：2019/10/9 0009    星期三
 * 邮件：424533553@qq.com
 * 说明：进行菜单的图片显示，进行的Menu测试
 * 常见的menu会有图标无法显示的问一般需要使用反射的方式进行处理
 *
 */
class MenuDemoActivity : AppCompatActivity() {
    private var binding: ActivityMenuBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_menu)
        setContentView(R.layout.activity_menu)
        //
    }

    /**
     * 李必达乌斯
     * 菜单按钮，时间功能
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item != null) {
            when (item.itemId) {
                R.id.item1 -> MyToast.toastShort(this, "Item")
            }
        }
        return super.onOptionsItemSelected(item)
    }

    /**
     * 点开菜单后的下一步操作动作及行为
     */
    override fun onMenuOpened(featureId: Int, menu: Menu?): Boolean {
        if (menu != null) {
            if (menu.javaClass.simpleName.equals("MenuBuilder", true)) {
                val method = menu.javaClass.getDeclaredMethod("setOptionalIconsVisible", java.lang.Boolean.TYPE)
                method.isAccessible = true
                method.invoke(menu, true)
            }
        }
        return super.onMenuOpened(featureId, menu)
    }
}