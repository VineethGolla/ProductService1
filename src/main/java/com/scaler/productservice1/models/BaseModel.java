package com.scaler.productservice1.models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id //Primary key coming from here. This is PK for all the tables extending this class
    private Long id;
    private Date createdAt;
    private Date lastModifiedAt;
}
