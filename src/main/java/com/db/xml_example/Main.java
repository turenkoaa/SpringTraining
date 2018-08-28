package com.db.xml_example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

//        Quoter shakeSpearById = (Quoter) context.getBean("shakeSpear");
//        Quoter shakeSpearByName = (Quoter) context.getBean("shakeSpearName");
//        Quoter shakeSpearByClass = context.getBean(ShakeSpearQuoter.class);
//        Quoter terminatorByEqualIdAndName = (Quoter) context.getBean("terminator");
////        NoUniqueBeanDefinitionException: No qualifying bean of type 'com.db.xml_example.Quoter' available: expected single matching bean but found 2: shakeSpear,terminator
////        Quoter shakeSpearByInterface = context.getBean(Quoter.class);
//        Map<String, Quoter> quoterMap = context.getBeansOfType(Quoter.class);

        TalkingRobot talkingRobot = context.getBean(TalkingRobot.class);
        System.out.println(talkingRobot.getNumber());


    }
}
