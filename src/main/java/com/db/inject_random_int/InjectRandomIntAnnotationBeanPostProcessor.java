package com.db.inject_random_int;

import lombok.SneakyThrows;
import org.reflections.ReflectionUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;
import java.util.Random;
import java.util.Set;

public class InjectRandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {

    private Random random = new Random();

    @Override
    @SneakyThrows
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> type = bean.getClass();
        Set<Field> fields = ReflectionUtils.getAllFields(type);
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectRandomInt.class)){
                InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
                field.setAccessible(true);
                int min = annotation.min();
                int max = annotation.max();
                int randomValue = min + random.nextInt(max - min) + 1;
                field.set(bean, randomValue);
            }
        }

        return bean;
    }
}
