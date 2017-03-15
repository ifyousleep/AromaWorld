package com.ifyou.aroma.helper;

import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.ifyou.aroma.presenter.IPresenter;

/**
 * Created by Baranov on 14.03.2017.
 */

public class EventHelper {

    public static void setOnPageChangeListener(IPresenter presenter, View...views){
        if(!(presenter instanceof ViewPager.OnPageChangeListener)) return;
        if(views == null  || views.length == 0) return;
        for (View v : views) ((ViewPager)v).addOnPageChangeListener((ViewPager.OnPageChangeListener) presenter);
    }

    public static void setNavigationItemSelected(IPresenter presenter, View...views){
        if(!(presenter instanceof NavigationView.OnNavigationItemSelectedListener)) return;
        if(views == null  || views.length == 0) return;
        for (View v : views) ((NavigationView)v).setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) presenter);
    }

    public static void setBottomNavigationItemSelected(IPresenter presenter, View...views){
        if(!(presenter instanceof BottomNavigationView.OnNavigationItemSelectedListener)) return;
        if(views == null  || views.length == 0) return;
        for (View v : views) ((BottomNavigationView)v).setOnNavigationItemSelectedListener((BottomNavigationView.OnNavigationItemSelectedListener) presenter);
    }
}
