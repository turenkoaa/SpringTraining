package com.db.quoters;

import com.db.quoters.aop.WithAspectConfig;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
@PropertySource("classpath:quotes.properties")
@Import(WithAspectConfig.class)
public class JavaConfig {
    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(JavaConfig.class);
    }
}
