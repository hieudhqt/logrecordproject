//For saving user information after login
package com.hieu.prm.logrecordproject.model;

public class UserCache {
    private int id;
    private String token;
    private int role;
    private String email;

    public UserCache(int id, String token, int role, String email) {
        this.id = id;
        this.token = token;
        this.role = role;
        this.email = email;
    }

    public UserCache(int id, int role, String email) {
        this.id = id;
        this.role = role;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    public int getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
