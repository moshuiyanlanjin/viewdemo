package com.viewdemo.hz.viewdemo;

import android.content.Intent;
import android.graphics.BlurMaskFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.viewdemo.hz.viewdemo.activity.BezierThreeActivity;
import com.viewdemo.hz.viewdemo.activity.BezierTwoActivity;
import com.viewdemo.hz.viewdemo.activity.AliPlayActivity;
import com.viewdemo.hz.viewdemo.activity.BezierActivity;
import com.viewdemo.hz.viewdemo.activity.BitmapShaderViewActivity;
import com.viewdemo.hz.viewdemo.activity.BlendAnimationOneActivity;
import com.viewdemo.hz.viewdemo.activity.BlurMaskFilterOneActivity;
import com.viewdemo.hz.viewdemo.activity.CanvasActivity;
import com.viewdemo.hz.viewdemo.activity.CliprgnActivity;
import com.viewdemo.hz.viewdemo.activity.CustomCircleActivity;
import com.viewdemo.hz.viewdemo.activity.FunctiononeActivity;
import com.viewdemo.hz.viewdemo.activity.ImageValueanimtoroneActivity;
import com.viewdemo.hz.viewdemo.activity.ItemAnimatorActivity;
import com.viewdemo.hz.viewdemo.activity.RegiononeActivity;

import com.viewdemo.hz.viewdemo.activity.Rotatethepop_upActivity;
import com.viewdemo.hz.viewdemo.activity.RotatingloadActivity;
import com.viewdemo.hz.viewdemo.activity.SVGuseActivity;
import com.viewdemo.hz.viewdemo.activity.ScaleAnimationOneActivity;
import com.viewdemo.hz.viewdemo.activity.ScannerActivity;
import com.viewdemo.hz.viewdemo.activity.ShadowoneLayerActivity;
import com.viewdemo.hz.viewdemo.activity.SimpleparabolicActivity;
import com.viewdemo.hz.viewdemo.activity.SpiderActivity;
import com.viewdemo.hz.viewdemo.activity.TelescopeActivity;
import com.viewdemo.hz.viewdemo.activity.TextOneActivity;
import com.viewdemo.hz.viewdemo.activity.TextViewDemooneActivity;
import com.viewdemo.hz.viewdemo.activity.ThelettermailActivity;
import com.viewdemo.hz.viewdemo.activity.ThephonerangthebellActivity;
import com.viewdemo.hz.viewdemo.activity.ValueAnimatoroneActivity;
import com.viewdemo.hz.viewdemo.activity.ViewAnimationOneActivity;
import com.viewdemo.hz.viewdemo.activity.ViewAnimationtwoActivity;
import com.viewdemo.hz.viewdemo.adapter.MainAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recy)
    RecyclerView recy;

    private List<String> recylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initDate();
        initview();
    }

    private void initDate() {
        recylist = new ArrayList<>();
        recylist.add("蜘蛛网状图");
        recylist.add("文字");
        recylist.add("区域");
        recylist.add("画布");
        recylist.add("圆形头像");
        recylist.add("会和动画效果");
        recylist.add("简单的视图动画效果1");
        recylist.add("简单的视图动画效果2");
        recylist.add("放射动画");
        recylist.add("属性动画1");
        recylist.add("弹跳动画");
        recylist.add("字母闪图动画");
        recylist.add("简单的抛物动画");
        recylist.add("简单的伸缩动画");
        recylist.add("简单的混合动画");
        recylist.add("旋转弹出动画");
        recylist.add("电话响铃动画");
        recylist.add("item入场动画");
        recylist.add("简单函数使用");
        recylist.add("旋转加载动画");
        recylist.add("支付宝支付成功动画");
        recylist.add("SVG应用");
        recylist.add("TextViewDemo1");
        recylist.add("贝济埃曲线");
        recylist.add("贝塞尔曲线之波浪");
        recylist.add("贝塞尔曲线之抛物线动画");
        recylist.add("阴影1");
        recylist.add("发光1");
        recylist.add("颜色填充");
        recylist.add("望远镜效果");
    }

    private void initview() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recy.setLayoutManager(manager);
        MainAdapter adapter = new MainAdapter(this,recylist);
        recy.setAdapter(adapter);
        adapter.SetItemOnclike(new MainAdapter.Onclike() {
            @Override
            public void textonclike(int position) {
                switch (position){
                    case 0:
                        //蜘蛛网状图
                        startActivity(new Intent(MainActivity.this,SpiderActivity.class));
                        break;
                    case 1:
                        //文字
                        startActivity(new Intent(MainActivity.this,TextOneActivity.class));
                        break;
                    case 2:
                        //区域
                        startActivity(new Intent(MainActivity.this,RegiononeActivity.class));
                        break;
                    case 3:
                        //画布
                        startActivity(new Intent(MainActivity.this,CanvasActivity.class));
                        break;
                    case 4:
                        //圆形图像
                        startActivity(new Intent(MainActivity.this,CustomCircleActivity.class));
                        break;
                    case 5:
                        //会和动画效果
                        startActivity(new Intent(MainActivity.this,CliprgnActivity.class));
                        break;
                    case 6:
                        //简单的视图动画效果1
                        startActivity(new Intent(MainActivity.this,ViewAnimationOneActivity.class));
                        break;
                    case 7:
                        //简单的视图动画效果二
                        startActivity(new Intent(MainActivity.this, ViewAnimationtwoActivity.class));
                        break;
                    case 8:
                        //放射动画
                        startActivity(new Intent(MainActivity.this,ScannerActivity.class));
                        break;
                    case 9:
                        //属性动画1
                        startActivity(new Intent(MainActivity.this,ValueAnimatoroneActivity.class));
                        break;
                    case 10:
                        //弹跳动画
                        startActivity(new Intent(MainActivity.this,ImageValueanimtoroneActivity.class));
                        break;
                    case 11:
                        //字母闪图动画
                        startActivity(new Intent(MainActivity.this,ThelettermailActivity.class));
                        break;
                    case 12:
                        //简单的抛物动画
                        startActivity(new Intent(MainActivity.this,SimpleparabolicActivity.class));
                        break;
                    case 13:
                        //简单的缩放动画
                        startActivity(new Intent(MainActivity.this, ScaleAnimationOneActivity.class));
                        break;
                    case 14:
                        //简单的混合动画1
                        startActivity(new Intent(MainActivity.this,BlendAnimationOneActivity.class));
                        break;
                    case 15:
                        //旋转弹出动画
                        startActivity(new Intent(MainActivity.this,Rotatethepop_upActivity.class));
                        break;
                    case 16:
                        //电话响铃动画
                        startActivity(new Intent(MainActivity.this,ThephonerangthebellActivity.class));
                        break;
                    case 17:
                        //item入场动画
                        startActivity(new Intent(MainActivity.this, ItemAnimatorActivity.class));
                        break;
                    case 18:
                        //简单的函数使用
                        startActivity(new Intent(MainActivity.this,FunctiononeActivity.class));
                        break;
                    case 19:
                        //旋转加载动画
                        startActivity(new Intent(MainActivity.this,RotatingloadActivity.class));
                        break;
                    case 20:
                        //支付宝支付动画
                        startActivity(new Intent(MainActivity.this,AliPlayActivity.class));
                        break;
                    case 21:
                        //SVGz应用
                        startActivity(new Intent(MainActivity.this,SVGuseActivity.class));
                        break;
                    case 22:
                        //TextViewDemo1
                        startActivity(new Intent(MainActivity.this,TextViewDemooneActivity.class));
                        break;
                    case 23:
                        //贝济埃曲线（贝塞尔曲线）
                        startActivity(new Intent(MainActivity.this,BezierActivity.class));
                        break;
                    case 24:
                        //贝塞尔曲线之波浪
                        startActivity(new Intent(MainActivity.this,BezierTwoActivity.class));
                        break;
                    case 25:
                        //贝塞尔曲线之抛物线动画
                        startActivity(new Intent(MainActivity.this,BezierThreeActivity.class));
                        break;
                    case 26:
                        //阴影1
                        startActivity(new Intent(MainActivity.this,ShadowoneLayerActivity.class));
                        break;
                    case 27:
                        //发光
                        startActivity(new Intent(MainActivity.this, BlurMaskFilterOneActivity.class));
                        break;
                    case 28:
                        //颜色填充
                        startActivity(new Intent(MainActivity.this,BitmapShaderViewActivity.class));
                        break;
                    case 29:
                        //望远镜效果
                        startActivity(new Intent(MainActivity.this,TelescopeActivity.class));
                        break;
                }
            }
        });
    }
}
