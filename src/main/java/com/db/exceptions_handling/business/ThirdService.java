package com.db.exceptions_handling.business;

import com.db.exceptions_handling.DataBaseRuntimeException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ThirdService {

    @Retryable(
            value = { DataBaseRuntimeException.class },
            maxAttempts = 5,
            backoff = @Backoff(delay = 1000))
    public void willThrowDBException(){
        if (new Random().nextInt(5) != 3) {
            System.out.println("I will throw!");
            throw new DataBaseRuntimeException("Data base exception occurred");
        }
        System.out.println("It is ok!");
    }
}
