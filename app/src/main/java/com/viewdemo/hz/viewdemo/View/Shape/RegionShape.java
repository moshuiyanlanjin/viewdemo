package com.viewdemo.hz.viewdemo.View.Shape;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.graphics.drawable.shapes.Shape;

/**
 * Created by zyand on 2019/5/8.
 */

public class RegionShape extends Shape {

    private Region mRegion;
    public RegionShape(Region region) {

        mRegion = region;
    }


    @Override
    public void draw(Canvas canvas, Paint paint) {
        RegionIterator iterator = new RegionIterator(mRegion);
        Rect r = new Rect();
        while (iterator.next(r)){
         canvas.drawRect(r,paint);
        }
    }
}
