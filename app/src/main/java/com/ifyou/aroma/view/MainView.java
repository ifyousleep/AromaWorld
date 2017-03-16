package com.ifyou.aroma.view;

import android.app.Activity;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;

import com.ifyou.aroma.R;
import com.ifyou.aroma.fragment.EmptyFragment;
import com.ifyou.aroma.fragment.HomeFragment;
import com.ifyou.aroma.helper.EventHelper;

import butterknife.BindView;

/**
 * Created by Baranov on 14.03.2017.
 */

public class MainView extends ViewImpl {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigationView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void bindEvent() {
        super.bindEvent();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle((Activity) mRootView.getContext(), drawer, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        EventHelper.setNavigationItemSelected(mPresenter, navigationView);
        EventHelper.setBottomNavigationItemSelected(mPresenter, bottomNavigationView);
    }

    public boolean setNavigationItemSelected(FragmentManager manager, int menuId) {
        setNewRootFragment(manager, menuId);
        drawer.closeDrawer(GravityCompat.START);
        return false;
    }

    public boolean closeDrawer() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else return false;
    }

    private void setNewRootFragment(FragmentManager manager, int menuId) {
        HomeFragment mHomeFragment;
        EmptyFragment mEmptyFragment;
        FragmentTransaction transaction = manager.beginTransaction();
        switch (menuId) {
            case R.id.menu_home:
                    mHomeFragment = new HomeFragment();
                    transaction.replace(R.id.container, mHomeFragment);
                break;
            default:
                    mEmptyFragment = new EmptyFragment();
                    transaction.replace(R.id.container, mEmptyFragment);
                break;
        }
        transaction.commit();
        drawer.closeDrawers();
    }

    @Override
    public Toolbar getToolbar() {
        return toolbar;
    }

    @Override
    public void destroy() {
        mUnbinder.unbind();
    }
}
