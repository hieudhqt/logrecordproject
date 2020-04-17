package com.hieu.prm.logrecordproject.presenter;

import android.content.Context;

import com.google.gson.Gson;
import com.hieu.prm.logrecordproject.repository.ApplicationInstanceRepository;
import com.hieu.prm.logrecordproject.repository.ApplicationInstanceRepositoryImpl;
import com.hieu.prm.logrecordproject.response.ApplicationInstanceResponse;
import com.hieu.prm.logrecordproject.utils.CallBackData;
import com.hieu.prm.logrecordproject.utils.SharedPreferencesUtils;
import com.hieu.prm.logrecordproject.view.ApplicationInstanceView;

import java.util.List;

public class ApplicationInstancePresenter {

    private Context mContext;

    private ApplicationInstanceView applicationInstanceView;

    private ApplicationInstanceRepository applicationInstanceRepository;

    public ApplicationInstancePresenter(Context mContext, ApplicationInstanceView applicationInstanceView) {
        this.mContext = mContext;
        this.applicationInstanceView = applicationInstanceView;
        applicationInstanceRepository = new ApplicationInstanceRepositoryImpl(mContext);
    }

    public void getApplicationInstances() {
        applicationInstanceRepository.getApplicationInstances(new CallBackData<List<ApplicationInstanceResponse>>() {
            @Override
            public void onSuccess(List<ApplicationInstanceResponse> type) {
                Gson gson = new Gson();
                String json = gson.toJson(type);
                SharedPreferencesUtils.saveString(mContext, SharedPreferencesUtils.APP_INSTANCE_LIST,json);

                applicationInstanceView.onGetApplicationInstancesSuccess(type);
            }

            @Override
            public void onFailed(String message) {
                applicationInstanceView.onGetApplicationInstancesFail(message);
            }
        });
    }
}
