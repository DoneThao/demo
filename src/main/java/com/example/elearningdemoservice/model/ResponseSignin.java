package com.example.elearningdemoservice.model;

import lombok.Data;

@Data
public class ResponseSignin {
    private int status;
    private String token;

    public ResponseSignin(int status, String token) {
        this.status = status;
        this.token = token;
    }
}
