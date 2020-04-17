package com.hieu.prm.logrecordproject.repository;

import android.content.Context;

import com.hieu.prm.logrecordproject.response.ApplicationResponse;
import com.hieu.prm.logrecordproject.utils.CallBackData;
import com.hieu.prm.logrecordproject.utils.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApplicationRepositoryImpl implements ApplicationRepository {

    private Context mContext;

    public ApplicationRepositoryImpl(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void getApplications(final CallBackData<List<ApplicationResponse>> callBackData) {
        Call<List<ApplicationResponse>> call = RetrofitClient
                .getInstance()
                .initRetrofitWithBearer(mContext)
                .initApplicationService()
                .getAllApplications();

        call.enqueue(new Callback<List<ApplicationResponse>>() {
            @Override
            public void onResponse(Call<List<ApplicationResponse>> call, Response<List<ApplicationResponse>> response) {
                if (response.isSuccessful()) {
                    callBackData.onSuccess(response.body());
                } else {
                    callBackData.onFailed(response.message());
                }
            }

            @Override
            public void onFailure(Call<List<ApplicationResponse>> call, Throwable t) {
                callBackData.onFailed(t.getMessage());
            }
        });
    }
}
