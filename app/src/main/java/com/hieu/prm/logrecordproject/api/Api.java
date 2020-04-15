package com.hieu.prm.logrecordproject.api;

import com.hieu.prm.logrecordproject.model.UserCache;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {

    @FormUrlEncoded
    @POST("api/accounts/login")
    Call<UserCache> userLogin(
            @Field("email") String email,
            @Field("password") String password
    );
}
