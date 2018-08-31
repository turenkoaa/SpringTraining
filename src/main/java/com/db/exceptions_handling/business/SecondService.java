package com.db.exceptions_handling.business;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecondService {
    private final ThirdService thirdService;

    public void doWork(){
        thirdService.willThrowDBException();
    }
}
