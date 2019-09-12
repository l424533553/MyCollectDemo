package com.xunayuan.demo.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xuanyuan.library.MyToast;
import com.xunayuan.demo.R;
import com.xunayuan.demo.databinding.ItemAdapterInspectBinding;

import java.util.List;

/**
 * 作者：leavesC
 * 时间：2019/2/27 21:36
 * 描述：bingding的适配器
 * GitHub：https://github.com/leavesC
 * Blog：https://www.jianshu.com/u/9df45b87cfdf
 */
public class InspectAdapter extends RecyclerView.Adapter<InspectAdapter.UserAdapterHolder> {
    private List<String> beans;

    public InspectAdapter(List<String> beans) {
        this.beans = beans;
    }

    @NonNull
    @Override
    public UserAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemAdapterInspectBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_adapter_inspect, parent, false);
        return new UserAdapterHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapterHolder holder, int position) {
        holder.getBinding().setClassName(beans.get(position));
        holder.getBinding().setAdapter(this);
        holder.getBinding().setPosition(position);
    }


    public void onItem(View view) {
        Log.i("2222222222224444444444", "点击了项目内容");
    }

    // 点击功能
    public void onItemClick(View view, int position) {
        Log.i("2222222222224444444444", "点击了项目内容==" + position);
    }

    @Override
    public int getItemCount() {
        return beans == null ? 0 : beans.size();
    }

    /**
     * 用户的适配器
     */
    class UserAdapterHolder extends RecyclerView.ViewHolder {
        private ItemAdapterInspectBinding binding;

        UserAdapterHolder(ItemAdapterInspectBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        ItemAdapterInspectBinding getBinding() {
            return binding;
        }
    }
}
