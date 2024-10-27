package com.example.elearningdemoservice.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import com.example.elearningdemoservice.service.UrlPermissionService;

import java.util.*;

@Component
@RequiredArgsConstructor
public class UrlFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    private final static AntPathMatcher ANT_PATH_MATCHER = new AntPathMatcher();
    private final UrlPermissionService urlTaiNguyenService;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        FilterInvocation filterInvocation = (FilterInvocation) object;
        String requestUrl = filterInvocation.getRequestUrl();
        Set<String> permitSet = permitAll();
        if (!permitSet.isEmpty()) {
            for (String matcher : permitSet) {
                if (ANT_PATH_MATCHER.match(matcher, requestUrl)) {
                    return null;
                }
            }
        }
        String[] permissions = findByPath(requestUrl);
        if (permissions.length > 0) {
            return createList(permissions);
        }
        return createList("login");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }

    private List<ConfigAttribute> createList(String... attributeNames) {
        return org.springframework.security.access.SecurityConfig.createList(attributeNames);
    }

    private Set<String> permitAll() {
        return new HashSet<>(Arrays.asList("/error", "/favicon.ico", "/open/**", "/dangnhap", "/dangnhap?**", "/doimatkhau", "/doimatkhau/**", "/swagger-ui.html", "/api/auth/**","/**"));
    }

    private String[] findByPath(String requestUrl) {
        return urlTaiNguyenService.getTaiNguyenByUrl(requestUrl);
    }

}
