package com.db.food;

import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Random;

@Aspect
@Component
public class SecurityAspect {

    @SneakyThrows
    @Around("@annotation(Secured)")
    public Object handleSecuredMethod(ProceedingJoinPoint jp){
        if (new Random().nextBoolean()) {
            return jp.proceed();
        } else {
            throw new SecurityException("Not enabled method invocation");
        }
    }
}
