package com.example.huellitas.model;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("id")
    private String id;
    @SerializedName("email")
    private String email;

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
