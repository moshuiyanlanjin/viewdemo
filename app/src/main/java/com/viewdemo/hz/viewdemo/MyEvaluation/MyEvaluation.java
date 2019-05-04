package com.viewdemo.hz.viewdemo.MyEvaluation;

import android.animation.TypeEvaluator;

/**
 * Created by zyand on 2019/4/19.
 */

public class MyEvaluation implements TypeEvaluator<Integer> {
    @Override
    public Integer evaluate(float v, Integer integer, Integer t1) {
        int startint = integer;
        return (int)(200 + startint + v*(t1-integer));
    }
}
