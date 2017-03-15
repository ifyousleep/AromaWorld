package com.ifyou.aroma.presenter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ifyou.aroma.fragment.LazyFragment;
import com.ifyou.aroma.helper.GenericHelper;
import com.ifyou.aroma.view.IView;

/**
 * Created by Baranov on 14.03.2017.
 */

public class FragmentPresenter<T extends IView> extends LazyFragment implements IPresenter<T>{

    protected T mView;

    @Override
    protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = null;
        try{
            mView = getViewClass().newInstance();
            mView.create(inflater, container);
            mView.bindPresenter(this);
            view = mView.getRootView();
            initData();
        }catch (Exception e){
            e.printStackTrace();
        }
        return view;
    }

    @Override
    protected void initializeData() {
        lazyData();
    }

    @Override
    public void onDestroyView() {
        onDestroyV();
        mView = null;
        super.onDestroyView();
    }

    protected void onDestroyV() {
    }

    protected void initData(){
    }

    protected void lazyData(){}

    @Override
    public Class<T> getViewClass() {
        return GenericHelper.getViewClass(getClass());
    }
}
