package com.hieu.prm.logrecordproject.repository;

import com.hieu.prm.logrecordproject.response.LogResponse;
import com.hieu.prm.logrecordproject.utils.CallBackData;

import java.util.List;

public interface LogRepository {

    void getLogs(CallBackData<List<LogResponse>> callBackData);

}
