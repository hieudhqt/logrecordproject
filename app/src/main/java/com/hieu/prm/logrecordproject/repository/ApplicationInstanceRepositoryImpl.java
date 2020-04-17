package com.hieu.prm.logrecordproject.repository;

import android.content.Context;

import com.hieu.prm.logrecordproject.response.ApplicationInstanceResponse;
import com.hieu.prm.logrecordproject.utils.CallBackData;
import com.hieu.prm.logrecordproject.utils.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApplicationInstanceRepositoryImpl implements ApplicationInstanceRepository {

    private Context mContext;

    public ApplicationInstanceRepositoryImpl(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void getApplicationInstances(final CallBackData<List<ApplicationInstanceResponse>> callBackData) {
        Call<List<ApplicationInstanceResponse>> call = RetrofitClient
                .getInstance()
                .initRetrofitWithBearer(mContext)
                .initApplicationInstanceSerivce()
                .getAllApplicationInstances();

        call.enqueue(new Callback<List<ApplicationInstanceResponse>>() {
            @Override
            public void onResponse(Call<List<ApplicationInstanceResponse>> call, Response<List<ApplicationInstanceResponse>> response) {
                if (response.isSuccessful()) {
                    callBackData.onSuccess(response.body());
                } else {
                    callBackData.onFailed(response.message());
                }
            }

            @Override
            public void onFailure(Call<List<ApplicationInstanceResponse>> call, Throwable t) {
                callBackData.onFailed(t.getMessage());
            }
        });
    }
}
