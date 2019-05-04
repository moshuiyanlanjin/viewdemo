package com.viewdemo.hz.viewdemo.activity;

import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.viewdemo.hz.viewdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zyand on 2019/4/24.
 */

public class SVGuseActivity extends BaseActivity {

    //解决23.2.0的兼容问题
    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @BindView(R.id.imag)
    ImageView imag;
    @BindView(R.id.butt)
    Button butt;
    @BindView(R.id.edit)
    EditText edit;
    @BindView(R.id.image)
    ImageView image;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_svguse);
        ButterKnife.bind(this);

        final AnimatedVectorDrawableCompat compat = AnimatedVectorDrawableCompat.create(SVGuseActivity.this, R.drawable.line_animated_vectorone);
        imag.setImageDrawable(compat);
        ((Animatable) imag.getDrawable()).start();

        //将焦点放在ImageView上
        image.setFocusable(true);
        image.setFocusableInTouchMode(true);
        image.requestFocus();
        image.requestFocusFromTouch();

        //当Edittext获取焦点时开始动画
        edit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b){
                    AnimatedVectorDrawableCompat animatedVectorDrawableCompat = AnimatedVectorDrawableCompat.create(
                            SVGuseActivity.this, R.drawable.animated_vector_search
                    );
                    image.setImageDrawable(animatedVectorDrawableCompat);
                    ((Animatable) image.getDrawable()).start();
                }
            }
        });
    }
}
