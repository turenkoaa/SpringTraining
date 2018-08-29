package model;

import benchmark_and_transactional.Benchmark;
import benchmark_and_transactional.Transactional;
import deprecated.DeprecatedClass;
import deprecated.T1000;
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
