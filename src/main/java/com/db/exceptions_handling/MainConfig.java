package com.db.exceptions_handling;

import com.db.exceptions_handling.business.FirstService;
import org.springframework.context.annotation.*;
import org.springframework.retry.annotation.EnableRetry;

@Configuration
@ComponentScan
@PropertySource("classpath:mail.properties")
@EnableAspectJAutoProxy
@EnableRetry
public class MainConfig {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        context.getBean(FirstService.class).doWork();
    }
}
