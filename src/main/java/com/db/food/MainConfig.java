package com.db.food;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableAspectJAutoProxy
@EnableScheduling
public class MainConfig {
    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(MainConfig.class);
    }
}
