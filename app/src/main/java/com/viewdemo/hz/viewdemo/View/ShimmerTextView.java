package com.viewdemo.hz.viewdemo.View;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.LinearInterpolator;

import com.viewdemo.hz.viewdemo.App.MyApp;
import com.viewdemo.hz.viewdemo.R;

/**
 * Created by zyand on 2019/5/5.
 * 闪光文字
 */

public class ShimmerTextView extends android.support.v7.widget.AppCompatTextView {

    private Paint paint;

    private LinearGradient linearGradient;

    private int dx;

    public ShimmerTextView(Context context) {
        super(context);
        init(context, null);
    }

    public ShimmerTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public ShimmerTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        paint = getPaint();
        int linte = (int) paint.measureText(getText().toString());
        createAnimter(linte);
        createLinearGradient(linte);

        //自定义数值获取
        if(attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ShimmerTextView);
            float headerheigh = typedArray.getDimension(R.styleable.ShimmerTextView_headerheight, -1);
            int age = typedArray.getInt(R.styleable.ShimmerTextView_age, -1);
            typedArray.recycle();

            Log.d("ceshi","age:"+age+"headeheight:"+headerheigh);
        }
    }

    private void createLinearGradient(int linte) {

        linearGradient = new LinearGradient(-linte,0,0,0,new int[]{getCurrentTextColor(),0xffff0000,0xff00ff00,0xff0000ff,0xff008800,getCurrentTextColor()},new float[]{0,0.2f,0.4f,0.6f,0.8f,1}, Shader.TileMode.REPEAT);

    }

    private void createAnimter(int linte) {
        ValueAnimator animator = ValueAnimator.ofInt(0,2*linte);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                dx = (int) valueAnimator.getAnimatedValue();
                postInvalidate();
            }
        });
        animator.setDuration(2000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        animator.start();
    }


    @Override
    protected void onDraw(Canvas canvas) {

        AssetManager assets = MyApp.context.getAssets();
        Typeface fromAsset = Typeface.createFromAsset(assets, "fonts/yzqs.ttf");
        paint.setTypeface(fromAsset);


        Matrix matrix = new Matrix();
        matrix.postTranslate(dx,0);
        linearGradient.setLocalMatrix(matrix);
        paint.setShader(linearGradient);
        super.onDraw(canvas);
    }
}
