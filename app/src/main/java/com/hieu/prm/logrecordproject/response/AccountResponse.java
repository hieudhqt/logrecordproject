//For saving user information after login
package com.hieu.prm.logrecordproject.response;

import lombok.Data;

@Data
public class AccountResponse {

    private int id;
    private String token;
    private int role;
    private String email;

    public AccountResponse(int id, int role, String email) {
        this.id = id;
        this.role = role;
        this.email = email;
    }
}
