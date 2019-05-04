package com.viewdemo.hz.viewdemo.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.viewdemo.hz.viewdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zyand on 2019/4/22.
 */

public class Rotatethepop_upActivity extends BaseActivity {

    @BindView(R.id.item1)
    ImageView item1;
    @BindView(R.id.item2)
    ImageView item2;
    @BindView(R.id.item3)
    ImageView item3;
    @BindView(R.id.item4)
    ImageView item4;
    @BindView(R.id.item5)
    ImageView item5;
    @BindView(R.id.gk)
    ImageView gk;

    //开关：0未弹出，1已弹出
    private int kg = 0;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotatethepop_up);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.item1, R.id.item2, R.id.item3, R.id.item4, R.id.item5, R.id.gk})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.item1:
                break;
            case R.id.item2:
                break;
            case R.id.item3:
                break;
            case R.id.item4:
                break;
            case R.id.item5:
                break;
            case R.id.gk:
                if(kg == 0){
                    setpop_upes();
                    kg = 1;
                }else{
                    rompop_ups();
                    kg = 0;
                }
                break;
        }
    }

    //恢复原样
    private void rompop_ups() {
        rompop_up(item1);
        rompop_up(item2);
        rompop_up(item3);
        rompop_up(item4);
        rompop_up(item5);
        ObjectAnimator animator = ObjectAnimator.ofFloat(gk,"rotation",180,360);
        animator.setDuration(2000);
        animator.start();

    }

    private void rompop_up(ImageView view) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(view,"TranslationX",0);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(view,"TranslationY",0);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(view,"Alpha",1f,0);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(view,"Rotation",360,0);
        ObjectAnimator animator4 = ObjectAnimator.ofFloat(view,"scaleX",1,0);
        ObjectAnimator animator5 = ObjectAnimator.ofFloat(view,"scaleY",1,0);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animator,animator1,animator2,animator3,animator4,animator5);
        animatorSet.setDuration(2000);
        animatorSet.start();
       /* if(view.getVisibility() != View.GONE){
            view.setVisibility(View.GONE);
        }*/
    }

    //旋转弹出
    private void setpop_upes() {
        setpop_on(item1,5,1,400);
        setpop_on(item2,5,2,400);
        setpop_on(item3,5,3,400);
        setpop_on(item4,5,4,400);
        setpop_on(item5,5,5,400);
        ObjectAnimator animator = ObjectAnimator.ofFloat(gk,"Rotation",180);
        animator.setDuration(2000);
        animator.start();
    }

    private void setpop_on(View view, int z, int i, int ra) {
        if(view.getVisibility() != View.VISIBLE){
            view.setVisibility(View.VISIBLE);
        }

        int x =  -(int) (ra*Math.cos(Math.PI/2/(z-1)*(i-1)));
        int y = -(int) (ra*Math.sin(Math.PI/2/(z-1)*(i-1)));
        Log.d("ceshi",x+":"+y);
        ObjectAnimator animator = ObjectAnimator.ofFloat(view,"TranslationX",0,x);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(view,"TranslationY",0,y);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(view,"Alpha",0.5f,1);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(view,"Rotation",360);
        ObjectAnimator animator4 = ObjectAnimator.ofFloat(view,"scaleX",0,1);
        ObjectAnimator animator5 = ObjectAnimator.ofFloat(view,"scaleY",0,1);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animator,animator1,animator2,animator3,animator4,animator5);
        animatorSet.setDuration(2000);
        animatorSet.start();

    }


}
