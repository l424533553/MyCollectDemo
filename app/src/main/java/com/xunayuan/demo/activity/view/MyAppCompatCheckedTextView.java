package com.xunayuan.demo.activity.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatCheckedTextView;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 作者：罗发新
 * 时间：2019/10/14 0014    星期一
 * 邮件：424533553@qq.com
 * 说明：checkTextView 控件类似checkBox和TextView的组合
 */
public class MyAppCompatCheckedTextView extends AppCompatCheckedTextView {

    public MyAppCompatCheckedTextView(Context context) {
        super(context);
    }

    public MyAppCompatCheckedTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyAppCompatCheckedTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 方法说明
     */
    private void funExplain() {


//        1.是否选中。
        isChecked();

//        2.为一个给定的Drawable设定检查标记。当isChecked()为true时则绘制
        Drawable drawable = null;
        setCheckMarkDrawable(drawable);

//        3.为一个给定的Drawable设定检查标记，使用它的资源id来标识。当isChecked()为true时则绘制
        int resid = 0;
        setCheckMarkDrawable(resid);

//        4.改变文本视图的选中状态
          setChecked (true);

    }


}
