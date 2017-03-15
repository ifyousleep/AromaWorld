package com.ifyou.aroma.presenter;

/**
 * Created by Baranov on 14.03.2017.
 */

public interface IPresenter<T> {
    Class<T> getViewClass();
}