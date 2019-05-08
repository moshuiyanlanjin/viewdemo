package com.viewdemo.hz.viewdemo.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.viewdemo.hz.viewdemo.R;

/**
 * Created by zyand on 2019/5/8.
 */

public class TelescopeoneView extends View {


    private Bitmap bitmap;

    private int banjing = 90;

    private int beishu = 3;

    private ShapeDrawable shapeDrawable;

    private BitmapShader bitmapShader;

    private Matrix matrix = new Matrix();

    public TelescopeoneView(Context context) {
        super(context);
        init();
    }

    public TelescopeoneView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TelescopeoneView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setLayerType(LAYER_TYPE_SOFTWARE,null);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x= (int) event.getX();
        int y = (int) event.getY();
        Log.d("ceshi","x:"+x+"y:"+y+"banjing-beishu*x:"+(banjing-beishu*x)+"banjing-y*beishu"+(banjing-y*beishu));
        matrix.setTranslate(banjing-beishu*x,banjing-y*beishu);
        shapeDrawable.getPaint().getShader().setLocalMatrix(matrix);
        shapeDrawable.setBounds(x-banjing,y-banjing,x+banjing,y+banjing);
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(bitmap == null) {
            bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.scenery);
            bitmap = Bitmap.createScaledBitmap(bitmap, getWidth(), getHeight(), false);
            bitmapShader = new BitmapShader(Bitmap.createScaledBitmap(bitmap,bitmap.getWidth()*beishu,bitmap.getHeight()*beishu,true), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            shapeDrawable = new ShapeDrawable(new OvalShape());
            shapeDrawable.getPaint().setShader(bitmapShader);
            shapeDrawable.setBounds(new Rect(0,0,banjing*2,banjing*2));
        }
        canvas.drawBitmap(bitmap,0,0,null);
        shapeDrawable.draw(canvas);
    }
}
