package com.viewdemo.hz.viewdemo.View;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.viewdemo.hz.viewdemo.App.MyApp;

/**
 * Created by zyand on 2019/4/17.
 * /**
 * Created by zyand on 2019/4/16.
 * //普通设里
 paint.setStrokeWidth (5);//设里画笔宽度
 paint.setAntiAlias(true);     //指定是否使用抗锯齿功能。如果使用，则会使绘图速度变慢
 paint.:etstyie(Paiot.styie.FILL);setStyle(Paint.Style.FILL);//绘图样式，对于文字和几何图形都有效
 paint.setTextAlign(Align.CENTER);//设置文字对齐方式，取值为Align.CENTER.
 //Align.LEFT或Align. RIGHT
 paint.setTextsize(12);setTextSize(12);//设里文字火小
 //样式设置
 paint.setFakeBoldText(true);//设置是否为粗体文字
 paint.setUnderlineText(true); //设置下画线
 paint.setTextSkewX((float)-0.25);//设里宇体水平倾料度，普通料体字设为-0.25
 paint.setStrikeThruText(true); //设里带有删除线效果

 //其他设置
 paint. setTextScaleX(2);//只会将水平方向拉伸.高度不会变

 *
 */

public class Textoneview extends View {

    private Paint paint;

    private Paint paintone;

    private float[] places = {200,200,40,600,300,400,80,450,450,820,760,385,999,999};

    private Paint painttwo;
    public Textoneview(Context context) {
        super(context);
        init();
    }

    public Textoneview(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Textoneview(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(40);
        //横向拉长
        paint.setTextScaleX(2);
        paint.setColor(Color.RED);
        //下划线
        paint.setUnderlineText(true);
        //使用锯齿功能
        paint.setAntiAlias(true);
        //这里可以设置画笔宽度
        paint.setStrokeWidth(5);
        //粗体
        paint.setFakeBoldText(true);

        paintone = new Paint();
        paintone.setFakeBoldText(true);
        paintone.setAntiAlias(true);
        paintone.setTextSize(60);
        paintone.setFakeBoldText(true);
        paintone.setColor(Color.DKGRAY);
        paintone.setTextSkewX(-0.25f);
        paintone.setStrokeWidth(3);
        paintone.setStyle(Paint.Style.STROKE);


        /**
         *自定义字体：
         * Typeface.createFromAsset(assets, "fonts/yzqs.ttf");
         *Typeface.createFromFile
         */
        AssetManager assets = MyApp.context.getAssets();
        Typeface fromAsset = Typeface.createFromAsset(assets, "fonts/yzqs.ttf");
        paintone.setTypeface(fromAsset);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText("春风不度玉门关",20,50,paint);
        canvas.drawPosText("隔江犹唱后庭花",places,paintone);
    }
}
