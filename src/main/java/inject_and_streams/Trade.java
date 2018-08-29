package inject_and_streams;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Trade {
    String good;
    int price;
}
