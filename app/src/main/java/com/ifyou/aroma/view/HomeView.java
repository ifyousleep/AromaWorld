package com.ifyou.aroma.view;

import android.content.Context;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.ifyou.aroma.R;
import com.ifyou.aroma.adapter.BannerPagerAdapter;
import com.ifyou.aroma.adapter.BaseAdapterHelper;
import com.ifyou.aroma.adapter.BaseQuickAdapter;
import com.ifyou.aroma.adapter.SetsAdapter;
import com.ifyou.aroma.adapter.SimpleRecyclerAdapter;
import com.ifyou.aroma.adapter.ViewedAdapter;
import com.ifyou.aroma.helper.DividerItemDecoration;
import com.ifyou.aroma.helper.EventHelper;
import com.ifyou.aroma.model.Aroma;
import com.ifyou.aroma.model.Product;
import com.ifyou.aroma.model.Section;
import com.ifyou.aroma.model.TematicSet;
import com.ifyou.aroma.model.ViewedProduct;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Baranov on 14.03.2017.
 */

public class HomeView extends ViewImpl {

    @BindView(R.id.pagerBanner)
    ViewPager mPagerBanner;
    @BindView(R.id.viewPagerCountDots)
    LinearLayout mPagerIndicator;
    @BindView(R.id.recyclerViewCatalog)
    RecyclerView mRecyclerViewCatalog;
    @BindView(R.id.sectionTitle)
    TextView mSectionSetsTitle;
    @BindView(R.id.recyclerViewSets)
    RecyclerView mRecyclerViewTematicSet;
    @BindView(R.id.sectionViewedTitle)
    TextView mSectionViewedTitle;
    @BindView(R.id.recyclerViewSetsViewed)
    RecyclerView mRecyclerViewViewed;
    @BindView(R.id.buttonMoreViewed)
    Button mButtonMore;
    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;

    private BannerPagerAdapter mAdapterBanner;
    private int mDotsCount;
    private ImageView[] mDots;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    public void initViews(Context context) {
        RecyclerView.LayoutManager mLayoutManagerCatalog, mLayoutManagerTematicSet, mLayoutManagerViewed;

        mRecyclerViewCatalog.setHasFixedSize(true);
        mRecyclerViewCatalog.setItemAnimator(new DefaultItemAnimator());
        mRecyclerViewCatalog.addItemDecoration(new DividerItemDecoration(context, LinearLayoutManager.VERTICAL));
        mLayoutManagerCatalog = new LinearLayoutManager(context);
        mRecyclerViewCatalog.setLayoutManager(mLayoutManagerCatalog);
        mRecyclerViewCatalog.setNestedScrollingEnabled(false);

        mRecyclerViewTematicSet.setHasFixedSize(true);
        mRecyclerViewTematicSet.setItemAnimator(new DefaultItemAnimator());
        mLayoutManagerTematicSet = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerViewTematicSet.setLayoutManager(mLayoutManagerTematicSet);
        mRecyclerViewTematicSet.setNestedScrollingEnabled(false);
        SnapHelper snapHelperTematicSet = new LinearSnapHelper();
        snapHelperTematicSet.attachToRecyclerView(mRecyclerViewTematicSet);

        mRecyclerViewViewed.setHasFixedSize(true);
        mRecyclerViewViewed.setItemAnimator(new DefaultItemAnimator());
        mLayoutManagerViewed = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerViewViewed.setLayoutManager(mLayoutManagerViewed);
        mRecyclerViewViewed.setNestedScrollingEnabled(false);
        SnapHelper snapHelperViewed = new LinearSnapHelper();
        snapHelperViewed.attachToRecyclerView(mRecyclerViewViewed);
    }

    @SuppressWarnings("unchecked")
    public void initViewsAfter(final Context context, Aroma mResponse) {
        List<Section> section;
        List<TematicSet> tematicSets;
        List<ViewedProduct> viewedProducts;
        List<Product> products;

        SimpleRecyclerAdapter mAdapterBannerCatalog;
        SetsAdapter mAdapterTematicSet;
        ViewedAdapter mAdapterViewed;

        mAdapterBanner = new BannerPagerAdapter(context, mResponse.getCatalog().getBanners());
        mPagerBanner.setAdapter(mAdapterBanner);
        mPagerBanner.setCurrentItem(0);
        setUiPageViewController(context);
        EventHelper.setOnPageChangeListener(mPresenter, mPagerBanner);

        section = mResponse.getCatalog().getSections();
        mAdapterBannerCatalog = new SimpleRecyclerAdapter<Section>(context, section, R.layout.catalog_item) {
            @Override
            protected void convert(BaseAdapterHelper helper, Section item) {
                helper.setText(R.id.txt_primary, item.getName());
            }
        };
        mAdapterBannerCatalog.setOnInViewClickListener(R.id.root_layout,
                new BaseQuickAdapter.onInternalClickListenerImpl<Section>() {
                    @Override
                    public void OnClickListener(View parentV, View v, Integer position, Section values) {
                        Toast.makeText(context, values.getName(), Toast.LENGTH_SHORT).show();
                    }
                });
        mRecyclerViewCatalog.setAdapter(mAdapterBannerCatalog);

        mSectionSetsTitle.setText(R.string.section_sets);
        tematicSets = mResponse.getCatalog().getTematicSets();
        mAdapterTematicSet = new SetsAdapter(tematicSets, context);
        mRecyclerViewTematicSet.setAdapter(mAdapterTematicSet);

        mSectionViewedTitle.setText(R.string.section_viewed);
        viewedProducts = mResponse.getCatalog().getViewedProducts();
        products = new ArrayList<>();
        for (int i = 0; i < viewedProducts.size(); i++) {
            for (int x = 0; x < viewedProducts.get(i).getProducts().size(); x++) {
                products.add(viewedProducts.get(i).getProducts().get(x));
            }
        }
        mAdapterViewed = new ViewedAdapter(products, context);
        mRecyclerViewViewed.setAdapter(mAdapterViewed);

        mButtonMore.setVisibility(View.VISIBLE);
        mButtonMore.setText(R.string.button_more);
    }

    public void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

    public void updateUiPageViewController(int position, Context context) {
        for (int i = 0; i < mDotsCount; i++) {
            mDots[i].setImageDrawable(ResourcesCompat.getDrawable(context.getResources(),
                    R.drawable.nonselecteditem_dot, null));
        }
        if (mDots != null)
            mDots[position].setImageDrawable(ResourcesCompat.getDrawable(context.getResources(),
                    R.drawable.selecteditem_dot, null));
    }

    @Override
    public void destroy() {

    }

    private void setUiPageViewController(Context context) {
        mDotsCount = mAdapterBanner.getCount();
        mDots = new ImageView[mDotsCount];
        for (int i = 0; i < mDotsCount; i++) {
            mDots[i] = new ImageView(context);
            mDots[i].setImageDrawable(ResourcesCompat.getDrawable(context.getResources(),
                    R.drawable.nonselecteditem_dot, null));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(4, 0, 4, 0);
            mPagerIndicator.addView(mDots[i], params);
        }
        mDots[0].setImageDrawable(ResourcesCompat.getDrawable(context.getResources(), R.drawable.selecteditem_dot, null));
    }
}
