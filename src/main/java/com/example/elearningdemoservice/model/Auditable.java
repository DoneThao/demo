package com.example.elearningdemoservice.model;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
@Accessors(chain = true)
public class Auditable<U> {
    @CreatedDate
    private Date ngayTao;

    @LastModifiedDate
    private Date ngaySua;

    @CreatedBy
    private U nguoiTao;

    @LastModifiedBy
    private U nguoiSua;
}
