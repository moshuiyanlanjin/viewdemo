package com.viewdemo.hz.viewdemo.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.viewdemo.hz.viewdemo.R;
import com.viewdemo.hz.viewdemo.View.CustomDrawableViewe;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zyand on 2019/5/8.
 */

public class CustomDrawableActivity extends BaseActivity {

    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.tv)
    TextView tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customdrawable);
        ButterKnife.bind(this);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.avator);
        CustomDrawableViewe drawableViewe = new CustomDrawableViewe(bitmap);

        image.setImageDrawable(drawableViewe);

        tv.setBackgroundDrawable(drawableViewe);
    }
}
