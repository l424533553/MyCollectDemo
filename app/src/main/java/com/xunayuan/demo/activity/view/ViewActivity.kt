package com.xunayuan.demo.activity.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.LinearLayoutManager
import com.xuanyuan.library.adapter.AdvertiseLinearLayoutManager

import com.xunayuan.demo.R
import com.xunayuan.demo.activity.WhatsActivity
import com.xunayuan.demo.adapter.InspectAdapter
import com.xunayuan.demo.adapter.OnItemClickListener
import com.xunayuan.demo.config.IIntentConstants
import com.xunayuan.demo.config.IIntentConstants.INTENT_JUMP2_TYPE_VIEW
import com.xunayuan.demo.data.HomeData
import com.xunayuan.demo.databinding.ActivityViewBinding

class ViewActivity : AppCompatActivity(), OnItemClickListener<String>, IIntentConstants {
    override fun onItemClick(t: String) {
        val intent = Intent()
        val intentExtra = map[t]
        if (intentExtra != null) {
            intent.setClass(context, WhatsActivity::class.java)
            intent.putExtra(IIntentConstants.INTENT_JUMP2_TYPE, INTENT_JUMP2_TYPE_VIEW)
            intent.putExtra(IIntentConstants.INTENT_JUMP2_VIEW_TYPE, intentExtra)
            startActivity(intent)
        }
    }

    //数据源
    private val data = ObservableArrayList<String>()
    private lateinit var binding: ActivityViewBinding
    private lateinit var map: Map<String, String>
    private lateinit var context: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view)
        context = this
        initData()
    }

    private fun initData() {
        data.clear()
        map = HomeData.getViewActivityData()
        data.addAll(map.keys)
        val linearLayoutManager = AdvertiseLinearLayoutManager(context)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.homeList.layoutManager = linearLayoutManager

        val adapter = InspectAdapter(data)
        adapter.setOnItemClickListener(this)
        binding.homeList.adapter = adapter
    }
}
