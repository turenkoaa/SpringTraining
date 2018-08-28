package com.db.xml_example;

import lombok.Setter;

public class ShakeSpearQuoter implements Quoter {
    @Setter
    private String message;

    @Override
    public void sayQuote() {
        System.out.println(message);
    }
}
