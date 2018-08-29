package com.db.inject_seller;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Trade {
    String good;
    int price;
}
