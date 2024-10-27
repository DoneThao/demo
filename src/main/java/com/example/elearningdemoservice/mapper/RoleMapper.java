package com.example.elearningdemoservice.mapper;

import org.mapstruct.Mapper;
import com.example.elearningdemoservice.dto.RoleDTO;
import com.example.elearningdemoservice.model.Role;

import java.util.List;

@Mapper(componentModel = "spring")

public interface RoleMapper {
    RoleDTO roleToRoleDTO(Role role);
    List<RoleDTO> listRoleToListRoleDTO(List<Role> roles);
}
