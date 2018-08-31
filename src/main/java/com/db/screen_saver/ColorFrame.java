package com.db.screen_saver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.util.Random;


@Component
public class ColorFrame extends JFrame {

    private Random random = new Random();

    @Autowired
    private Color color;

    @PostConstruct
    public void init() {
        setSize(300, 300);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Scheduled(cron = "*/1 * * * * *")
    public void moveToRandomLocation(){
        setLocation(random.nextInt(1600), random.nextInt(900));
        getContentPane().setBackground(color);
        repaint();
    }
}
