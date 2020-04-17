//For saving user information after login
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
public class AccountResponse implements Serializable {

    @SerializedName("id")
    private int id;

    @SerializedName("active")
    private boolean active;

    @SerializedName("address")
    private String address;

    @SerializedName("asp_net_user_id")
    private String aspNetUserId;

    @SerializedName("email")
    private String email;

    @SerializedName("name")
    private String name;

    @SerializedName("phone")
    private String phone;

    @SerializedName("role")
    private int role;

    @SerializedName("asp_net_user")
    private String aspNetUser;

    @SerializedName("manage_project")
    private List<String> manageProjects;

    public String getAccountInfo() {
        return "ID: " + this.id + "\n" +
                "Name: " + this.name + "\n" +
                "Status: " + this.active + "\n" +
                "Address: " + this.address + "\n" +
                "ASP .Net UserID: " + this.aspNetUserId + "\n" +
                "ASP .Net User: " + this.aspNetUser + "\n" +
                "Email: " + this.email + "\n" +
                "Phone: " + this.phone + "\n" +
                "Role: " + this.role + "\n";
    }

}
