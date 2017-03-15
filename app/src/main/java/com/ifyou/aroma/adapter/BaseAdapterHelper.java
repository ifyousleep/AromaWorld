package com.ifyou.aroma.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ifyou.aroma.EApplication;

/**
 * Created by Baranov on 14.03.2017.
 */

public class BaseAdapterHelper extends RecyclerView.ViewHolder {

    private SparseArray<View> views;

    public BaseAdapterHelper(View itemView) {
        super(itemView);
        this.views = new SparseArray<>();
    }

    public void setText(int viewId, String str) {
        View view = retrieveView(viewId);
        if (view instanceof TextView) {
            ((TextView) view).setText(str);
        }
    }

    public void setImageByUrl(int viewId, String url) {
        View view = retrieveView(viewId);
        if (view instanceof ImageView) {
            Glide.with(EApplication.getInstance()).load(url)
                    .crossFade().into((ImageView) view);
        }
    }

    public TextView getTextView(int viewId) {
        return retrieveView(viewId);
    }

    public Button getButton(int viewId) {
        return retrieveView(viewId);
    }

    public ImageView getImageView(int viewId) {
        return retrieveView(viewId);
    }

    public View getView(int viewId) {
        return retrieveView(viewId);
    }

    @SuppressWarnings("unchecked")
    protected <T extends View> T retrieveView(int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }
}
