package com.hieu.prm.logrecordproject.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;

@Data
public class LoginResponse {

    @SerializedName("id")
    private int id;

    @SerializedName("token")
    private String token;

    @SerializedName("role")
    private int role;

    @SerializedName("email")
    private String email;

    @SerializedName("manage_project")
    private List<ProjectResponse> manageProject;
}
