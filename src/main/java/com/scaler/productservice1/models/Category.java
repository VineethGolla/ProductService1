package com.scaler.productservice1.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "category") //for hibernate to create a table for this class
public class Category extends BaseModel{
    private String title;
//    private Long id;
//    private String name;
}
