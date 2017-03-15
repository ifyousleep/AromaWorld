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
import com.ifyou.aroma.R;
import com.ifyou.aroma.model.Product;

import java.util.List;

/**
 * Created by Baranov on 14.03.2017.
 */

public class ViewedAdapter extends RecyclerView.Adapter<ViewedAdapter.ViewHolder> {

    private List<Product> mItems;
    private Context mContext;

    public ViewedAdapter(List<Product> products, Context context) {
        this.mItems = products;
        this.mContext = context;
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.viewed_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Product product = mItems.get(i);
        if (product.getImg() != null)
            Glide.with(mContext).load(product.getImg())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(viewHolder.subjectPhoto);
        else
            viewHolder.subjectPhoto.setImageResource(R.drawable.bottle);
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(viewHolder.frameLayout.getLayoutParams());
        if (i < mItems.size() - 1)
            lp.setMargins(0, 0, 32, 0);
        else
            lp.setMargins(0, 0, 0, 0);
        viewHolder.frameLayout.setLayoutParams(lp);
        viewHolder.name.setText(product.getNameRus());
        viewHolder.price.setText(String.valueOf(product.getPrice()) + " " + product.getCurrency());
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private FrameLayout frameLayout;
        private ImageView subjectPhoto;
        private TextView name, price;

        private ViewHolder(View itemView) {
            super(itemView);
            frameLayout = (FrameLayout) itemView.findViewById((R.id.frame_viewed));
            subjectPhoto = (ImageView) itemView.findViewById(R.id.photo);
            name = (TextView) itemView.findViewById(R.id.name);
            price = (TextView) itemView.findViewById(R.id.price);
        }
    }
}
