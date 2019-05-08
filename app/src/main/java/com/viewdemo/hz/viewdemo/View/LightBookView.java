package com.viewdemo.hz.viewdemo.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.viewdemo.hz.viewdemo.R;

/**
 * Created by zyand on 2019/5/6.
 */

public class LightBookView extends View {

    private Paint paint;

    private Bitmap bitdis,bitsrc;
    public LightBookView(Context context) {
        super(context);
        init();
    }

    public LightBookView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LightBookView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();



    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        bitdis = BitmapFactory.decodeResource(getResources(), R.mipmap.book_bg,null);
        float width = (float)   getWidth()/bitdis.getWidth() ;
        float height = (float)  getHeight()/bitdis.getHeight() ;
        Log.d("ceshi",width+"...");
        Matrix matrix = new Matrix();
        matrix.postScale(width,height);
        bitdis = Bitmap.createBitmap(bitdis,0,0,bitdis.getWidth(),bitdis.getHeight(),matrix,true);

        bitsrc = BitmapFactory.decodeResource(getResources(),R.mipmap.book_light,null);
       // matrix.postScale(getWidth()/bitsrc.getWidth(),getHeight()/bitsrc.getHeight());
        bitsrc = Bitmap.createBitmap(bitsrc,0,0,bitsrc.getWidth(),bitsrc.getHeight(),matrix,true);

        int layerid = canvas.saveLayer(0,0,getWidth(),getHeight(),null,Canvas.ALL_SAVE_FLAG);
        canvas.drawBitmap(bitdis,0,0,paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.LIGHTEN));
        canvas.drawBitmap(bitsrc,0,0,paint);
        paint.setXfermode(null);
        canvas.restoreToCount(layerid);
    }
}
