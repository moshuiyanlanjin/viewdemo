package com.viewdemo.hz.viewdemo.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zyand on 2019/5/5.
 */

public class LinearGradientView extends View {

    private Paint paint;


    public LinearGradientView(Context context) {
        super(context);
        init();
    }

    public LinearGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LinearGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

        setLayerType(LAYER_TYPE_SOFTWARE,null);
        paint = new Paint();
        paint.setTextSize(70);
        paint.setStrikeThruText(true);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int[] colors = {0xffff0000,0xff00ff00,0xff0000ff,0xffffa500,0xff800080};
        float[] pos = {0f,0.2f,0.4f,0.6f,1f};
        //双色渐变
        //paint.setShader(new LinearGradient(0,0,getWidth(),getHeight(),0xffff0000,0xff00ff00, Shader.TileMode.CLAMP));
        //多色渐变
        paint.setShader(new LinearGradient(0,0,getWidth(),getHeight(),colors,pos, Shader.TileMode.MIRROR));
        canvas.drawText("Android",100,100,paint);
       // canvas.drawRect(0,0,getWidth(),getHeight(),paint);
    }
}
