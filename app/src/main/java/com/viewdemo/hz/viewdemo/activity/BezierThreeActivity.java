package com.viewdemo.hz.viewdemo.activity;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.viewdemo.hz.viewdemo.R;
import com.viewdemo.hz.viewdemo.activity.BaseActivity;


/**
 * Created by zyand on 2019/4/30.
 */

public class BezierThreeActivity extends BaseActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_bezier);
    }
}
