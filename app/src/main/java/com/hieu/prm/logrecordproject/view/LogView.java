package com.hieu.prm.logrecordproject.view;

import com.hieu.prm.logrecordproject.response.LogResponse;

import java.util.List;

public interface LogView {

    void onGetLogsSuccess(List<LogResponse> logResponseList);

    void onGetLogsFail(String message);

}
