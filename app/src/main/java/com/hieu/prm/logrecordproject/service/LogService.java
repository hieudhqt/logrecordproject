package com.hieu.prm.logrecordproject.service;

import com.hieu.prm.logrecordproject.response.LogResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LogService {

    @GET("api/logs")
    Call<List<LogResponse>> getAllLogs();

}
