package com.example.elearningdemoservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.elearningdemoservice.model.Permission;
import com.example.elearningdemoservice.repository.PermissionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PermissionService {
    private final PermissionRepository permissionRepository;

    public List<Permission> findAll() {
        return permissionRepository.findAll();
    }

    public Permission findById(Long id){
        return permissionRepository.findById(id).orElse(null);
    }

    public void save(Permission permission) {
        permissionRepository.save(permission);
    }

    public void delete(Long id) {
        permissionRepository.deleteById(id);
    }
}
