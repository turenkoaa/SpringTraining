package com.db.xml_example;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import java.util.List;

@EqualsAndHashCode
public class TalkingRobot {

    @Getter
    @InjectRandomInt(min = 0, max = 10)
    private int number;

    @Setter
    private List<Quoter> quoters;

    @PostConstruct
    private void talk(){
        quoters.forEach(Quoter::sayQuote);
    }
}
