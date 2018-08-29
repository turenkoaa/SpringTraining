package inject_seller;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

@Data
@Builder
public class Seller {

    @Singular
    private List<Trade> trades;
    private String name;
}
