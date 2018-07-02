package com.worldmer.activeandroidexample;

import android.app.Application;

import com.activeandroid.ActiveAndroid;

/**
 * Created by Yagnik on 01-Jul-18.
 */

public class CApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }
}
