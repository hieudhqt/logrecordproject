package com.hieu.prm.logrecordproject.presenter;

import android.content.Context;

import com.google.gson.Gson;
import com.hieu.prm.logrecordproject.repository.LogRepository;
import com.hieu.prm.logrecordproject.repository.LogRepositoryImpl;
import com.hieu.prm.logrecordproject.response.LogResponse;
import com.hieu.prm.logrecordproject.utils.CallBackData;
import com.hieu.prm.logrecordproject.utils.SharedPreferencesUtils;
import com.hieu.prm.logrecordproject.view.LogView;

import java.util.List;

public class LogPresenter {

    private Context mContext;

    private LogView logView;

    private LogRepository logRepository;

    public LogPresenter(Context mContext, LogView logView) {
        this.mContext = mContext;
        this.logView = logView;
        logRepository = new LogRepositoryImpl(mContext);
    }

    public void getLogs() {
        logRepository.getLogs(new CallBackData<List<LogResponse>>() {
            @Override
            public void onSuccess(List<LogResponse> type) {
                Gson gson = new Gson();
                String json = gson.toJson(type);
                SharedPreferencesUtils.saveString(mContext, SharedPreferencesUtils.LOG_LIST,json);

                logView.onGetLogsSuccess(type);
            }

            @Override
            public void onFailed(String message) {
                logView.onGetLogsFail(message);
            }
        });
    }
}
