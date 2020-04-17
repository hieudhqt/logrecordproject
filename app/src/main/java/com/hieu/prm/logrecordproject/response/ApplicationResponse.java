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
public class ApplicationResponse implements Serializable {

    @SerializedName("log_count")
    private Integer logCount;

    @SerializedName("id")
    private Integer id;

    @SerializedName("active")
    private Boolean active;

    @SerializedName("category")
    private Integer category;

    @SerializedName("create_time")
    private String createTime;

    @SerializedName("description")
    private String description;

    @SerializedName("efford")
    private String efford;

    @SerializedName("end_date")
    private String endDate;

    @SerializedName("is_done")
    private Boolean isDone;

    @SerializedName("name")
    private String name;

    @SerializedName("note")
    private String note;

    @SerializedName("origin")
    private String origin;

    @SerializedName("priority")
    private Integer priority;

    @SerializedName("source_code_url")
    private String sourceCodeUrl;

    @SerializedName("stage")
    private Integer stage;

    @SerializedName("start_date")
    private String startDate;

    @SerializedName("status")
    private Integer status;

    @SerializedName("system_id")
    private Integer systemId;

    @SerializedName("team")
    private Integer team;

    @SerializedName("technologies")
    private String tech;

    @SerializedName("type")
    private String type;

    @SerializedName("update_time")
    private String updateTime;

    @SerializedName("system")
    private String systems;

    @SerializedName("application_instance")
    private List<ApplicationInstanceResponse> applicationInstances;

    @SerializedName("manage_project")
    private List<String> manageProjects;

    @SerializedName("repo")
    private List<String> repo;

    public String getApplicationInfo() {
        return "ID: " + this.id + "\n" +
                "Log count: " + this.logCount + "\n" +
                "Active: " + this.active + "\n" +
                "Category: " + this.category + "\n" +
                "Create time: " + this.createTime + "\n" +
                "Description: " + this.description + "\n" +
                "Create Time: " + this.createTime + "\n" +
                "Description: " + this.description + "\n" +
                "Name: " + this.name + "\n" +
                "Efford: " + this.efford + "\n" +
                "Update Time: " + this.updateTime + "\n" +
                "Start date: " + this.startDate + "\n" +
                "End date: " + this.endDate + "\n" +
                "Is done: " + this.isDone + "\n" +
                "Note: " + this.note + "\n" +
                "Origin: " + this.origin + "\n" +
                "Priority: " + this.priority + "\n" +
                "Source code URL: " + this.sourceCodeUrl + "\n" +
                "Stage: " + this.stage + "\n" +
                "Start date: " + this.startDate + "\n" +
                "Status: " + this.status + "\n" +
                "System ID: " + this.systemId + "\n" +
                "System: " + this.systems + "\n" +
                "Team: " + this.team + "\n" +
                "Technologies: " + this.tech + "\n" +
                "Type: " + this.type + "\n" +
                "Update time: " + this.updateTime + "\n";
    }
}
