package com.db.quoters.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class QuoterAspect {

    @Pointcut("execution(* com.db.quoters..*.say*(..))")
    public void sayMethod(){}

    @Before("sayMethod()")
    public void beforeSayMethods(JoinPoint jp) {
        jp.getSignature().getName();
        String simpleName = jp.getTarget().getClass().getSimpleName();
        System.out.println("This is quote of " + simpleName + ": ");
    }
}
