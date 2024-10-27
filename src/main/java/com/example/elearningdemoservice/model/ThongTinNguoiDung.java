package com.example.elearningdemoservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ThongTinNguoiDung extends Auditable<String> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ten;
    private String email;
    private int gioiTinh;
    @ElementCollection
    private List<String> soThich;

}
