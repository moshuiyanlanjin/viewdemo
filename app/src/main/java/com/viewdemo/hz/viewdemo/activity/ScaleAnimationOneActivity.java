package com.viewdemo.hz.viewdemo.activity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;

import com.viewdemo.hz.viewdemo.R;
import com.viewdemo.hz.viewdemo.View.ScalseViea;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zyand on 2019/4/20.
 */

public class ScaleAnimationOneActivity extends BaseActivity {

    @BindView(R.id.text)
    ScalseViea text;
    @BindView(R.id.button)
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scaleanimation);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    public void onViewClicked() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(text,"ScalseSizex",6);
        animator.setDuration(3000);
        animator.setRepeatCount(ObjectAnimator.INFINITE);
        animator.start();
    }
}
