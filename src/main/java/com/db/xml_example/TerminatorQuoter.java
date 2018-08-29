package com.db.xml_example;

import lombok.Setter;
import two_annotations.Benchmark;
import two_annotations.Transactional;

import java.util.List;


public class TerminatorQuoter implements Quoter {
    @Setter
    private List<String> messages;

    @Override
    @Benchmark
    @Transactional
    public void sayQuote() {
        messages.forEach(System.out::println);
    }
}
