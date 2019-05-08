package com.viewdemo.hz.viewdemo.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zyand on 2019/5/5.
 */

public class RadialgradientView extends View {

    private Paint paint;

    private RadialGradient radialGradient;

    private int radio;

    public RadialgradientView(Context context) {
        super(context);
        init();
    }

    public RadialgradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RadialgradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(radialGradient == null){
            radio = Math.min(getWidth()/6,getHeight()/6);
            radialGradient = new RadialGradient(getWidth()/2,getHeight()/2,radio,new int[]{0xffff0000,0xff800800,0xff0000ff},new float[]{0,0.5f,1}, Shader.TileMode.MIRROR);
            paint.setShader(radialGradient);
        }
        canvas.drawCircle(getWidth()/2,getHeight()/2,Math.min(getWidth()/2,getHeight()/2),paint);
    }
}
