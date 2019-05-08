package com.viewdemo.hz.viewdemo.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.viewdemo.hz.viewdemo.R;

/**
 * Created by zyand on 2019/4/17.
 */

public class CliprgnView extends View {

    Paint paint;

    Path path;

    Bitmap bitmap;

   // Region region;

    int plwidth,plheigh,width,height;
    public CliprgnView(Context context) {
        super(context);
        init();
    }

    public CliprgnView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CliprgnView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {


        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.banner);
        width = bitmap.getWidth();
        height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(0.5f,0.5f);
        bitmap = Bitmap.createBitmap(bitmap,0,0,width,height,matrix,true);
        width = bitmap.getWidth();
        height = bitmap.getHeight();
      //  region = new Region();
        path = new Path();
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        path.reset();
        int i = 0;
        plheigh = 20;
        while (i*plheigh <= height){
            if(i % 2 == 1){
                //左侧的矩阵
                path.addRect(new RectF(0,plheigh*i,plwidth,plheigh*(i+1)), Path.Direction.CCW);
            }else{
                //右侧的矩阵
                path.addRect(new RectF(width-plwidth,plheigh*i,width,plheigh*(i+1)), Path.Direction.CCW);
            }
            i++;
        }
        canvas.clipPath(path);
        canvas.drawBitmap(bitmap,0,0,paint);
        if(plwidth == width){
            return;
        }
        plwidth += 5;
        invalidate();
    }
}
