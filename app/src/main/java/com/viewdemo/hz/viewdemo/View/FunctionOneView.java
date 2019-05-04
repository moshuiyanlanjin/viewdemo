package com.viewdemo.hz.viewdemo.View;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by zyand on 2019/4/22.
 */

public class FunctionOneView extends View {

    float f;
    PathMeasure measure;
    Paint paint;
    Path dst;

    public FunctionOneView(Context context) {
        super(context);
        init();
    }

    public FunctionOneView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FunctionOneView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setLayerType(LAYER_TYPE_SOFTWARE,null);

        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(8);
        paint.setStyle(Paint.Style.STROKE);

        Path path = new Path();
       /* path.moveTo(0,0);
        path.lineTo(0,100);
        path.lineTo(100,100);
        path.lineTo(100,0);*/

       /*path.addRect(new RectF(300,300,400,400), Path.Direction.CCW);

       path.addRect(new RectF(200,200,500,500), Path.Direction.CCW);*/

      /* path.addRect(new RectF(100,100,600,600), Path.Direction.CCW);

       Path dst = new Path();

        dst.moveTo(20,60);
        dst.lineTo(200,300);

        PathMeasure measure = new PathMeasure(path,false);

        measure.getSegment(100,650,dst,false);
       // PathMeasure measure1 = new PathMeasure(path,true);


        Log.d("ceshi","measure1:"+measure.getLength());

        do {
            Log.d("ceshi","measure:"+measure.getLength());
        }while (measure.nextContour());

        canvas.drawPath(dst,paint);*/

        path.addCircle(100,100,50, Path.Direction.CCW);

        measure = new PathMeasure(path,false);
        dst = new Path();

        ValueAnimator animator = ValueAnimator.ofFloat(0,1);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f = (float) valueAnimator.getAnimatedValue();

                invalidate();
            }
        });

        animator.setDuration(3000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);



        Log.d("ceshi",Math.abs(0.1-0.5)+"");
        dst.reset();
        measure.getSegment((float) (measure.getLength()*f-(0.5 - Math.abs(f-0.5))*measure.getLength()),measure.getLength()*f,dst,true);

        canvas.drawPath(dst,paint);
    }
}
