package com.viewdemo.hz.viewdemo.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.viewdemo.hz.viewdemo.R;

/**
 * Created by zyand on 2019/5/5.
 */

public class PorterDuffXfermodeView extends View {

    private Paint paint;
    
    private int width = 200,height = 200;

    private Bitmap bitmap,mbitmap;
    public PorterDuffXfermodeView(Context context) {
        super(context);
        init();
    }

    public PorterDuffXfermodeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PorterDuffXfermodeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        paint = new Paint();
        paint.setColor(Color.RED);
        bitmap = makbitmap();
        mbitmap = makmbitmap();

    }

    private Bitmap makmbitmap() {
        Bitmap bitmap = Bitmap.createBitmap(width,height,Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setColor(0xFFFFCC44);
        canvas.drawOval(new RectF(0,0,width,height),p);
        return bitmap;
    }

    private Bitmap makbitmap() {
        Bitmap bitmap = Bitmap.createBitmap(width,height,Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setColor(0xff66aaff);
        canvas.drawRect(new Rect(0,0,width,height),paint);
        return bitmap;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int layerid = canvas.saveLayer(0,0,getWidth(),getHeight(),null,Canvas.ALL_SAVE_FLAG);
       canvas.drawBitmap(mbitmap,0,0,paint);
       paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
       canvas.drawBitmap(bitmap,width/2,height/2,paint);
       paint.setXfermode(null);
       canvas.restoreToCount(layerid);
    }
}
