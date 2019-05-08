package com.viewdemo.hz.viewdemo.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.viewdemo.hz.viewdemo.R;

/**
 * Created by zyand on 2019/5/4.
 */

public class TelescopeView extends View {

    private Paint paint;

    private Bitmap bitmap,mbitmap;

    private int dx=-1,dy=-1;

    public TelescopeView(Context context) {
        super(context);
        init();
    }

    public TelescopeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TelescopeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        paint = new Paint();
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.bj);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                dx = (int) event.getX();
                dy = (int) event.getY();
                postInvalidate();
                return true;
            case MotionEvent.ACTION_MOVE:
                dx = (int) event.getX();
                dy = (int) event.getY();
                postInvalidate();
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                dx  = -1;
                dy = -1;
                break;
        }
        return super.onTouchEvent(event);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mbitmap == null){
            mbitmap = Bitmap.createBitmap(getWidth(),getHeight(),Bitmap.Config.ARGB_8888);
            Canvas canvas1 = new Canvas(mbitmap);
            canvas1.drawBitmap(bitmap,null,new Rect(0,0,getWidth(),getHeight()),paint);
        }

        if(dx != -1 && dy != -1){
            paint.setShader(new BitmapShader(mbitmap, Shader.TileMode.REPEAT,Shader.TileMode.REPEAT));
            canvas.drawCircle(dx,dy,150,paint);
        }
    }
}
