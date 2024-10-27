package com.example.elearningdemoservice.dto;

import lombok.Data;

import java.util.Set;

@Data
public class UserSigninResponseDTO {
    private String token;
    private String type = "Bearer";
    private Long id;
    private String username;
    private String email;
    private Set<String> roles;

    private Set<String> urls;

    public UserSigninResponseDTO(String accessToken, Long id, String username, String email, Set<String> roles, Set<String> urls) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
        this.urls = urls;
    }
}
