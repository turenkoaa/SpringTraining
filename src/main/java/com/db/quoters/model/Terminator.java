package com.db.quoters.model;

import com.db.quoters.deprecated.DeprecatedClass;
import com.db.quoters.deprecated.T1000;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@DeprecatedClass(alternative = T1000.class)
public class Terminator implements Quoter {

    private List<String> messages;

    @Value("${terminator.quotes}")
    protected void setMessages(String line){
        messages = Arrays.stream(line.split(","))
                            .map(String::trim)
                            .collect(Collectors.toList());
    }

    @Override
//    @Benchmark
//    @Transactional
    public void sayQuote() {
        messages.forEach(System.out::println);
    }

}
