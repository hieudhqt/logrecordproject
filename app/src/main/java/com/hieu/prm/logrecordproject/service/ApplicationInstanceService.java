package com.hieu.prm.logrecordproject.service;

import com.hieu.prm.logrecordproject.response.ApplicationInstanceResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApplicationInstanceService {

    @GET("api/application_instances")
    Call<List<ApplicationInstanceResponse>> getAllApplicationInstances();

}
