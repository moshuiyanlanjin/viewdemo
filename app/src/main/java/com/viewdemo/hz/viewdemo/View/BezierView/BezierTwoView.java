package com.viewdemo.hz.viewdemo.View.BezierView;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * Created by zyand on 2019/4/29.
 */

public class BezierTwoView extends View {

    private Path path;

    private Paint paint;

    private Paint paintone;

    private Path pathone;

    private int lenght = 1800;

    private int mItemWaveLenght = 1200;
    private int dx;

    private int ti;
    public BezierTwoView(Context context) {
        super(context);
        init();
    }

    public BezierTwoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BezierTwoView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        startAnim();
        paint = new Paint();

        paint.setStrokeWidth(5);

        paint.setColor(Color.GREEN);

        paint.setStyle(Paint.Style.FILL);

        path = new Path();

        paintone = new Paint();

        paintone.setStyle(Paint.Style.FILL);
        paintone.setColor(0xFF54FF9F);
        paintone.setStrokeWidth(5);
        pathone = new Path();

    }

    private void startAnim() {

        ValueAnimator animator = ValueAnimator.ofInt(0,mItemWaveLenght);
        animator.setDuration(3000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                dx = (int) valueAnimator.getAnimatedValue();
                postInvalidate();
            }
        });
        animator.start();

        ValueAnimator animator1 = ValueAnimator.ofInt(0,lenght);
        animator1.setInterpolator(new LinearInterpolator());
        animator1.setDuration(2000);
        animator1.setRepeatCount(ValueAnimator.INFINITE);
        animator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ti = (int) valueAnimator.getAnimatedValue();
                postInvalidate();
            }
        });
        animator1.start();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        path.reset();

        int originY = 600;

        int hanlfWaveLen = mItemWaveLenght/2;
        path.moveTo(-mItemWaveLenght+dx,originY);

        for (int i = -mItemWaveLenght;i<=getWidth()+mItemWaveLenght;i+=mItemWaveLenght){
            path.rQuadTo(hanlfWaveLen/2,-100,hanlfWaveLen,0);
            path.rQuadTo(hanlfWaveLen/2,100,hanlfWaveLen,0);
        }
        path.lineTo(getWidth(),getHeight());
        path.lineTo(0,getHeight());
        path.close();
        canvas.drawPath(path,paint);

        pathone.reset();
        int y = 800;
        int x = lenght/2;

        pathone.moveTo(-lenght+ti,y);

        for (int j = -lenght;j < getWidth()+lenght;j += lenght){
            pathone.rQuadTo(x/2,-50,x,0);
            pathone.rQuadTo(x/2,50,x,0);

        }
        pathone.lineTo(getWidth(),getHeight());
        pathone.lineTo(0,getHeight());
        pathone.close();
        canvas.drawPath(pathone,paintone);
    }
}
