package com.viewdemo.hz.viewdemo.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.viewdemo.hz.viewdemo.R;

/**
 * Created by zyand on 2019/4/17.
 */

public class CustomCircleView extends View{

    private Bitmap bitmap;
    private Paint paint;
    private Path path;
    public CustomCircleView(Context context) {
        super(context);
        init();
    }

    public CustomCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        //禁用硬件加速，不然不会有任何效果
        setLayerType(LAYER_TYPE_SOFTWARE,null);

        paint = new Paint();
        path = new Path();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        paint.setColor(Color.RED);
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.banner);

        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        //缩小图片
        Matrix matrix = new Matrix();
        matrix.postScale(0.1f,0.1f);
        bitmap = Bitmap.createBitmap(bitmap,0,0,width,height,matrix,true);
        width = bitmap.getWidth();
        height = bitmap.getHeight();
        path.addCircle(width/2,height/2,Math.min(width,height)/2, Path.Direction.CCW);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.clipPath(path);
        canvas.drawBitmap(bitmap,0,0,paint);
        canvas.restore();
    }
}
