package com.example.elearningdemoservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.example.elearningdemoservice.dto.ThongTinNguoiDungDTO;
import com.example.elearningdemoservice.mapper.ThongTinNguoiDungMapper;
import com.example.elearningdemoservice.model.ThongTinNguoiDung;
import com.example.elearningdemoservice.repository.ThongTinNguoiDungRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ThongTinNguoiDungService {
    private final ThongTinNguoiDungRepository thongTinNguoiDungRepository;
    private final ThongTinNguoiDungMapper thongTinNguoiDungMapper;

    public Page<ThongTinNguoiDung> findAll(String keyword, int page, int size, String sortBy, String sortType) {
        if (size == -1) {
            size = Integer.MAX_VALUE;
        }
        List<Sort.Order> orders = new ArrayList<>();
        if (sortBy.length() > 0) {
            Sort.Direction dire = sortType == "desc" ? Sort.Direction.DESC:Sort.Direction.ASC;
            orders.add(new Sort.Order(dire, sortBy));
        } else {
            orders.add(new Sort.Order(Sort.Direction.DESC, "ten"));
        }
        Pageable paging = PageRequest.of(page, size, Sort.by(orders));
        return thongTinNguoiDungRepository.findAllByTenContainingOrEmailContaining(keyword, keyword, paging);
    }

    public List<ThongTinNguoiDungDTO> getAllUsers() {
        return thongTinNguoiDungMapper.listThongTinToListThongTinDTO(thongTinNguoiDungRepository.findAll());
    }

    public ThongTinNguoiDungDTO findById(Long id){
        return thongTinNguoiDungMapper.thongTinNguoiDungToThongTinNguoiDungDTO(thongTinNguoiDungRepository.findById(id).orElse(null));
    }
    public void save(ThongTinNguoiDungDTO userDTO) {

        thongTinNguoiDungRepository.save(thongTinNguoiDungMapper.thongTinNguoiDungDTOToThongTinNguoiDung(userDTO));
    }

    public void update(ThongTinNguoiDungDTO userDTO) {
        ThongTinNguoiDung user = thongTinNguoiDungRepository.findById(userDTO.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Khong tim thay tai nguyen!!!"));

        thongTinNguoiDungRepository.save(thongTinNguoiDungMapper.thongTinNguoiDungDTOToThongTinNguoiDung(userDTO));
    }

    public void delete(Long id) {
        thongTinNguoiDungRepository.deleteById(id);
    }
}
