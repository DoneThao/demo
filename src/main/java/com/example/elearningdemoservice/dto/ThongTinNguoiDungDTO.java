package com.example.elearningdemoservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class ThongTinNguoiDungDTO {
    private Long id;
    private String ten;
    private String email;
    private int gioiTinh;
    private List<String> soThich;

}
