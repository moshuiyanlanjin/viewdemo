package com.viewdemo.hz.viewdemo.View.ObjectAnimatorUtlis;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by zyand on 2019/4/20.
 */

public class BackgroundtextView extends android.support.v7.widget.AppCompatTextView {
    public BackgroundtextView(Context context) {
        super(context);
    }

    public BackgroundtextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BackgroundtextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public void setBackgroundtextcolor(int color){
        setBackgroundColor(color);
    }
    public void setTan(float f){
        setTranslationX(f);
    }
}
