package com.example.elearningdemoservice.dto;

import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private String password;
    private Date ngaySua;
    private Date ngayTao;
    private String nguoiSua;
    private String nguoiTao;
    private Set<RoleDTO> roles;
}
