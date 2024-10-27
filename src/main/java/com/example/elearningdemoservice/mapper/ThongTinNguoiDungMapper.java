package com.example.elearningdemoservice.mapper;

import org.mapstruct.Mapper;
import com.example.elearningdemoservice.dto.ThongTinNguoiDungDTO;
import com.example.elearningdemoservice.model.ThongTinNguoiDung;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ThongTinNguoiDungMapper {
    ThongTinNguoiDung thongTinNguoiDungDTOToThongTinNguoiDung(ThongTinNguoiDungDTO thongTinNguoiDungDTO);
    ThongTinNguoiDungDTO thongTinNguoiDungToThongTinNguoiDungDTO(ThongTinNguoiDung thongTinNguoiDung);
    List<ThongTinNguoiDungDTO> listThongTinToListThongTinDTO(List<ThongTinNguoiDung> thongTinNguoiDungs);
}
