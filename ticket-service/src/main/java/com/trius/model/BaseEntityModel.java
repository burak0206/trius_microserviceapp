package com.trius.model;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public abstract class BaseEntityModel implements Serializable {

    @CreatedDate
    @Column(name = "created_at")
    private Date cretedAt;

    @Column(name = "updated_at")
    private Date updatedAt;
}
