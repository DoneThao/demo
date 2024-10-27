package com.example.elearningdemoservice.restcontroller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.elearningdemoservice.dto.MessageResponse;
import com.example.elearningdemoservice.model.Role;
import com.example.elearningdemoservice.service.RoleService;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/role")
public class RoleController {

    private final RoleService roleService;

    @PostMapping("/edit")
    public ResponseEntity<?> save(@Valid @RequestBody Role role) {
        roleService.save(role);
        return ResponseEntity.ok(new MessageResponse("Save role successful!!!"));
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(roleService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(roleService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        roleService.delete(id);
        return ResponseEntity.ok("Delete role successful!!!");
    }
}
