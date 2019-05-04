package com.viewdemo.hz.viewdemo.MyEvaluation;

import android.animation.TypeEvaluator;
import android.util.Log;

/**
 * Created by zyand on 2019/4/19.
 */

public class TheleEvaluation implements TypeEvaluator<Character> {
    @Override
    public Character evaluate(float v, Character integer, Character t1) {
        int startint = integer;
        int endint = t1;
        int i = (int) (startint + v * (endint - startint));
        Log.d("zlc",v+":"+i+"");
        char c = (char) i;
        return c;
    }
}
