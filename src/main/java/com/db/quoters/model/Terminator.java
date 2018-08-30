package com.db.quoters.model;

import com.db.quoters.benchmark_and_transactional.Benchmark;
import com.db.quoters.benchmark_and_transactional.Transactional;
import com.db.quoters.deprecated.DeprecatedClass;
import com.db.quoters.deprecated.T1000;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@DeprecatedClass(alternative = T1000.class)
public class Terminator implements Quoter {

    @Value("${terminator.quotes}")
    private List<String> messages;

    @Override
    @Benchmark
    @Transactional
    public void sayQuote() {
        messages.forEach(System.out::println);
    }

}
