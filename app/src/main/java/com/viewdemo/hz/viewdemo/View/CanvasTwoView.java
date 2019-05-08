package com.viewdemo.hz.viewdemo.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by zyand on 2019/5/7.
 */

public class CanvasTwoView extends View {
    private Paint paint;
    public CanvasTwoView(Context context) {
        super(context);
        init();
    }

    public CanvasTwoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CanvasTwoView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        paint = new Paint();

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int id1 = canvas.save();
        canvas.clipRect(0,0,800,800);
        canvas.drawColor(Color.RED);
        Log.d("ceshi","count:"+canvas.getSaveCount()+"id1:"+id1);

        int id2 = canvas.saveLayer(0, 0, getWidth(), getHeight(), paint);
        canvas.clipRect(100,100,700,700);
        canvas.drawColor(Color.GREEN);
        Log.d("ceshi","count:"+canvas.getSaveCount()+"id2:"+id2);

        int id3 = canvas.saveLayer(0, 0, getWidth(), getHeight(), paint);
        canvas.clipRect(200,200,600,600);
        canvas.drawColor(Color.YELLOW);
        Log.d("ceshi","count:"+canvas.getSaveCount()+"id3:"+id3);

        int id4 = canvas.saveLayer(0, 0, getWidth(), getHeight(), paint);
        canvas.clipRect(300,300,500,500);
        canvas.drawColor(Color.BLUE);
        Log.d("ceshi","count:"+canvas.getSaveCount()+"id4:"+id4);

       // canvas.restoreToCount(id3);
        //canvas.drawColor(Color.BLACK);
        canvas.restore();
        canvas.clipRect(0,0,600,600);
        canvas.drawColor(Color.BLACK);
    }
}
