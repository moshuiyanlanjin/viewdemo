package com.viewdemo.hz.viewdemo.View.BezierView;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by zyand on 2019/4/30.
 */

public class BezierThreeView extends View {

    private int startx,starty,cenx,ceny,kongx,kongy,endx,endy;
    private Path path,dst;
    private Paint paint;
    private PathMeasure measure;
    float length;
    float f;
    public BezierThreeView(Context context) {
        super(context);
        init();
    }

    public BezierThreeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BezierThreeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        cenx = w/2;
        ceny = h/2;
        Log.d("ceshi",w+":"+h);
        startx = cenx - 200;
        starty = ceny;

        kongx = cenx;
        kongy = ceny - 200;

        endx = cenx + 200;
        endy = ceny;
    }

    private void init() {
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);



        ValueAnimator animator = ValueAnimator.ofFloat(0,1);
        animator.setDuration(3000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f = (float) valueAnimator.getAnimatedValue();
                postInvalidate();
            }
        });
        animator.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        path = new Path();


        path.moveTo(startx,starty);
       // path.lineTo(kongx,kongy);
        path.quadTo(kongx,kongy,endx,endy);

        measure = new PathMeasure(path,false);
        length = measure.getLength();

        dst = new Path();
        Log.d("ceshi",length*f+":"+starty);
        measure.getSegment(0,length*f,dst,true);
        canvas.drawPath(dst,paint);
    }
}
