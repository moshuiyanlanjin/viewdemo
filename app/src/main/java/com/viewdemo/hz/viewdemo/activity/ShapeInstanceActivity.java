package com.viewdemo.hz.viewdemo.activity;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.TextView;

import com.viewdemo.hz.viewdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zyand on 2019/5/8.
 */

public class ShapeInstanceActivity extends BaseActivity {

    @BindView(R.id.add_shape_corner)
    Button addShapeCorner;
    @BindView(R.id.shape_tv)
    TextView shapeTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shape_instance);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.add_shape_corner)
    public void onViewClicked() {
        GradientDrawable drawable = (GradientDrawable) shapeTv.getBackground();
        drawable.setCornerRadius(20);
    }
}
