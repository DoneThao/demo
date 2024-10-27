package com.example.elearningdemoservice.restcontroller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.elearningdemoservice.dto.MessageResponse;
import com.example.elearningdemoservice.dto.UserDTO;
import com.example.elearningdemoservice.service.UserService;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/user")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDTO> allUsers() {

        System.out.println("123");
        return userService.getAllUsers();
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody UserDTO userDTO) {
        userService.save(userDTO);
        return ResponseEntity.ok(new MessageResponse("Save user successful!!!"));
    }

    @PutMapping
    public ResponseEntity<?> update(@Valid @RequestBody UserDTO userDTO) {
        userService.update(userDTO);
        return ResponseEntity.ok(new MessageResponse("Save user successful!!!"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.ok("Delete user successful!!!");
    }
}