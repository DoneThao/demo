package com.example.elearningdemoservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.elearningdemoservice.dto.RoleDTO;
import com.example.elearningdemoservice.mapper.RoleMapper;
import com.example.elearningdemoservice.model.Role;
import com.example.elearningdemoservice.repository.RoleRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public List<RoleDTO> findAll() {
        return roleMapper.listRoleToListRoleDTO(roleRepository.findAll());
    }

    public Role findById(Long id){
        return roleRepository.findById(id).orElse(null);
    }

    public void save(Role role) {
        roleRepository.save(role);
    }

    public void delete(Long id) {
        roleRepository.deleteById(id);
    }
}
