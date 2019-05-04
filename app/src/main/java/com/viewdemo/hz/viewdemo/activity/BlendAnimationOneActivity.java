package com.viewdemo.hz.viewdemo.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.viewdemo.hz.viewdemo.R;
import com.viewdemo.hz.viewdemo.View.ObjectAnimatorUtlis.BackgroundtextView;
import com.viewdemo.hz.viewdemo.View.ObjectAnimatorUtlis.Translationtextview;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zyand on 2019/4/20.
 */

public class BlendAnimationOneActivity extends BaseActivity {

    @BindView(R.id.text1)
    Translationtextview text1;
    @BindView(R.id.text2)
    BackgroundtextView text2;
    @BindView(R.id.button6)
    Button button6;
    @BindView(R.id.button7)
    Button button7;

    AnimatorSet animatorSet;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blend);
        ButterKnife.bind(this);


    }



    @OnClick({R.id.button6, R.id.button7})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button6:
                ObjectAnimator animator = ObjectAnimator.ofInt(text2, "Backgroundtextcolor", 0xaabbccdd, 0x96152436, 0x32df45ed);
                //   animator.setDuration(3000);
                //   animator.setRepeatCount(ObjectAnimator.INFINITE);


                ObjectAnimator animator1 = ObjectAnimator.ofInt(text1, "Back", 0XFFcc0099, 0XFFcc6633, 0XFF33ff00);
                animator1.setDuration(3000);
                animator1.setRepeatCount(ObjectAnimator.INFINITE);

                ObjectAnimator animator2 = ObjectAnimator.ofFloat(text1, "Roun", 0, 3600);
                animator2.setDuration(3000);
                animator2.setRepeatCount(ObjectAnimator.INFINITE);

                ObjectAnimator animator3 = ObjectAnimator.ofFloat(text1, "Tran", 0, 600);
                // animator3.setDuration(3000);
                 animator3.setRepeatCount(ObjectAnimator.INFINITE);

                ObjectAnimator animator4 = ObjectAnimator.ofFloat(text2, "Tan", 300);
                //animator4.setRepeatCount(ObjectAnimator.INFINITE);
                // animator4.setDuration(3000);


                animatorSet = new AnimatorSet();
                // animatorSet.playTogether(animator,animator1,animator2,animator3);
                // animatorSet.start();

                /**
                 * play:执行这个动画
                 * with：和前一个动画一起执行
                 * after:在前一个动画执行前执行
                 * befor：在前一个动画执行后执行
                 */
                animatorSet.play(animator).with(animator3).after(animator4);
                animatorSet.setDuration(3000);



                animatorSet.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {
                        Log.d("ceshi", "start");
                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        Log.d("ceshi", "End");
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {
                        Log.d("ceshi", "Cancel");
                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {
                        Log.d("ceshi", "Repeat");
                    }
                });

                animatorSet.start();
                break;
            case R.id.button7:
                animatorSet.cancel();
                break;
        }
    }
}
