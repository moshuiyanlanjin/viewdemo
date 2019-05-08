package com.viewdemo.hz.viewdemo.activity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.viewdemo.hz.viewdemo.R;
import com.viewdemo.hz.viewdemo.View.ShimmerTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zyand on 2019/5/5.
 */

public class ShimmerTextActivity extends BaseActivity implements View.OnTouchListener {

    @BindView(R.id.tv)
    ShimmerTextView tv;

    private GestureDetector gestureDetector;

    private int FLING_MIN_DISTANCE = 100,FLING_MIN_VRLOCITY=200;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shimmertextview);
        ButterKnife.bind(this);
        tv.setOnTouchListener(this);
        gestureDetector = new GestureDetector(new gestureListener());
        tv.setFocusable(true);
        tv.setClickable(true);
        tv.setLongClickable(true);
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    private class gestureListener implements GestureDetector.OnGestureListener,GestureDetector.OnDoubleTapListener{
        @Override
        public boolean onDown(MotionEvent e) {
            Log.d("ceshi", "ondown");
            return false;
        }

        @Override
        public void onShowPress(MotionEvent e) {
            Log.d("ceshi", "onShowPress");

        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            Log.d("ceshi", "onSingleTapUp");

            return false;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            Log.d("ceshi", "onScroll");

            return false;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            Log.d("ceshi", "onLongPress");

        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            Log.d("ceshi", "onFling");

            if(e1.getX() - e2.getX()>=FLING_MIN_DISTANCE && Math.abs(velocityX) >= FLING_MIN_VRLOCITY){
                Log.d("ceshi","向左滑");

            }else if(e2.getX() - e1.getX() >= FLING_MIN_DISTANCE && Math.abs(velocityX) >= FLING_MIN_VRLOCITY){
                Log.d("ceshi","向右划");
            }
            return false;
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            Log.d("ceshi", "onSingleTapConfirmed");

            return false;
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            Log.d("ceshi", "onDoubleTap");

            return false;
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            Log.d("ceshi", "onDoubleTapEvent");

            return false;
        }
    }


}
