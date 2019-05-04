package com.viewdemo.hz.viewdemo.View;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by zyand on 2019/4/23.
 */

public class AliPlayView extends View {

    private Paint paint;

    private Path path,dst;

    private PathMeasure measure;

    private Matrix matrix;

    private float f;

    public AliPlayView(Context context) {
        super(context);
        init();
    }

    public AliPlayView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AliPlayView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

        setLayerType(LAYER_TYPE_SOFTWARE,null);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStrokeWidth(8);
        paint.setColor(Color.MAGENTA);
        paint.setStyle(Paint.Style.STROKE);

        path = new Path();
        path.addCircle(400,400,300, Path.Direction.CW);

        path.moveTo(400-300/2,400);
        path.lineTo(400,400+300/2);
        path.lineTo(400+300/2,400-300/3);

        measure = new PathMeasure(path,false);

        dst = new Path();

        ValueAnimator animator = ValueAnimator.ofFloat(0,2);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f = (float) valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
        animator.setDuration(4000);
        animator.start();
    }

    boolean mNext = false;
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.WHITE);


        if(f < 1){
            float length = measure.getLength();
           measure.getSegment(0,length*f,dst,true);
        }else {
            if(!mNext){
                mNext = true;
                measure.getSegment(0,measure.getLength(),dst,true);
                measure.nextContour();
            }
            measure.getSegment(2,measure.getLength()*(f-1),dst,true);
        }
        canvas.drawPath(dst,paint);
    }
}
