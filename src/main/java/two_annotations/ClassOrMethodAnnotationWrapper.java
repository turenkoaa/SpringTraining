package two_annotations;

import org.reflections.ReflectionUtils;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

public class ClassOrMethodAnnotationWrapper {

    public static Object wrapWithProxy(Class annotation, Object t, Class<?> type, InvocationHandler invocationHandler) {

        boolean methodNeedTheBenchmark = ReflectionUtils.getAllMethods(type)
                .stream()
                .anyMatch(m -> m.isAnnotationPresent(annotation));

        if (type.isAnnotationPresent(annotation) || methodNeedTheBenchmark) {
            if (type.getInterfaces().length == 0){
                return Enhancer.create(type, invocationHandler);
            } else {
                return Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(), invocationHandler);
            }
        }

        return t;
    }
}
