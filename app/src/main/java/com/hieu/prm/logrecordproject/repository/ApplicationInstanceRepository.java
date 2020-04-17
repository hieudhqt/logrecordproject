package com.hieu.prm.logrecordproject.repository;

import com.hieu.prm.logrecordproject.response.ApplicationInstanceResponse;
import com.hieu.prm.logrecordproject.utils.CallBackData;

import java.util.List;

public interface ApplicationInstanceRepository {

    void getApplicationInstances(CallBackData<List<ApplicationInstanceResponse>> callBackData);

}
