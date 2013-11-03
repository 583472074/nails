package com.blackmoon.nails.app;

import android.app.Application;

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        Thread.currentThread().setUncaughtExceptionHandler(new CrashHandler(this));
    }
}
