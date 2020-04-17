package com.hieu.prm.logrecordproject.response;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogResponse implements Serializable {

    @SerializedName("id")
    private Integer id;

    @SerializedName("active")
    private Boolean active;

    @SerializedName("app_code")
    private String appCode;

    @SerializedName("error_code_id")
    private Integer errorCodeId;

    @SerializedName("file_name")
    private String fileName;

    @SerializedName("line_code")
    private Integer lineCode;

    @SerializedName("log_date")
    private String logDate;

    @SerializedName("log_type")
    private Integer logType;

    @SerializedName("message")
    private String message;

    @SerializedName("project_name")
    private String projectName;

    @SerializedName("serverity")
    private Integer serverity;

    @SerializedName("app_code_navigation")
    private Integer appCodeNavigation;

    @SerializedName("error_code")
    private Integer errorCode;

    public String getLogInfo() {
        return "ID: " + this.id + "\n" +
                "App code: " + this.appCode + "\n" +
                "Status: " + this.active + "\n" +
                "Error code ID: " + this.errorCodeId + "\n" +
                "Error code: " + this.errorCode + "\n" +
                "File name: " + this.fileName + "\n" +
                "Line of code: " + this.lineCode + "\n" +
                "Log Date: " + this.logDate + "\n" +
                "Log type: " + this.logType + "\n" +
                "Message: " + this.message + "\n" +
                "Project name: " + this.projectName + "\n" +
                "Serverity: " + this.serverity + "\n" +
                "App code navigation: " + this.appCodeNavigation + "\n";
    }

}