package com.scaler.productservice1.inheritencedemo.joinedtable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="jtc_mentors")
public class Mentor extends User {
    private String company;
    private Double avgRating;
}
