package com.ifyou.aroma;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.view.MenuItem;

import com.ifyou.aroma.presenter.ActivityPresenter;
import com.ifyou.aroma.view.MainView;

/**
 * Created by Baranov on 14.03.2017.
 */

public class MainActivity extends ActivityPresenter<MainView>
        implements NavigationView.OnNavigationItemSelectedListener,
        BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void initData() {
        super.initData();
        mView.setNavigationItemSelected(getSupportFragmentManager(), R.id.menu_home);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return mView.setNavigationItemSelected(getSupportFragmentManager(), item.getItemId());
    }

    @Override
    public void onBackPressed() {
        if (mView.closeDrawer())
            return;
        super.onBackPressed();
    }
}
