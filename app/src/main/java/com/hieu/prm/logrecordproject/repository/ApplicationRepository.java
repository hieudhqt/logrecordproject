package com.hieu.prm.logrecordproject.repository;

import com.hieu.prm.logrecordproject.response.ApplicationResponse;
import com.hieu.prm.logrecordproject.utils.CallBackData;

import java.util.List;

public interface ApplicationRepository {

    void getApplications(CallBackData<List<ApplicationResponse>> callBackData);

}
