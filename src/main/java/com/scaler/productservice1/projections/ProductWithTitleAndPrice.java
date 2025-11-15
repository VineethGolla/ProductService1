package com.scaler.productservice1.projections;

import lombok.Value;

public interface ProductWithTitleAndPrice {
//    @Value("#{target.title}")
    String getTitle();
//    @Value("#{target.price}")
    Double getPrice();
}
