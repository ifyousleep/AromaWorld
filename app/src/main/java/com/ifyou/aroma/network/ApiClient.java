package com.ifyou.aroma.network;

import android.content.Context;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Baranov on 13.03.2017.
 */

public class ApiClient {

    private static final String BASE_URL = "http://am.aeroidea.ru/";
    private static Retrofit retrofit = null;

    // кэширование не работает с POST запросами =((

    /*private static OkHttpClient getCachedOkHttpClient(final Context context) {
        File httpCacheDirectory = new File(context.getCacheDir(), "cache_file");
        Cache cache = new Cache(httpCacheDirectory, 20 * 1024 * 1024);
        OkHttpClient.Builder okHttpClient = new OkHttpClient().newBuilder();
        okHttpClient.cache(cache);
        okHttpClient.interceptors().add(
                new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        Request originalRequest = chain.request();
                        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                        String cacheHeaderValue = connectivityManager.getActiveNetworkInfo().isAvailable()
                                ? "public, max-age=2419200"
                                : "public, only-if-cached, max-stale=2419200";
                        Request request = originalRequest.newBuilder().build();
                        okhttp3.Response response = chain.proceed(request);
                        return response.newBuilder()
                                .removeHeader("Pragma")
                                .removeHeader("Cache-Control")
                                .header("Cache-Control", cacheHeaderValue)
                                .build();
                    }
                }
        );
        okHttpClient.networkInterceptors().add(
                new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        Request originalRequest = chain.request();
                        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                        String cacheHeaderValue = connectivityManager.getActiveNetworkInfo().isAvailable()
                                ? "public, max-age=2419200"
                                : "public, only-if-cached, max-stale=2419200";
                        Request request = originalRequest.newBuilder().build();
                        okhttp3.Response response = chain.proceed(request);
                        return response.newBuilder()
                                .removeHeader("Pragma")
                                .removeHeader("Cache-Control")
                                .header("Cache-Control", cacheHeaderValue)
                                .build();
                    }
                }
        );
        return okHttpClient.build();
    }*/


    public static Retrofit getClient(final Context context) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    //.client(getCachedOkHttpClient(context))
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
