package inject_and_streams.services;

import inject_and_streams.InjectSeller;
import inject_and_streams.Seller;
import lombok.Getter;

public class ServiceC {

    @Getter
    @InjectSeller
    private Seller seller;
}
