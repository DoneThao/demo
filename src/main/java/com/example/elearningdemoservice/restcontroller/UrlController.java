package com.example.elearningdemoservice.restcontroller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.elearningdemoservice.dto.MessageResponse;
import com.example.elearningdemoservice.model.Url;
import com.example.elearningdemoservice.service.UrlService;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/url")
public class UrlController {

    private final UrlService urlService;

    @PostMapping("/edit")
    public ResponseEntity<?> save(@Valid @RequestBody Url url) {
        urlService.save(url);
        return ResponseEntity.ok(new MessageResponse("Save url successful!!!"));
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(urlService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(urlService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        urlService.delete(id);
        return ResponseEntity.ok("Delete url successful!!!");
    }
}
