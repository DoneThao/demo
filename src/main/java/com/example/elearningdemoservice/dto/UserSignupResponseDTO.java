package com.example.elearningdemoservice.dto;

import lombok.Data;

@Data
public class UserSignupResponseDTO {
    private String token;

    public UserSignupResponseDTO(String token) {
        this.token = token;
    }
}
