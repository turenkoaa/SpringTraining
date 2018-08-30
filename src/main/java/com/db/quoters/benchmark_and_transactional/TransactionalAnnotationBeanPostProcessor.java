package com.db.quoters.benchmark_and_transactional;

import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Component
public class TransactionalAnnotationBeanPostProcessor implements BeanPostProcessor {
    private Map<String, Class> proxyMap = new HashMap<>();

    @SneakyThrows
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        proxyMap.putIfAbsent(beanName, bean.getClass());
        return bean;
    }

    @SneakyThrows
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class type = proxyMap.get(beanName);
        return ClassOrMethodAnnotationWrapper.wrapWithProxy(
                Transactional.class,
                bean,
                type,
                (o, method, args) -> invoke(method, args, type,bean));
    }

    @SneakyThrows
    private Object invoke(Method method, Object[] args, Class<?> type, Object t) {
        Method targetMethod = type.getMethod(method.getName(), method.getParameterTypes());
        Object retVal;
        if (type.isAnnotationPresent(Benchmark.class) || targetMethod.isAnnotationPresent(Benchmark.class)) {
            System.out.println("************** transactional for method " + method.getName() + " started ***************");
            retVal = method.invoke(t, args);
            System.out.println("************** transactional for method " + method.getName() + " finished ***************");

        } else {
            retVal = method.invoke(t, args);
        }
        return retVal;
    }
}
