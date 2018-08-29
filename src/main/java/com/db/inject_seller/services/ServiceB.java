package com.db.inject_seller.services;

import com.db.inject_seller.InjectSeller;
import com.db.inject_seller.Seller;
import lombok.Getter;

public class ServiceB {

    @Getter
    @InjectSeller
    private Seller seller;
}
