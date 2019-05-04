package com.viewdemo.hz.viewdemo.View.TextDemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Rect;
import android.graphics.SumPathEffect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by zyand on 2019/4/24.
 */

public class TextViewDemooneView extends View {

    private Paint paint;

    private Paint textpaint;

    private Path path;

    private int baseLinex = 0;

    private int baseLineY = 200;

    int height;

    int width;

    public TextViewDemooneView(Context context) {
        super(context);
        init();
    }

    public TextViewDemooneView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextViewDemooneView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.RED);
       // paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(50);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setDither(true);
        path = new Path();
        path.moveTo(300,300);
        path.lineTo(300,600);
        path.lineTo(600,600);


        textpaint = new Paint();
        textpaint.setColor(Color.RED);
        textpaint.setTextSize(100);
        textpaint.setTextAlign(Paint.Align.LEFT);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


       // canvas.drawLine(baseLinex,300,300,300,paint);
        canvas.drawPath(path,paint);

        canvas.drawText("男儿何不带吴钩，\n夺取关山五十州",baseLinex,200,textpaint);

        Paint.FontMetrics fm = textpaint.getFontMetrics();
        float ascent = fm.ascent+baseLineY;
        float descent = fm.descent + baseLineY;
        float top = fm.top + baseLineY;
        float bottom = fm.bottom + baseLineY;

        textpaint.setColor(Color.RED);
        canvas.drawLine(baseLinex,baseLineY,3000,baseLineY,textpaint);

        textpaint.setColor(Color.BLUE);
        canvas.drawLine(baseLinex,ascent,3000,ascent,textpaint);

        textpaint.setColor(Color.GREEN);
        canvas.drawLine(baseLinex,descent,3000,descent,textpaint);

        textpaint.setColor(Color.CYAN);
        canvas.drawLine(baseLinex,top,3000,top,textpaint);

        textpaint.setColor(Color.GRAY);
        canvas.drawLine(baseLinex,bottom,3000,bottom,textpaint);

        height = (int) (bottom - top);

        width = (int) textpaint.measureText("男儿何不带吴钩，\n夺取关山五十州");

    }

    /**
     * 获取指定字符串所对应的最小矩形，以（0,0）所在的位置为基线
     * @param text
     * @param start
     * @param end
     * @param bounds
     */
    public void getTextBounds(String text, int start, int end, Rect bounds){
        textpaint.getTextBounds(text,start,end,bounds);
        Log.d("ceshi",bounds.toShortString());
    }


}
