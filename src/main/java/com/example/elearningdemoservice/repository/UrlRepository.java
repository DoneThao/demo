package com.example.elearningdemoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.elearningdemoservice.model.Url;

import java.util.Set;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {
    @Query(
            value = "SELECT DISTINCT(u.path) FROM url u JOIN permission_url p on p.url_id = u.id " +
                    "JOIN permission_role pr on pr.permission_id = p.permission_id " +
                    "JOIN user_role ur on ur.role_id = pr.role_id WHERE ur.user_id = ? ",
            nativeQuery = true)
    Set<String> findUrlByUserId(Long userId);
}
