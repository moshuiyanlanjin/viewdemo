package com.viewdemo.hz.viewdemo.View;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by zyand on 2019/4/20.
 */

public class ScalseViea extends android.support.v7.widget.AppCompatTextView {
    public ScalseViea(Context context) {
        super(context);
    }

    public ScalseViea(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScalseViea(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setScalseSizex(float f){
        setScaleX(f);
    }
    public float getScalseSizex(){
        return 0.5f;
    }
}
