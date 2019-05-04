package com.viewdemo.hz.viewdemo.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.viewdemo.hz.viewdemo.R;

/**
 * Created by zyand on 2019/5/4.
 */

public class ShadowLayerView extends View {

    private Paint paint;
    private Bitmap bitmap;
    private Boolean msetshadow = false;
    public ShadowLayerView(Context context) {
        super(context);
        init();
    }

    public ShadowLayerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ShadowLayerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(30);

        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.yuan);
    }

    public void setShadow(boolean showShadow){
        msetshadow = showShadow;
        postInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
       // canvas.drawBitmap(bitmap,200,200,paint);

        if(msetshadow){
            paint.setShadowLayer(10,10,10,Color.GRAY);
        }else{
            paint.clearShadowLayer();
        }
        canvas.drawText("多情",100,100,paint);
        canvas.drawCircle(300,100,50,paint);
        canvas.drawBitmap(bitmap,null,new Rect(500,50,500+bitmap.getWidth(),50+bitmap.getHeight()),paint);
    }
}
