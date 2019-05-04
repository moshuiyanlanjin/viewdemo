package com.viewdemo.hz.viewdemo.View;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.viewdemo.hz.viewdemo.Interpolator.MyIntepolation;
import com.viewdemo.hz.viewdemo.MyEvaluation.MyEvaluation;
import com.viewdemo.hz.viewdemo.R;

/**
 * Created by zyand on 2019/4/18.
 */

public class ImageValueanimatorone extends android.support.v7.widget.AppCompatImageView {

    /**
     * mtop:控件top
     * mmax:共几张图片
     * mpos:当前图片下标
     */
    private int mTop,mmax = 3,mpos = 0;

    public ImageValueanimatorone(Context context) {
        super(context);
        init();
    }

    public ImageValueanimatorone(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ImageValueanimatorone(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        mTop = top;
    }

    private void init() {
        ValueAnimator animator = ValueAnimator.ofInt(0,200,0);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Integer value = (Integer) valueAnimator.getAnimatedValue();
                setTop(mTop-value);
            }
        });

        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                setImageDrawable(getResources().getDrawable(R.mipmap.longes));
            }

            @Override
            public void onAnimationEnd(Animator animator) {

            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {
                mpos++;
                switch (mpos%mmax){
                    case 0:
                        setImageDrawable(getResources().getDrawable(R.mipmap.longes));
                       break;
                    case 1:
                        setImageDrawable(getResources().getDrawable(R.mipmap.yuan));
                        break;
                    case 2 :
                        setImageDrawable(getResources().getDrawable(R.mipmap.wen));
                        break;
                }
            }
        });
        animator.setDuration(3000);
        animator.setRepeatMode(ValueAnimator.RESTART);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new MyIntepolation());
        animator.setEvaluator(new MyEvaluation());
        animator.start();
    }
}
