package com.db.inject_seller.services;

import com.db.inject_seller.InjectSeller;
import com.db.inject_seller.Seller;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
public class ServiceA {

    @Getter
    @InjectSeller
    private Seller seller;
}
