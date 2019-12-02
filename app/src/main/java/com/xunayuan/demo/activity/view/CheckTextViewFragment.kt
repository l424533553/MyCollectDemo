package com.xunayuan.demo.activity.view

import android.content.Context
import android.os.Bundle
import android.util.SparseBooleanArray
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil

import com.xunayuan.demo.R
import com.xunayuan.demo.databinding.FragmentCheckTextViewBinding
import kotlinx.android.synthetic.main.fragment_check_text_view.*
import java.util.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class CheckTextViewFragment : Fragment(), View.OnClickListener {
    private var param1: String? = null
    private var param2: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private lateinit var binding: FragmentCheckTextViewBinding
    private var mContext: Context? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_check_text_view, container, false)
        binding.listener = this
        mContext = context
        initData()
        return binding.root
    }

    private fun initData() {
        val mData = ArrayList<String>()
        for (i in 0..4) {
            mData.add("item$i")
        }

        //通过listView设置模式  CHOICE_MODE_SINGLE（单选模式）
        binding.listView.choiceMode = AbsListView.CHOICE_MODE_MULTIPLE

        // 或者使用系统默认的布局 ，布局只决定显示样式，不决定是是单选还是复选模式
        // android.R.layout.simple_list_item_single_choice  显示的是圆的选择框
        // android.R.layout.simple_list_item_multiple_choice    显示的是方框的选择框
        if (context != null) {
            val mContext = context as Context
            val adapter = ArrayAdapter<String>(mContext, R.layout.item_checked_textview)
            adapter.addAll(mData)
            listView.adapter = adapter
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.checkbox2 -> {
                //反转当前视图的选中状态,选中变为不可选不可选变为可选
                binding.checkbox2.toggle()
                //在单选模式下获取被选中的item的索引index
                tvCheckCount.text = "选中的索引" + listView.checkedItemPosition
            }
            R.id.checkbox3 -> {
                binding.checkbox3.toggle()
                // 在复选模式下获取item的选中Boolean集
                tvCheckCount.text = "选中的数组" + listView.checkedItemPositions.size()
            }
            else -> println("未知类型无法判断")
        }
    }
}
