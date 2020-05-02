package com.example.huellitas.model;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("id")
    private String id;
    @SerializedName("email")
    private String email;
    @SerializedName("code")
    private String code;
    @SerializedName("mensaje")
    private String mensaje;


    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getCode() {
        return code;
    }

    public String getMensaje() {
        return mensaje;
    }
}
