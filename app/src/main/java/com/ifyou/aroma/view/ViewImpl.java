package com.ifyou.aroma.view;

import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ifyou.aroma.presenter.IPresenter;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Baranov on 14.03.2017.
 */

abstract class ViewImpl implements IView {

    View mRootView;
    IPresenter mPresenter;
    Unbinder mUnbinder;

    @Override
    public void create(LayoutInflater inflater, ViewGroup container) {
        mRootView = inflater.inflate(getLayoutId(), container, false);
        mUnbinder = ButterKnife.bind(this, mRootView.getRootView());
    }

    @Override
    public View getRootView() {
        return mRootView;
    }

    public Toolbar getToolbar() { return null; }

    @Override
    public void bindPresenter(IPresenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void bindEvent() {
    }

    public abstract int getLayoutId();
}
