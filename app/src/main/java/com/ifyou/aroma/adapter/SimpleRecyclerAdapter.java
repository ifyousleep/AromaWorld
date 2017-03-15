package com.ifyou.aroma.adapter;

import android.content.Context;

import java.util.List;

/**
 * Created by Baranov on 14.03.2017.
 */

public abstract class SimpleRecyclerAdapter<T> extends BaseQuickAdapter<T, BaseAdapterHelper> {

    protected SimpleRecyclerAdapter(Context mContext, List<T> data, int mLayoutResId) {
        super(mContext, mLayoutResId, data);
    }

}
