package com.viewdemo.hz.viewdemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.viewdemo.hz.viewdemo.R;

/**
 * Created by zyand on 2019/4/17.
 */

public class SpiderActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spider);
        if(true || false){
            Log.d("ceshi",1+"");
        }else if(true && true){
            Log.d("ceshi","2");
        }


    }
}
