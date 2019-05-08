package com.viewdemo.hz.viewdemo.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.ArcShape;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.PathShape;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.viewdemo.hz.viewdemo.R;
import com.viewdemo.hz.viewdemo.View.Shape.RegionShape;

/**
 * Created by zyand on 2019/5/8.
 */

public class ShapeoneView extends View {

    private ShapeDrawable shapeDrawable;

    public ShapeoneView(Context context) {
        super(context);
        init();
    }

    public ShapeoneView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ShapeoneView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

        setLayerType(LAYER_TYPE_SOFTWARE,null);
        //矩形画布
       // shapeDrawable = new ShapeDrawable(new RectShape());

        //圆形画布
        //shapeDrawable = new ShapeDrawable(new OvalShape());

        //扇形画布startangle扇形开始角度，sweepAngle扇形扫描过角度
        //shapeDrawable = new ShapeDrawable(new ArcShape(0,300));

        //镂空圆角矩形参数1：外层矩形角度，参数2内外层边距，参数三：内层矩形角度，这三个参数如不需要都可传空
       // shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{12,12,12,12,0,0,0,0},new RectF(20,20,20,20),new float[]{50,12,0,0,12,50,0,0}));

        //根据路径绘制的shape,stdwidth指把setbounds中的位置背景宽度划分多少分，stdheight指高度划分多少份，path中的值也是分数
       /* Path path = new Path();
        path.moveTo(0,0);
        path.lineTo(100,0);
        path.lineTo(100,100);
        path.lineTo(0,100);
        path.close();
        shapeDrawable = new ShapeDrawable(new PathShape(path,200,200));*/

      /* Rect r1 = new Rect(0,50,250,100);
       Rect r2 = new Rect(50,0,90,150);
       //构造两个区域
        Region region1 = new Region(r1);
        Region region2 = new Region(r2);
        //去掉相交部分
        region1.op(region2, Region.Op.XOR);
        shapeDrawable = new ShapeDrawable(new RegionShape(region1));*/

        shapeDrawable = new ShapeDrawable(new RectShape());

        //设置ShapeDrawble的所在位置
        shapeDrawable.setBounds(new Rect(50,50,300,300));
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.avator);
        BitmapShader shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        shapeDrawable.getPaint().setShader(shader);

        shapeDrawable.getPaint().setColor(Color.YELLOW);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        shapeDrawable.draw(canvas);
    }
}
