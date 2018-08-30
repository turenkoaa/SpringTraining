package com.db.quoters.model;

import com.db.quoters.inject_random_int.InjectRandomInt;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class Shakespear implements Quoter {
    @Getter
    @InjectRandomInt(min = 0, max = 10)
    private int number;

    @Value("${quote}")
    private String message;

    @Override
    public void sayQuote() {
        for (int i = 0; i < number; i++) {
            System.out.println(message);
        }
    }
}
