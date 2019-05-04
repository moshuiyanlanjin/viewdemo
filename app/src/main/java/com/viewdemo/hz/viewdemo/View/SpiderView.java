package com.viewdemo.hz.viewdemo.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zyand on 2019/4/17.
 */

public class SpiderView extends View {

    //半径
    private float radius;
    //中心点坐标
    private int x,y;

    //网格画笔
    private Paint paintw;
    //连线画笔
    private Paint paintl;

    //网格层数
    private int tier = 6;
    //网格格数
    private int metre = 6;

    //连接线的点
    private int[] lines = {3,5,4,6,2,1};
    //假设最大的长度值
    private int maxline = 6;


    public SpiderView(Context context) {
        super(context);
        init();
    }

    public SpiderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SpiderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        radius = Math.min(w,h)/2*0.9f;
        x = w/2;
        y = h/2;
    }

    private void init() {

        paintw = new Paint();
        paintw.setStrokeWidth(5);
        paintw.setColor(Color.RED);
        paintw.setStyle(Paint.Style.STROKE);

        paintl = new Paint();
        paintl.setStrokeWidth(5);
        paintl.setColor(Color.GRAY);
        paintl.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //网格
        girddingView(canvas);

        //网格分割线
        cut_off_ruleview(canvas);

        //内部连接线
        connecting_lineview(canvas);
    }

    private void connecting_lineview(Canvas canvas) {
        Path path = new Path();

        paintl.setAlpha(147);

        for (int i = 0;i < lines.length;i++){
            float gx = (float) (x + radius * Math.cos(Math.PI*2/lines.length*i)*lines[i]/maxline);
            float gy = (float) (y + radius * Math.sin(Math.PI*2/lines.length*i)*lines[i]/maxline);
            if(i == 0){
                path.moveTo(gx,y);
            }else{
                path.lineTo(gx,gy);
            }
            canvas.drawCircle(gx,gy,10,paintl);
        }
        paintl.setStyle(Paint.Style.FILL);
        canvas.drawPath(path,paintl);
    }

    private void cut_off_ruleview(Canvas canvas) {
        Path path = new Path();
        paintw.setAlpha(100);
        for (int i = 0;i<metre;i++){
            path.reset();
            path.moveTo(x,y);
            float gx = (float) (x + radius * Math.cos(Math.PI*2/metre*i));
            float gy = (float) (y + radius * Math.sin(Math.PI*2/metre*i));
            path.lineTo(gx,gy);
            canvas.drawPath(path,paintw);
        }
    }

    private void girddingView(Canvas canvas) {
        Path path = new Path();
        float r = radius/tier;
        for (int i = 1;i<=tier;i++){
            float cur = r*i;
            path.reset();
            for (int j = 0; j < metre;j++){
                if(j == 0){
                    path.moveTo(x + cur,y);
                }else{
                    float gx = (float) (x + cur * Math.cos(Math.PI*2/metre*j));
                    float gy = (float) (y + cur * Math.sin(Math.PI*2/metre*j));
                    path.lineTo(gx,gy);
                }
            }
            path.close();
            canvas.drawPath(path,paintw);
        }




    }
}
