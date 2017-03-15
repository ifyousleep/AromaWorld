package com.ifyou.aroma.presenter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.ifyou.aroma.R;
import com.ifyou.aroma.helper.GenericHelper;
import com.ifyou.aroma.view.IView;

/**
 * Created by Baranov on 14.03.2017.
 */

public class ActivityPresenter <T extends IView> extends AppCompatActivity implements IPresenter<T> {

    protected T mView;

    @SuppressWarnings("TryWithIdenticalCatches")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        try {
            mView = getViewClass().newInstance();
            mView.create(getLayoutInflater(), null);
            mView.bindPresenter(this);
            setContentView(mView.getRootView());
            initToolbar();
            mView.bindEvent();
            initData();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    protected void initToolbar() {
        Toolbar toolbar = mView.getToolbar();
        if (null != toolbar) {
            setSupportActionBar(toolbar);
        }
    }

    @Override
    protected void onDestroy() {
        mView.destroy();
        super.onDestroy();
    }

    protected void initData(){}

    @Override
    public Class<T> getViewClass() {
        return GenericHelper.getViewClass(getClass());
    }
}
