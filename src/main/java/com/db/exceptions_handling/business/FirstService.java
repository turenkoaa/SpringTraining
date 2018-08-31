package com.db.exceptions_handling.business;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FirstService {
    private final SecondService secondService;

    public void doWork(){
        System.out.println("First business started...");
        secondService.doWork();
    }
}
