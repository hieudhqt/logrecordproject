package com.hieu.prm.logrecordproject.utils;

import android.content.Context;

import com.hieu.prm.logrecordproject.service.AccountService;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String BASE_URL = "https://192.168.3.123:45455/";
    private static RetrofitClient mInstance;
    private static Retrofit retrofit;

    private RetrofitClient() {
    }

    public static synchronized RetrofitClient getInstance() {
        if (mInstance == null){
            mInstance = new RetrofitClient();
        }
        return mInstance;
    }

    public AccountService initAccountService() {
        return retrofit.create(AccountService.class);
    }

    public RetrofitClient initRetrofit() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        return mInstance;
    }

    public RetrofitClient initRetrofitWithBearer(Context context) {
        final String accessToken = SharedPreferencesUtils.getString(context, SharedPreferencesUtils.ACCESS_TOKEN);

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(new Interceptor() {
                    @NotNull
                    @Override
                    public Response intercept(@NotNull Chain chain) throws IOException {
                        Request request = chain.request().newBuilder()
                                .addHeader("Authorization", "Bearer " + accessToken)
                                .build();
                        return chain.proceed(request);
                    }
                })
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        return mInstance;
    }
}
