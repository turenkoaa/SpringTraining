package com.db.quoters;

import com.db.quoters.model.TalkingRobot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.db.quoters");
        context.getBean(TalkingRobot.class).talk();

        context.close();
    }
}
