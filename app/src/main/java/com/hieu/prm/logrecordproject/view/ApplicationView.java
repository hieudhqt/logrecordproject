package com.hieu.prm.logrecordproject.view;

import com.hieu.prm.logrecordproject.response.ApplicationResponse;

import java.util.List;

public interface ApplicationView {

    void onGetApplicationsSuccess(List<ApplicationResponse> applicationResponseList);

    void onGetApplicationsFail(String message);

}
