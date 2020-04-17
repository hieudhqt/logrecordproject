package com.hieu.prm.logrecordproject.presenter;

import android.content.Context;

import com.google.gson.Gson;
import com.hieu.prm.logrecordproject.repository.ApplicationRepository;
import com.hieu.prm.logrecordproject.repository.ApplicationRepositoryImpl;
import com.hieu.prm.logrecordproject.response.ApplicationResponse;
import com.hieu.prm.logrecordproject.utils.CallBackData;
import com.hieu.prm.logrecordproject.utils.SharedPreferencesUtils;
import com.hieu.prm.logrecordproject.view.ApplicationView;

import java.util.List;

public class ApplicationPresenter {

    private Context mContext;

    private ApplicationView applicationView;

    private ApplicationRepository applicationRepository;

    public ApplicationPresenter(Context mContext, ApplicationView applicationView) {
        this.mContext = mContext;
        this.applicationView = applicationView;
        applicationRepository = new ApplicationRepositoryImpl(mContext);
    }

    public void getApplications() {
        applicationRepository.getApplications(new CallBackData<List<ApplicationResponse>>() {
            @Override
            public void onSuccess(List<ApplicationResponse> type) {
                Gson gson = new Gson();
                String json = gson.toJson(type);
                SharedPreferencesUtils.saveString(mContext, SharedPreferencesUtils.APPLICATION_LIST,json);

                applicationView.onGetApplicationsSuccess(type);
            }

            @Override
            public void onFailed(String message) {
                applicationView.onGetApplicationsFail(message);
            }
        });
    }
}
