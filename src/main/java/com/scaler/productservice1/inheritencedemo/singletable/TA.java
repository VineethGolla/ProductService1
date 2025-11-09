package com.scaler.productservice1.inheritencedemo.singletable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "stc_tas")
public class TA extends User {
    private int numberOfHRs;
    private Double avgRating;
}
