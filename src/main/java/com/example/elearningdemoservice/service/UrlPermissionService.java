package com.example.elearningdemoservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;
import com.example.elearningdemoservice.model.Url;
import com.example.elearningdemoservice.repository.UrlRepository;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UrlPermissionService {

    private final UrlRepository urlRepository;
    private final static AntPathMatcher ANT_PATH_MATCHER = new AntPathMatcher();

    public String[] getTaiNguyenByUrl(String requestUrl) {
        List<Url> urls = urlRepository.findAll();
        HashMap<String, String[]> urlsMap = new HashMap<>();
        urls.forEach(urlModel -> {
            urlsMap.put(urlModel.getPath(), urlModel.getPermissions().stream().map(
                    permission -> permission.getName()).toArray(String[]::new));
        });

        for (String key : urlsMap.keySet()) {
            if (ANT_PATH_MATCHER.match(key, requestUrl)) {
                return urlsMap.get(key);
            }
        }
        return new String[0];
    }

    public List<Url> getListUrl() {
        return urlRepository.findAll();
    }

    public Url findById(long id) {
        return urlRepository.getById(id);
    }

    public Url saveUrl(Url url) {
        return urlRepository.save(url);
    }

    public void deleteUrl(long id) {
        urlRepository.deleteById(id);
    }
}
