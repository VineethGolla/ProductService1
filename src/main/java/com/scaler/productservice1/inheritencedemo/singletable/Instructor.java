package com.scaler.productservice1.inheritencedemo.singletable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "stc_instructors")
public class Instructor extends User {
    private String subject;
}
