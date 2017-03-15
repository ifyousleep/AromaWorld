package com.ifyou.aroma.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.ifyou.aroma.R;
import com.ifyou.aroma.model.TematicSet;
import com.ifyou.aroma.ui.RoundedCornersTransformation;

import java.util.List;

/**
 * Created by Baranov on 12.03.2017.
 */

public class SetsAdapter extends RecyclerView.Adapter<SetsAdapter.ViewHolder> {

    private List<TematicSet> mItems;
    private Context mContext;

    public SetsAdapter(List<TematicSet> banners, Context context) {
        this.mItems = banners;
        this.mContext = context;
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.tematicset_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        TematicSet tematicSet = mItems.get(i);
        Glide.with(mContext).load(tematicSet.getImg())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .bitmapTransform(new CenterCrop(mContext), new RoundedCornersTransformation(mContext, 15, 2))
                .into(viewHolder.subject);
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(viewHolder.frameLayout.getLayoutParams());
        if (i < mItems.size() - 1)
            lp.setMargins(0, 0, 32, 0);
        else
            lp.setMargins(0, 0, 0, 0);
        viewHolder.frameLayout.setLayoutParams(lp);
        viewHolder.textSet.setText(tematicSet.getDescription());
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView subject;
        private TextView textSet;
        private FrameLayout frameLayout;

        private ViewHolder(View itemView) {
            super(itemView);
            subject = (ImageView) itemView.findViewById(R.id.banner);
            textSet = (TextView) itemView.findViewById(R.id.text_sets);
            frameLayout = (FrameLayout) itemView.findViewById((R.id.frame_sets));
        }
    }
}
