package com.viewdemo.hz.viewdemo.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.viewdemo.hz.viewdemo.R;

/**
 * Created by zyand on 2019/5/4.
 */

public class BitmapShaderView extends View {

    private Paint paint;

    private Bitmap bitmap;

    public BitmapShaderView(Context context) {
        super(context);
        init();
    }

    public BitmapShaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BitmapShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.longes);
        paint.setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT,Shader.TileMode.REPEAT));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(0,0,getWidth(),getHeight(),paint);
    }
}
