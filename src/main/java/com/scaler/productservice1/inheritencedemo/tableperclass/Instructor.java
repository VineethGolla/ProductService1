package com.scaler.productservice1.inheritencedemo.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name= "tpc_instructors")
public class Instructor extends User {
    private String subject;
}
