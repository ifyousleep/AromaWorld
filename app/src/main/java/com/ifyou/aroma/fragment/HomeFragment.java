package com.ifyou.aroma.fragment;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ifyou.aroma.model.Aroma;
import com.ifyou.aroma.network.ApiClient;
import com.ifyou.aroma.network.ApiInterface;
import com.ifyou.aroma.presenter.FragmentPresenter;
import com.ifyou.aroma.view.HomeView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Baranov on 14.03.2017.
 */

public class HomeFragment extends FragmentPresenter<HomeView> implements ViewPager.OnPageChangeListener{

    private Context mContext;

    Aroma mResponse;

    public static final String CACHE_FILE_NAME = "cacheFile.srl";

    @Override
    protected void lazyData() {
        super.lazyData();
        mContext = getActivity();
        mView.initViews(mContext);
        getData();
    }

    private void getData() {
        // Или проверять есть интернет соединение или нет, как вариант
        File file = new File(mContext.getCacheDir(), CACHE_FILE_NAME);
        if (file.exists())
            getCachedData();
        else
            getDataFromApi();
    }

    private void cacheResponse(Aroma response) throws IOException {
        Gson gson = new Gson();
        String jsonString = gson.toJson(response);
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(new File(mContext.getCacheDir(),
                CACHE_FILE_NAME)));
        out.writeObject(jsonString);
        out.close();
    }

    private void getCachedData() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(mContext.getCacheDir(),
                    CACHE_FILE_NAME)));
            Gson gson = new Gson();
            mResponse = gson.fromJson(String.valueOf(in.readObject()), Aroma.class);
            in.close();
            mView.initViewsAfter(mContext, mResponse);
            mView.hideProgressBar();
        } catch (IOException e) {
            e.getLocalizedMessage();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void getDataFromApi() {
        ApiInterface apiService =
                ApiClient.getClient(mContext).create(ApiInterface.class);
        Call<Aroma> call = apiService.getAromaJson();
        call.enqueue(new Callback<Aroma>() {
            @Override
            public void onResponse(Call<Aroma> call, Response<Aroma> response) {
                mResponse = response.body();
                mView.initViewsAfter(mContext, mResponse);
                mView.hideProgressBar();
                try {
                    cacheResponse(mResponse);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<Aroma> call, Throwable t) {
                Toast.makeText(mContext, "Unable to fetch json: " + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                mView.hideProgressBar();
            }
        });
    }

    @Override
    public void onPageSelected(int position) {
        mView.updateUiPageViewController(position, mContext);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
