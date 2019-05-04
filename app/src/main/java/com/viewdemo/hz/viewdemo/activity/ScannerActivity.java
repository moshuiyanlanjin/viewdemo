package com.viewdemo.hz.viewdemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.viewdemo.hz.viewdemo.MainActivity;
import com.viewdemo.hz.viewdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zyand on 2019/4/18.
 */

public class ScannerActivity extends AppCompatActivity {

    @BindView(R.id.imageView1)
    ImageView imageView1;
    @BindView(R.id.imageView2)
    ImageView imageView2;
    @BindView(R.id.imageView3)
    ImageView imageView3;
    @BindView(R.id.imageView4)
    ImageView imageView4;
    @BindView(R.id.imageView5)
    ImageView imageView5;


    Animation animation1;
    Animation animation2;
    Animation animation3;
    Animation animation4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {

        animation1 = AnimationUtils.loadAnimation(ScannerActivity.this,R.anim.scanneranim);
        animation2 = AnimationUtils.loadAnimation(ScannerActivity.this,R.anim.scanneranim);
        animation3 = AnimationUtils.loadAnimation(ScannerActivity.this,R.anim.scanneranim);
        animation4 = AnimationUtils.loadAnimation(ScannerActivity.this,R.anim.scanneranim);


    }

    @OnClick(R.id.imageView5)
    public void onViewClicked() {
        //animation.setStartOffset(600);
        imageView4.startAnimation(animation1);

        animation2.setStartOffset(600);
        imageView3.startAnimation(animation2);

        animation3.setStartOffset(1200);
        imageView2.startAnimation(animation3);

        animation4.setStartOffset(1800);
        imageView1.startAnimation(animation4);
    }
}
