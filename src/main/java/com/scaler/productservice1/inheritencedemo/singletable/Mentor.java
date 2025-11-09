package com.scaler.productservice1.inheritencedemo.singletable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "stc_mentors")
public class Mentor extends User {
    private String company;
    private Double avgRating;
}
