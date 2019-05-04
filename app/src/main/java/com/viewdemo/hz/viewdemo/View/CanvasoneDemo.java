package com.viewdemo.hz.viewdemo.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zyand on 2019/4/17.
 */

public class CanvasoneDemo extends View {

    Paint paint1;
    Paint paint2;
    Rect rect;

    public CanvasoneDemo(Context context) {
        super(context);
        init();
    }

    public CanvasoneDemo(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CanvasoneDemo(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
       paint1 = getPainth(Color.CYAN,Paint.Style.STROKE,6);
        paint2 = getPainth(Color.GREEN,Paint.Style.STROKE,6);
        rect = new Rect(20,20,200,200);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
       /* canvas.drawRect(rect,paint1);
        //平移图层
        canvas.translate(100,100);
        canvas.drawRect(rect,paint2);
        //旋转图层
        canvas.rotate(60);
        canvas.drawRect(rect,paint1);
        *//**
         * 缩放图层
         * sx:x轴缩放
         * sy：y轴缩放
         * px，px缩放中心坐标
         *//*
        canvas.scale(0.5f,1.5f);
        canvas.drawRect(rect,paint1);
        canvas.scale(0.9f,2f,100,100);
        canvas.drawRect(rect,paint2);
        *//**
         * 扭曲
         * sx:x斜切角度的正切值
         * sy：y斜切角度的正切值
         *//*
        canvas.skew(1.725f,1);
        canvas.drawRect(rect,paint2);*/
        /**
         * 剪切
         */
        canvas.drawColor(Color.RED);
        //保存状态
        int c1 = canvas.save();
        canvas.clipRect(new Rect(100,100,200,200));
        canvas.drawColor(Color.GREEN);
        //恢复画布状态，如多次sava则在执行restore的时候遵循栈先入后出的原则
        canvas.restore();
        //可直接根据save的返回值恢复对应的画布状态
        canvas.restoreToCount(c1);
        canvas.drawColor(Color.BLACK);

    }

    private Paint getPainth(int cyan, Paint.Style stroke, int i){
        Paint paint = new Paint();
        paint.setColor(cyan);
        paint.setStyle(stroke);
        paint.setStrokeWidth(i);

        return paint;
    }
}
