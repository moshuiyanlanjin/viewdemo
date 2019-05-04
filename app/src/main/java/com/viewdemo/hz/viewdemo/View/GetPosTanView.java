package com.viewdemo.hz.viewdemo.View;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

import com.viewdemo.hz.viewdemo.R;

/**
 * Created by zyand on 2019/4/23.
 */

public class GetPosTanView extends View {

    Paint paint;

    Path path;

    Path dst;

    PathMeasure measure;

    float f;

    float[] pos = new float[2];
    float[] tan = new float[2];

    Bitmap bitmap;

    public GetPosTanView(Context context) {
        super(context);
        init();
    }

    public GetPosTanView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public GetPosTanView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setLayerType(LAYER_TYPE_SOFTWARE,null);

        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.jtz);

        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(8);

        path = new Path();
        path.addCircle(300,300,200, Path.Direction.CW);

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
        float stop = measure.getLength() * f;

        dst.reset();

        measure.getSegment(0,stop,dst,true);
        canvas.drawPath(dst,paint);

        measure.getPosTan(stop,pos,tan);

        float degrees = (float) (Math.atan2(tan[1], tan[0]) * 180.0 / Math.PI);
        Matrix matrix = new Matrix();
       /* Log.d("ceshi","degrees:"+degrees);
        matrix.postRotate(degrees+180,bitmap.getWidth()/2,bitmap.getHeight()/2);
        matrix.postTranslate(pos[0] - bitmap.getWidth()/2,pos[1]-bitmap.getHeight()/2);*/

       //将原点坐标和正切值同时放入matrix数组中
       measure.getMatrix(stop,matrix,PathMeasure.POSITION_MATRIX_FLAG | PathMeasure.TANGENT_MATRIX_FLAG);
        matrix.preTranslate(-bitmap.getWidth()/2,-bitmap.getHeight()/2);

        canvas.drawBitmap(bitmap,matrix,paint);

    }
}
