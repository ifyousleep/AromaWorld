package com.ifyou.aroma.network;

import com.ifyou.aroma.model.Aroma;

import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by Baranov on 10.03.2017.
 */

public interface ApiInterface {
    @POST("api/catalog")
    Call<Aroma> getAromaJson();
}
