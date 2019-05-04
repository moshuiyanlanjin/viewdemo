package com.viewdemo.hz.viewdemo.activity;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.viewdemo.hz.viewdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zyand on 2019/4/18.
 */

public class ValueAnimatoroneActivity extends AppCompatActivity {

    @BindView(R.id.button3)
    Button button3;
    @BindView(R.id.imageView6)
    ImageView imageView6;
    @BindView(R.id.button1)
    Button button1;
    @BindView(R.id.button2)
    Button button2;

    private ValueAnimator redeanimator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valueanimator);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button3, R.id.imageView6,R.id.button1,R.id.button2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button3:
                dovalueAnimator();
                break;
            case R.id.imageView6:
                Log.d("zlc", "点钟了");
                break;
            case R.id.button1:
                redeanimator = toValueAnimator();
                break;

            case R.id.button2:
                //取消动画
                redeanimator.cancel();
                break;
        }
    }

    private ValueAnimator toValueAnimator() {
        ValueAnimator animator = ValueAnimator.ofInt(400,500,300,400);
        animator.setDuration(5000);


        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Integer value = (Integer) valueAnimator.getAnimatedValue();
                imageView6.layout(value,value,value+imageView6.getWidth(),value+imageView6.getHeight());

            }
        });
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.start();
        return animator;
    }

    private void dovalueAnimator() {

        ValueAnimator animator = ValueAnimator.ofInt(0, 400);

        animator.setDuration(3000);
        animator.start();

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int animatedValue = (int) valueAnimator.getAnimatedValue();
                imageView6.layout(animatedValue, animatedValue, animatedValue + imageView6.getWidth(), animatedValue + imageView6.getHeight());
            }
        });
    }
}
