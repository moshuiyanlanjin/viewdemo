package com.viewdemo.hz.viewdemo.View;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
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

public class BlurMaskFilterOneView extends View {

    private Paint paint;

    private Bitmap bitmap;

    private Boolean blur = false;

    public BlurMaskFilterOneView(Context context) {
        super(context);
        init();
    }

    public BlurMaskFilterOneView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BlurMaskFilterOneView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void setBlur(Boolean blur){
        this.blur = blur;
    }
    private void init() {
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        paint = new Paint();
        paint.setStrokeWidth(40);
        paint.setColor(Color.RED);
        paint.setTextSize(30);


    }

    @SuppressLint("CheckResult")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (blur){
           paint.setMaskFilter(new BlurMaskFilter(50, BlurMaskFilter.Blur.INNER));
           postInvalidate();
        }else{
      //      paint.setMaskFilter(new BlurMaskFilter(0, BlurMaskFilter.Blur.INNER));
           // postInvalidate();
        }
        canvas.drawCircle(300,300,200,paint);
        canvas.drawText("神经",100,100,paint);
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.longes);
        Bitmap bitmaps = bitmap.extractAlpha();
        int width = 200;
        int height = width * bitmap.getWidth()/bitmap.getHeight();
        paint.setColor(Color.GRAY);
        paint.setMaskFilter(new BlurMaskFilter(10, BlurMaskFilter.Blur.NORMAL));
        canvas.drawBitmap(bitmaps,null,new Rect(10,10,width,height),paint);

        canvas.translate(-10,-10);
        paint.setMaskFilter(null);
        canvas.drawBitmap(bitmap,null,new Rect(10,10,width,height),paint);

        canvas.translate(width,0);
        paint.setColor(Color.BLACK);
        canvas.drawBitmap(bitmaps,null,new Rect(10,10,width,height),paint);
        canvas.drawBitmap(bitmap,600,600,paint);
    }
}
