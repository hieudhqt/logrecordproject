package com.hieu.prm.logrecordproject.service;

import com.hieu.prm.logrecordproject.request.LoginRequest;
import com.hieu.prm.logrecordproject.response.AccountResponse;
import com.hieu.prm.logrecordproject.response.LoginResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AccountService {

    @POST("api/accounts/login")
    Call<LoginResponse> userLogin(@Body LoginRequest loginRequest);

    @GET("api/accounts")
    Call<List<AccountResponse>> getAllAccounts();

}
