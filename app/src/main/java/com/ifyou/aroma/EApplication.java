package com.ifyou.aroma;

import android.app.Application;

/**
 * Created by Baranov on 14.03.2017.
 */

public class EApplication extends Application {
    private static EApplication instance = null;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static EApplication getInstance() {
        if (instance == null) {
            synchronized (EApplication.class) {
                if (instance == null) {
                    instance = new EApplication();
                }
            }
        }
        return instance;
    }
}
