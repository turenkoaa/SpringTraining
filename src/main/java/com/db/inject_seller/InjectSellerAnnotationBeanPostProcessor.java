package com.db.inject_seller;

import lombok.SneakyThrows;
import org.reflections.ReflectionUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class InjectSellerAnnotationBeanPostProcessor implements BeanPostProcessor {


    @SneakyThrows
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        Class<?> clazz = bean.getClass();
        Set<Field> fields = ReflectionUtils.getAllFields(clazz);
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectSeller.class)){
                field.setAccessible(true);
                Seller seller = findNextMostEffectiveSeller()
                                .orElseThrow(() -> new IllegalStateException("No sellers for injection present."));
                field.set(bean, seller);
            }
        }

        return bean;
    }

    private int skip = 0;

    public Optional<Seller> findNextMostEffectiveSeller(){
        List<Seller> sellers = SellerCollection
                .getInstance()
                .getAllSellerSortedByTrades();
        Optional<Seller> first;
        first = sellers.stream().skip(skip).findFirst();
        skip++;

        return first;
    }

}
