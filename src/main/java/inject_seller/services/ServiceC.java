package inject_seller.services;

import inject_seller.InjectSeller;
import inject_seller.Seller;
import lombok.Getter;

public class ServiceC {

    @Getter
    @InjectSeller
    private Seller seller;
}
