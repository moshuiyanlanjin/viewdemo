package com.viewdemo.hz.viewdemo.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.viewdemo.hz.viewdemo.R;

/**
 * Created by zyand on 2019/5/5.
 */

public class AvatorView extends View {

    private Bitmap bitmap;

    private Paint paint;

    private BitmapShader bitmapShader;

    public AvatorView(Context context) {
        super(context);
        init();
    }

    public AvatorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AvatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        paint = new Paint();
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.banner);
        bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP,Shader.TileMode.CLAMP);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Matrix matrix = new Matrix();
        float scale = (float) getWidth()/bitmap.getWidth();
        Log.d("ceshi","suofang"+scale);
        matrix.setScale(scale,scale);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);

        float helf = getWidth()/4;
        canvas.drawCircle(helf,helf,getWidth()/4,paint);
    }
}
