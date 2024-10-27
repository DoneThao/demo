package com.example.elearningdemoservice.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserSigninRequestDTO {
    @NotBlank
    private String username;

    @NotBlank
    private String password;
}