package com.viewdemo.hz.viewdemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.viewdemo.hz.viewdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zyand on 2019/4/18.
 */

public class ViewAnimationOneActivity extends AppCompatActivity {

    @BindView(R.id.button)
    Button button;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.textView2)
    TextView textView2;


    Animation animation;
    @BindView(R.id.textView3)
    TextView textView3;
    @BindView(R.id.textView4)
    TextView textView4;
    @BindView(R.id.textView5)
    TextView textView5;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scaleanimationone);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.button, R.id.textView, R.id.textView2, R.id.textView3, R.id.textView4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button:

                //缩放
                animation = AnimationUtils.loadAnimation(ViewAnimationOneActivity.this, R.anim.scaleoneanim);
                textView.startAnimation(animation);

                //渐变透明
                animation = AnimationUtils.loadAnimation(ViewAnimationOneActivity.this, R.anim.alphaoneanim);
                textView2.startAnimation(animation);

                //旋转
                animation = AnimationUtils.loadAnimation(ViewAnimationOneActivity.this, R.anim.rotateoneanim);
                textView3.startAnimation(animation);

                //平移
                animation = AnimationUtils.loadAnimation(ViewAnimationOneActivity.this, R.anim.translateoneanim);
                textView4.startAnimation(animation);

                //集合
                animation = AnimationUtils.loadAnimation(ViewAnimationOneActivity.this, R.anim.setoneanim);
                textView5.startAnimation(animation);

                break;
            case R.id.textView:
                break;
            case R.id.textView2:
                break;
            case R.id.textView3:
                break;
            case R.id.textView4:

                Log.d("zlc", "点击了");
                break;
        }
    }
}
