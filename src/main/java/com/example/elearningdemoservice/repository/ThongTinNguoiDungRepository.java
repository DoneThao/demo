package com.example.elearningdemoservice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.elearningdemoservice.model.ThongTinNguoiDung;


@Repository
public interface ThongTinNguoiDungRepository extends JpaRepository<ThongTinNguoiDung, Long> {
    ThongTinNguoiDung findByTen(String ten);
    Page<ThongTinNguoiDung> findAllByTenContainingOrEmailContaining(String ten, String email, Pageable pageable);




}
