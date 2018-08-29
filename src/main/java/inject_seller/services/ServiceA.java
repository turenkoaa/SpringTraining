package inject_seller.services;

import inject_seller.InjectSeller;
import inject_seller.Seller;
import lombok.Getter;

public class ServiceA {

    @Getter
    @InjectSeller
    private Seller seller;
}
