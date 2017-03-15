package com.ifyou.aroma.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ifyou.aroma.R;
import com.ifyou.aroma.model.Banner;

import java.util.List;

/**
 * Created by Baranov on 12.03.2017.
 */

public class BannerPagerAdapter extends PagerAdapter {

    private Context mContext;
    private List<Banner> mItems;

    public BannerPagerAdapter(Context mContext, List<Banner> mItems) {
        this.mContext = mContext;
        this.mItems = mItems;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.banner_item, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.banner);
        TextView textView = (TextView) itemView.findViewById(R.id.text_banner);
        TextView textDesc = (TextView) itemView.findViewById(R.id.text_desc);
        Banner banner = mItems.get(position);
        Glide.with(mContext).load(banner.getImg())
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
        textView.setText(banner.getHeader());
        textDesc.setText(banner.getDescription());
        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((FrameLayout) object);
    }
}