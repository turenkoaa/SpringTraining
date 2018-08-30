package com.db.screen_saver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

@Component
@Scope("prototype")
public class ColorFrame extends JFrame {
    @Autowired
    private Color color;
    private Random random = new Random();

    @PostConstruct
    public void init() {
        setSize(300, 300);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void moveToRandomLocation(){
        setLocation(random.nextInt(1600), random.nextInt(900));
        getContentPane().setBackground(color);
        repaint();
    }
}
