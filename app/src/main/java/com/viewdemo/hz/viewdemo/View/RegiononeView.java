package com.viewdemo.hz.viewdemo.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zyand on 2019/4/17.
 */

public class RegiononeView extends View {

    Paint paint;
    Paint paintone;

    Region region;

    Region regionone;
    Region regiontwo;
    Region regionthree;

    Path path;

    Rect rect1;
    Rect rect2;

    public RegiononeView(Context context) {
        super(context);
        init();
    }

    public RegiononeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RegiononeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        //直接构造
        region = new Region(new Rect(20,20,300,300));

        //间接构造
        path = new Path();
        path.addOval(new RectF(350,20,650,500), Path.Direction.CCW);
        regionone = new Region();
        regionone.setPath(path,new Region(350,20,650,300));

        //区域相交
        regiontwo = new Region(20,400,300,500);
        regionone.union(new Rect(20,400,100,600));

        /**
         * 区域操作
         * public enum Op{
         DIFFERENCE(0),//最终区域为regionl与region2不同的区域
         INTERSECT(1),//最终区域为regionl与region2相交的区城
         UNION (2),//最终区城为regioni与region2组合在一起的区域
         XOR(3),//最终区城为regionl与region2相交之外的区域
         REVERSE_ DIFFERENCE(4),//最终区城为region2与region1不同的区城
         REPLACE(5)://最终区域为region2的区城
         ｝
         */

        rect1 = new Rect(350,500,650,600);
        rect2 = new Rect(450,400,550,700);
        regionthree = new Region(rect1);
        Region regionthrees = new Region(rect2);
        regionthree.op(regionthrees, Region.Op.INTERSECT);
        paintone = new Paint();
        paintone.setStyle(Paint.Style.FILL);
        paintone.setColor(Color.GRAY);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(rect1,paint);
        canvas.drawRect(rect2,paint);
        //构建区域方法1
        drawRegion(canvas);
        //间接构造方法
        drawRegionone(canvas);
        //相交
        drawRegiontwo(canvas);
        //区域操作
        drawRegionThree(canvas);
    }

    private void drawRegionThree(Canvas canvas) {
        RegionIterator iterator = new RegionIterator(regionthree);
        Rect r = new Rect();
        while (iterator.next(r)){
            canvas.drawRect(r,paintone);
        }
    }

    private void drawRegiontwo(Canvas canvas) {
        RegionIterator iterator = new RegionIterator(regiontwo);
        Rect r = new Rect();
        while (iterator.next(r)){
            canvas.drawRect(r,paint);
        }
    }

    private void drawRegionone(Canvas canvas) {
        RegionIterator iterator = new RegionIterator(regionone);
        Rect r = new Rect();
        while (iterator.next(r)){
            canvas.drawRect(r,paint);
        }
    }

    private void drawRegion(Canvas canvas) {
        RegionIterator iterator = new RegionIterator(region);
        Rect r = new Rect();
        while (iterator.next(r)){
            canvas.drawRect(r,paint);
        }
    }
}
