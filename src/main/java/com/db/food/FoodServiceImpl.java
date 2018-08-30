package com.db.food;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class FoodServiceImpl implements FoodService {

    @Scheduled(cron = "0/1 * * * * *")
    @Secured
    @Override
    public void makeFood() {
        System.out.println("Tasty");
    }
}
