package com.xunayuan.demo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.xunayuan.demo.R
import com.xunayuan.demo.activity.view.CheckTextViewFragment
import com.xunayuan.demo.config.IIntentConstants.*

class WhatsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_whats)
        init()
    }

    private fun init() {
        val fragmentManager = supportFragmentManager
        val intentType = intent.getStringExtra(INTENT_JUMP2_TYPE)
        val jump2Type = intent.getStringExtra(INTENT_JUMP2_VIEW_TYPE)
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()
        val fragment: Fragment? = decideWhatFragment(jump2Type)
        if (fragment != null) {
            transaction.add(R.id.fragmentLayout, fragment)
            transaction.commit()
        }
    }

    /**
     * 决定最终跳转到那个Fragment
     */
    private fun decideWhatFragment(jump2Type: String): Fragment? {
        // CheckTextView 控件Fragment
        when (jump2Type) {
            INTENT_JUMP2_CHECK_TEXT_VIEW -> return CheckTextViewFragment()
            else -> return null
        }

    }


}
