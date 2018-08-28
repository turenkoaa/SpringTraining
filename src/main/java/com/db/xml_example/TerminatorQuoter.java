package com.db.xml_example;

import lombok.Data;
import lombok.Setter;

import java.util.List;


public class TerminatorQuoter implements Quoter {
    @Setter
    private List<String> messages;

    @Override
    public void sayQuote() {
        messages.forEach(System.out::println);
    }
}
