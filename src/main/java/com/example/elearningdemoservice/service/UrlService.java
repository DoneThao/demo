package com.example.elearningdemoservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.elearningdemoservice.model.Url;
import com.example.elearningdemoservice.repository.UrlRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UrlService {
    private final UrlRepository urlRepository;

    public List<Url> findAll() {
        return urlRepository.findAll();
    }

    public Url findById(Long id){
        return urlRepository.findById(id).orElse(null);
    }

    public void save(Url url) {
        urlRepository.save(url);
    }

    public void delete(Long id) {
        urlRepository.deleteById(id);
    }
}
