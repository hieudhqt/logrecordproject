package com.hieu.prm.logrecordproject.view;

import com.hieu.prm.logrecordproject.response.ApplicationInstanceResponse;

import java.util.List;

public interface ApplicationInstanceView {

    void onGetApplicationInstancesSuccess(List<ApplicationInstanceResponse> applicationInstanceResponseList);

    void onGetApplicationInstancesFail(String message);

}
