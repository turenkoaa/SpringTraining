package com.db.model;

import com.db.benchmark_and_transactional.Benchmark;
import com.db.benchmark_and_transactional.Transactional;
import com.db.deprecated.DeprecatedClass;
import com.db.deprecated.T1000;
import lombok.Setter;

import java.util.List;

@DeprecatedClass(alternative = T1000.class)
public class Terminator implements Quoter {
    @Setter
    private List<String> messages;

    @Override
    @Benchmark
    @Transactional
    public void sayQuote() {
        messages.forEach(System.out::println);
    }

}
