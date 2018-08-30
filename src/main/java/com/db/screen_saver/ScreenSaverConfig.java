package com.db.screen_saver;

import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.awt.*;
import java.util.Random;

@Configuration
@ComponentScan
@EnableScheduling
public class ScreenSaverConfig {

    private Random random = new Random();

    @Bean
    public ColorFrame colorFrame(){
        return new ColorFrame() {
            @Override
            public Color getColorPrototype() {
                return color();
            }
        };
    }

    @Bean
    @Scope("prototype")
    public Color color(){
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(ScreenSaverConfig.class);
    }
}
