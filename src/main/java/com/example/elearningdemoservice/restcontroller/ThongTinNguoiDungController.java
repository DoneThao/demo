package com.example.elearningdemoservice.restcontroller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.elearningdemoservice.dto.MessageResponse;
import com.example.elearningdemoservice.dto.ThongTinNguoiDungDTO;
import com.example.elearningdemoservice.service.ThongTinNguoiDungService;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/thongtinnguoidung")
public class ThongTinNguoiDungController {

    private final ThongTinNguoiDungService userService;
    @GetMapping
    public ResponseEntity<?> findAll( @RequestParam(value = "page", defaultValue = "0") int page,
                                      @RequestParam(value = "size", defaultValue = "3") int size,
                                      @RequestParam(value = "sortBy", defaultValue = "") String sortBy,
                                      @RequestParam(value = "sortType", defaultValue = "") String sortType,
                                      @RequestParam(value = "keyword", defaultValue = "") String search) {
        return ResponseEntity.ok(userService.findAll(search, page, size, sortBy, sortType));
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody ThongTinNguoiDungDTO userDTO) {
        userService.save(userDTO);
        return ResponseEntity.ok(new MessageResponse("Save user successful!!!"));
    }

    @PutMapping
    public ResponseEntity<?> update(@Valid @RequestBody ThongTinNguoiDungDTO userDTO) {
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