package com.viewdemo.hz.viewdemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.viewdemo.hz.viewdemo.R;
import com.viewdemo.hz.viewdemo.View.BlurMaskFilterOneView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zyand on 2019/5/4.
 */

public class BlurMaskFilterOneActivity extends BaseActivity {

    @BindView(R.id.add)
    Button add;
    @BindView(R.id.clice)
    Button clice;
    @BindView(R.id.view)
    BlurMaskFilterOneView views;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluermask_one);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.add, R.id.clice})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.add:
                views.setBlur(true);
                break;
            case R.id.clice:
                views.setBlur(false);
                break;
        }
    }
}
