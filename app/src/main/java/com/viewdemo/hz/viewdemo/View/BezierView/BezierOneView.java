package com.viewdemo.hz.viewdemo.View.BezierView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by zyand on 2019/4/29.
 */

public class BezierOneView extends View {

    Paint paint;

    Path path;

    private int enterx,entery,canterx,centery,startx,starty,endx,endy;
    private int linex = 200;

    private float mprex,mprey;

    public BezierOneView(Context context) {
        super(context);
        init();
    }

    public BezierOneView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BezierOneView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(5);
        path = new Path();
      /*  path.moveTo(100,300);
        path.quadTo(200,200,300,300);
        path.quadTo(400,400,500,300);*/
      path.moveTo(100,300);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        canterx = w/2;
        centery = h/2;
        Log.d("ceshi",w/2+":"+h/2+":"+oldh+":"+oldw);
        startx = canterx-250;
        starty = centery;
        endx = canterx + 250;
        endy = centery;
        enterx = canterx;
        entery = centery-250;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
               /* path.moveTo(event.getX(),event.getY());
                mprex = event.getX();
                mprex = event.getY();*/
                postInvalidate();
               path.quadTo(200,200,event.getX(),event.getY());

                Log.d("ceshi1",event.getX()+":"+event.getY());
                return true;
               /* case MotionEvent.ACTION_MOVE:
                    float endx = (mprex + event.getX())/2;
                    float endy = (mprey + event.getY())/2;
                    path.quadTo(endx,endy,event.getX(),event.getY());
                    mprex = event.getX();
                    mprey = event.getY();
                    Log.d("ceshi2",event.getX()+":"+event.getY());
                    postInvalidate();
                    break;*/
        }
        return super.onTouchEvent(event);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(startx,starty,10,paint);
        canvas.drawCircle(endx,endy,10,paint);
        canvas.drawCircle(enterx,entery,10,paint);

        canvas.drawLine(startx,starty,enterx,entery,paint);
        canvas.drawLine(endx,endy,enterx,entery,paint);

        path.moveTo(startx,starty);
        path.quadTo(enterx,entery,endx,endy);

        paint.setStrokeWidth(5);
        paint.setColor(0xfc123456);

        canvas.drawPath(path,paint);
     //   canvas.drawColor(Color.WHITE);
      //  canvas.drawPath(path,paint);
    }
}
