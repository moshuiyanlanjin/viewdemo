package com.viewdemo.hz.viewdemo.activity;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.viewdemo.hz.viewdemo.MyEvaluation.TheleEvaluation;
import com.viewdemo.hz.viewdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zyand on 2019/4/19.
 */

public class ThelettermailActivity extends AppCompatActivity {

    @BindView(R.id.button4)
    Button button4;
    @BindView(R.id.textView11)
    TextView textView11;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thelettermail);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button4)
    public void onViewClicked() {
        ValueAnimator animator = ValueAnimator.ofObject(new TheleEvaluation(), new Character('A'),new Character('Z'));

        animator.setDuration(3000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        /*animator.setDuration(ValueAnimator.RESTART);*/

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                char animatedValue = (Character) valueAnimator.getAnimatedValue();
                Log.d("zlc",animatedValue+"");
                textView11.setText(String.valueOf(animatedValue));
            }
        });

        animator.start();
    }
}
