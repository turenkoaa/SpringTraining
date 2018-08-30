package com.db.screen_saver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.awt.*;
import java.util.Random;

@Configuration
@ComponentScan
public class ScreenSaverConfig {
    private Random random = new Random();

    @Bean
    @Scope("prototype")
    public Color color(){
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }
}
