package com.scaler.productservice1.projections;

import lombok.Value;

public interface ProductWithTitleAndPrice { //Projections interfaces are used for fetching partial data from the database
//    @Value("#{target.title}")
    String getTitle();
//    @Value("#{target.price}")
    Double getPrice();
}
