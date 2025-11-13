package com.scaler.productservice1.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id //Primary key coming from here. This is PK for all the tables extending this class
    @GeneratedValue(strategy= GenerationType.IDENTITY) //Auto incrementing primary key
    private Long id;
    private Date createdAt;
    private Date lastModifiedAt;
}
