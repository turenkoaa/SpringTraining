package com.db.exceptions_handling;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.stream.Collectors;

@Component
@Aspect
public class ExceptionHandlerAspect {

    private List<String> emails;
    private Map<Exception, Void> exceptions = new WeakHashMap<>();

    @Value("${emails}")
    public void setEmails(String string){
        emails = Arrays.stream(string.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    @Pointcut("execution(* com.db.exceptions_handling.business..*(..))")
    public void methodFromBusinessPackage() {}

    @AfterThrowing(
            value = "methodFromBusinessPackage()",
            throwing = "ex"
    )
    public void handleDBException(DataBaseRuntimeException ex){
        if (!exceptions.containsKey(ex)) {
            emails.forEach( e -> System.out.println("Send to " + e + ": " + ex.getMessage()));
            exceptions.put(ex, null);
        }
    }

}
