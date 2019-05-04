package com.viewdemo.hz.viewdemo.View.ObjectAnimatorUtlis;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by zyand on 2019/4/20.
 */

public class Translationtextview extends android.support.v7.widget.AppCompatTextView {
    public Translationtextview(Context context) {
        super(context);
    }

    public Translationtextview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Translationtextview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //x轴平移
    public void setTran(float l){
        setTranslationX(l);
    }
    //旋转
    public void setRoun(float l){

        setRotation(l);
    }
    //渐变
    public void setBack(int i){
        setBackgroundColor(i);
    }
}
