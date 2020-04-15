package com.hieu.prm.logrecordproject.repository;

import com.hieu.prm.logrecordproject.request.LoginRequest;
import com.hieu.prm.logrecordproject.response.LoginResponse;
import com.hieu.prm.logrecordproject.utils.CallBackData;
import com.hieu.prm.logrecordproject.utils.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AccountRepositoryImpl implements AccountRepository {

    @Override
    public void getLoginResponse(String email, String password, final CallBackData<LoginResponse> callBackData) {
        LoginRequest loginRequest = new LoginRequest(email, password);

        Call<LoginResponse> call = RetrofitClient
                .getInstance()
                .initAccountService()
                .userLogin(loginRequest);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    callBackData.onSuccess(response.body());
                }
            }
            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                callBackData.onFailed(t.getMessage());
            }
        });
    }
}
