package com.db.profiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service
public class DBService {

    @Autowired
    private Dao dao;

    @Scheduled(fixedDelay = 1000)
    public void doWork(){
        dao.saveAll();
    }
}
