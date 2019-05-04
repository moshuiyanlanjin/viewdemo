package com.viewdemo.hz.viewdemo.MyEvaluation;

import android.animation.TypeEvaluator;
import android.graphics.Point;

/**
 * Created by zyand on 2019/4/19.
 */

public class SimoleEvaluation implements TypeEvaluator<Point> {
    Point points = new Point();
    @Override
    public Point evaluate(float v, Point point, Point t1) {
        points.x = (int) (point.x + v * (t1.x - point.x));
        if(v * 2 <= 1 ){
            points.y = (int) (point.y + v * 2 * (t1.y - point.y));
        }else{
            points.y = t1.y;
        }
        return points;
    }
}
