package com.hieu.prm.logrecordproject.repository;

import android.content.Context;

import com.hieu.prm.logrecordproject.response.LogResponse;
import com.hieu.prm.logrecordproject.utils.CallBackData;
import com.hieu.prm.logrecordproject.utils.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogRepositoryImpl implements LogRepository {

    private Context mContext;

    public LogRepositoryImpl(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void getLogs(final CallBackData<List<LogResponse>> callBackData) {
        Call<List<LogResponse>> call = RetrofitClient
                .getInstance()
                .initRetrofitWithBearer(mContext)
                .initLogService()
                .getAllLogs();

        call.enqueue(new Callback<List<LogResponse>>() {
            @Override
            public void onResponse(Call<List<LogResponse>> call, Response<List<LogResponse>> response) {
                if (response.isSuccessful()) {
                    callBackData.onSuccess(response.body());
                } else {
                    callBackData.onFailed(response.message());
                }
            }

            @Override
            public void onFailure(Call<List<LogResponse>> call, Throwable t) {
                callBackData.onFailed(t.getMessage());
            }
        });

    }
}
