package com.hieu.prm.logrecordproject.response;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationInstanceResponse implements Serializable {

    @SerializedName("id")
    private Integer id;

    @SerializedName("active")
    private Boolean active;

    @SerializedName("app_code")
    private String appCode;

    @SerializedName("app_id")
    private Integer appId;

    @SerializedName("application_version")
    private Integer applicationVer;

    @SerializedName("config_url")
    private String configUrl;

    @SerializedName("create_time")
    private String createTime;

    @SerializedName("description")
    private String description;

    @SerializedName("name")
    private String name;

    @SerializedName("release_url")
    private String releaseUrl;

    @SerializedName("update_time")
    private String updateTime;

    @SerializedName("app")
    private String app;

    @SerializedName("log")
    private List<String> log;

    @SerializedName("manage_project")
    private List<String> manageProject;

    public String getInstanceInfo() {
        return "ID: " + this.id + "\n" +
                "App code: " + this.appCode + "\n" +
                "Status: " + this.active + "\n" +
                "App ID: " + this.appId + "\n" +
                "Application version: " + this.applicationVer + "\n" +
                "Config URL: " + this.configUrl + "\n" +
                "Create Time: " + this.createTime + "\n" +
                "Description: " + this.description + "\n" +
                "Name: " + this.name + "\n" +
                "Release URL: " + this.releaseUrl + "\n" +
                "Update Time: " + this.updateTime + "\n" +
                "App: " + this.app + "\n";
    }

}
