package com.viewdemo.hz.viewdemo.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zyand on 2019/5/7.
 */

public class MATRIX_SAVE_FLAG_View extends View {

    private Paint paint;
    public MATRIX_SAVE_FLAG_View(Context context) {
        super(context);
        init();
    }

    public MATRIX_SAVE_FLAG_View(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MATRIX_SAVE_FLAG_View(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        paint = new Paint();
        paint.setColor(Color.GRAY);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save(Canvas.ALL_SAVE_FLAG);
        canvas.rotate(40);
        canvas.drawRect(100,0,200,100,paint);
        canvas.restore();

        paint.setColor(Color.RED);
        canvas.drawRect(100,0,200,100,paint);
    }
}
