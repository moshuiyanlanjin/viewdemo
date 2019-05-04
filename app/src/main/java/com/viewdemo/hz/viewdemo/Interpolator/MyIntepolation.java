package com.viewdemo.hz.viewdemo.Interpolator;

import android.animation.TimeInterpolator;

/**
 * Created by zyand on 2019/4/19.
 */

public class MyIntepolation implements TimeInterpolator {
    @Override
    public float getInterpolation(float v) {
        return 1-v;
    }
}
