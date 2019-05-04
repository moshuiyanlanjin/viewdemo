package com.viewdemo.hz.viewdemo.activity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.viewdemo.hz.viewdemo.MyEvaluation.SimoleEvaluation;
import com.viewdemo.hz.viewdemo.R;
import com.viewdemo.hz.viewdemo.View.simpleparbolocview;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zyand on 2019/4/19.
 */

public class SimpleparabolicActivity extends AppCompatActivity {

    @BindView(R.id.button5)
    Button button5;
    @BindView(R.id.imageView7)
    ImageView imageView7;
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.yuan)
    simpleparbolocview yuan;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simpleparabolic);
        ButterKnife.bind(this);
    }



    @OnClick({R.id.button5, R.id.button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button5:
                ValueAnimator animator = ValueAnimator.ofObject(new SimoleEvaluation(), new Point(0, 0), new Point(500, 500));
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        Point point = (Point) valueAnimator.getAnimatedValue();
                        imageView7.layout(point.x, point.y, point.x + imageView7.getWidth(), point.y + imageView7.getHeight());
                    }
                });
                animator.setDuration(3000);
                animator.start();
                break;
            case R.id.button:
                Log.d("zlc", "点击了");
                ObjectAnimator animator1 = ObjectAnimator.ofObject(yuan, "simpleparabolic", new SimoleEvaluation(), new Point(0, 0), new Point(500, 500));
                animator1.setDuration(3000);
                animator1.start();
                break;
        }
    }
}
