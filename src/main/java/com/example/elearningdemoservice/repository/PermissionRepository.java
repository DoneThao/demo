package com.example.elearningdemoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.elearningdemoservice.model.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
