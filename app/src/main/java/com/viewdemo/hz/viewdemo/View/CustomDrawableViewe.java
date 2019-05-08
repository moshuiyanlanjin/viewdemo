package com.viewdemo.hz.viewdemo.View;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by zyand on 2019/5/8.
 */

public class CustomDrawableViewe extends Drawable {
    private Paint paint;

    private Bitmap bitmap;

    private BitmapShader bitmapShader;

    private RectF rectF;

    public CustomDrawableViewe(Bitmap bitmap){

        this.bitmap = bitmap;
        paint = new Paint();
        paint.setAntiAlias(true);

    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        canvas.drawRoundRect(rectF,20,20,paint);
    }

    @Override
    public void setAlpha(int alpha) {
        paint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        paint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

    @Override
    public void setBounds(int left, int top, int right, int bottom) {
        super.setBounds(left, top, right, bottom);
        bitmapShader = new BitmapShader(Bitmap.createScaledBitmap(bitmap,right-left,bottom-top,true), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        paint.setShader(bitmapShader);
        rectF = new RectF(left,top,right,bottom);
    }

    @Override
    public int getIntrinsicHeight() {
        return bitmap.getHeight();
    }

    @Override
    public int getIntrinsicWidth() {
        return bitmap.getWidth();
    }
}

