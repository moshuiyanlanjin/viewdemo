package com.viewdemo.hz.viewdemo.App;

import android.app.Application;

/**
 * Created by zyand on 2019/4/17.
 */

public class MyApp extends Application {

    public static Application context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
}
