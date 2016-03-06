package com.nhpatt.asde.mvp;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * @author Javier Gamarra
 */
public class CatalogApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
    }
}
