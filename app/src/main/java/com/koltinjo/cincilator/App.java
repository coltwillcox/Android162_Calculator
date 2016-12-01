package com.koltinjo.cincilator;

import android.app.Application;
import android.content.Context;

/**
 * Created by colt on 01.12.2016.
 */

// TODO Check for memory leaks.
public class App extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }

    public static Context getContext() {
        return context;
    }

}