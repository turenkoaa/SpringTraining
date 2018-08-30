package com.db.screen_saver;

import lombok.SneakyThrows;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.db.screen_saver");
        while (true){
            context.getBean(ColorFrame.class).moveToRandomLocation();
            Thread.sleep(70);
        }
    }
}
