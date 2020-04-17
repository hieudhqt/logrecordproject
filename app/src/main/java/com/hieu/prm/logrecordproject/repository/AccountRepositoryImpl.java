package com.hieu.prm.logrecordproject.repository;

import android.content.Context;

import com.hieu.prm.logrecordproject.request.LoginRequest;
import com.hieu.prm.logrecordproject.response.AccountResponse;
import com.hieu.prm.logrecordproject.response.LoginResponse;
import com.hieu.prm.logrecordproject.utils.CallBackData;
import com.hieu.prm.logrecordproject.utils.RetrofitClient;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Data
@NoArgsConstructor
public class AccountRepositoryImpl implements AccountRepository {

    private Context mContext;

    public AccountRepositoryImpl(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void getLoginResponse(String email, String password, final CallBackData<LoginResponse> callBackData) {
        LoginRequest loginRequest = new LoginRequest(email, password);

        Call<LoginResponse> call = RetrofitClient
                .getInstance()
                .initRetrofit()
                .initAccountService()
                .userLogin(loginRequest);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    callBackData.onSuccess(response.body());
                } else {
                    callBackData.onFailed(response.message());
                }
            }
            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                callBackData.onFailed(t.getMessage());
            }
        });
    }

    @Override
    public void getAccountResponse(final CallBackData<List<AccountResponse>> callBackData) {
        Call<List<AccountResponse>> call = RetrofitClient
                .getInstance()
                .initRetrofitWithBearer(mContext)
                .initAccountService()
                .getAllAccounts();

        call.enqueue(new Callback<List<AccountResponse>>() {
            @Override
            public void onResponse(Call<List<AccountResponse>> call, Response<List<AccountResponse>> response) {
                if (response.isSuccessful()) {
                    callBackData.onSuccess(response.body());
                } else {
                    callBackData.onFailed(response.message());
                }
            }

            @Override
            public void onFailure(Call<List<AccountResponse>> call, Throwable t) {
                callBackData.onFailed(t.getMessage());
            }
        });
    }
}
