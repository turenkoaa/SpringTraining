package bean_factory_definitions;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;

public class BeanDefinitionAnalyzerBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            AbstractBeanDefinition beanDefinition = (AbstractBeanDefinition) beanFactory.getBeanDefinition(beanDefinitionName);
            String method = beanDefinition.getDestroyMethodName();
            if (method != null && beanDefinition.isPrototype()){
                throw new IllegalStateException("destroy method in the prototype");
            }
        }
    }
}
