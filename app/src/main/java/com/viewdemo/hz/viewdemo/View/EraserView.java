package com.viewdemo.hz.viewdemo.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.viewdemo.hz.viewdemo.R;

/**
 * Created by zyand on 2019/5/6.
 */

public class EraserView extends View {

    private Paint paint;

    private Bitmap bitdst,bitsrc;

    private Path path;

    private float mprex,mprey;

    public EraserView(Context context) {
        super(context);
        init();
    }

    public EraserView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public EraserView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
       // paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(45);
       /* BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;*/

        bitsrc = BitmapFactory.decodeResource(getResources(), R.mipmap.book_bg);
        Matrix matrix = new Matrix();
        matrix.postScale(4f,4f);
        bitsrc = Bitmap.createBitmap(bitsrc,0,0,bitsrc.getWidth(),bitsrc.getHeight(),matrix,true);

        bitdst = Bitmap.createBitmap(bitsrc.getWidth(),bitsrc.getHeight(),Bitmap.Config.ARGB_8888);


        path = new Path();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(event.getX(),event.getY());
                mprex =  event.getX();
                mprey = event.getY();
                return true;
            case MotionEvent.ACTION_MOVE:
                float endx = (mprex+event.getX())/2;
                float endy = (mprey + event.getY())/2;
                path.quadTo(mprex,mprey,endx,endy);
                mprey = event.getY();
                mprex = event.getX();
                break;
            case MotionEvent.ACTION_UP:

                break;
        }
        postInvalidate();
        return super.onTouchEvent(event);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int layerId = canvas.saveLayer(new RectF(0,0,getWidth(),getHeight()),null,Canvas.ALL_SAVE_FLAG);

        Canvas c = new Canvas(bitdst);
        c.drawPath(path,paint);

        canvas.drawBitmap(bitdst,0,0,paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
        canvas.drawBitmap(bitsrc,0,0,paint);
        paint.setXfermode(null);
        canvas.restoreToCount(layerId);
    }
}
