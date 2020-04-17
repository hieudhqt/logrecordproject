package com.hieu.prm.logrecordproject.service;

import com.hieu.prm.logrecordproject.response.ApplicationResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApplicationService {

    @GET("api/applications")
    Call<List<ApplicationResponse>> getAllApplications();

}
