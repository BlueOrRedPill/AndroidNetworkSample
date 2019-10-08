package com.android.sportnmedc;

import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

public class BaseApplication extends Application {

    private static Context context;
//    public static boolean DEBUG = false;

    @Override
    public void onCreate() {
        super.onCreate();
//        this.DEBUG = Utils.isDebuggable(this);
        context = getApplicationContext();
        Logger.addLogAdapter(new AndroidLogAdapter() {
            @Override
            public boolean isLoggable(int priority, String tag) {
                return BuildConfig.DEBUG;
            }
        });
    }

    public static Context getContext() {
        return context;
    }
}
