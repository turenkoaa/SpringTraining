package com.db.quoters.benchmark_and_transactional;

import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Component
public class BenchmarkAnnotationBeanPostProcessor implements BeanPostProcessor {

    private Map<String, Class> proxyMap = new HashMap<>();

    @SneakyThrows
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        proxyMap.put(beanName, bean.getClass());
        return bean;
    }

    @SneakyThrows
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class type = proxyMap.get(beanName);
        return ClassOrMethodAnnotationWrapper.wrapWithProxy(
                    Benchmark.class,
                    bean,
                    type,
                    (o, method, args) -> invoke(method, args, type, bean));
    }

    @SneakyThrows
    private Object invoke(Method method, Object[] args, Class<?> type, Object t) {
        Method targetMethod = type.getMethod(method.getName(), method.getParameterTypes());
        Object retVal;
        if (type.isAnnotationPresent(Benchmark.class) || targetMethod.isAnnotationPresent(Benchmark.class)) {
            System.out.println("************** benchmark for method " + method.getName() + " started ***************");
            long start = System.nanoTime();
            retVal = method.invoke(t, args);
            long end = System.nanoTime();
            System.out.println("Method " + method.getName() + ": " + (end - start) + " nanoseconds");
            System.out.println("************** benchmark for method " + method.getName() + " finished ***************");

        } else {
            retVal = method.invoke(t, args);
        }
        return retVal;
    }
}
