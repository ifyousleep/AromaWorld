package com.ifyou.aroma.view;

import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ifyou.aroma.presenter.IPresenter;

/**
 * Created by Baranov on 14.03.2017.
 */

public interface IView {

    void create(LayoutInflater inflater, ViewGroup container);

    View getRootView();

    Toolbar getToolbar();

    void bindPresenter(IPresenter presenter);

    void bindEvent();

    void destroy();
}
