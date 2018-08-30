package com.db.quoters.model;

import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Component
@EqualsAndHashCode
public class TalkingRobot {

    @Autowired
    private List<Quoter> quoters;

    @PostConstruct
    private void talk(){
        quoters.forEach(Quoter::sayQuote);
    }

    @PreDestroy
    public void killAll() {
        System.out.println("killed");
    }
}
