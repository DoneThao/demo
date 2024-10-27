package com.example.elearningdemoservice.restcontroller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.elearningdemoservice.dto.MessageResponse;
import com.example.elearningdemoservice.model.Permission;
import com.example.elearningdemoservice.service.PermissionService;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/permission")
public class PermissionController {

    private final PermissionService permissionService;

    @PostMapping("/edit")
    public ResponseEntity<?> save(@Valid @RequestBody Permission permission) {
        permissionService.save(permission);
        return ResponseEntity.ok(new MessageResponse("Save permission successful!!!"));
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(permissionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(permissionService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        permissionService.delete(id);
        return ResponseEntity.ok("Delete permission successful!!!");
    }
}
