package ru.spb.nkurasov.tester.generation;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

/**
 * Created by Nikita on 05.10.2016.
 */
public class GeneratedValueBeanPostProcessor implements BeanPostProcessor, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> cls = bean.getClass();
        while (cls.getSuperclass() != null) {
            for (Field field : cls.getDeclaredFields()) {
                if (field.isAnnotationPresent(GeneratedValue.class)) {
                    GeneratedValue annotation = field.getAnnotation(GeneratedValue.class);
                    ValueGenerator generator = applicationContext.getBean(annotation.generator(), ValueGenerator.class);
                    boolean accessible = field.isAccessible();
                    try {
                        field.setAccessible(true);
                        ReflectionUtils.setField(field, bean, generator.next());
                    } finally {
                        field.setAccessible(accessible);
                    }
                }
            }
            cls = cls.getSuperclass();
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
