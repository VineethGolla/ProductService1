package com.scaler.productservice1.inheritencedemo.joinedtable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "jtc_instructors")
public class Instructor extends User {
    private String subject;
}
