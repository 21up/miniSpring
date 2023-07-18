package com.minis.core;

import com.minis.BeansException;
import com.minis.beans.BeanDefinition;

/**
 * @Author: 7up
 * @Date: 2023/7/4 14:32
 * @Description:集成BeanFactory,Resource,BeanReader
 */
public class ClassPathXmlApplicationContext implements BeanFactory,ApplicationEventPublisher{

    SimpleBeanFactory beanFactory;

    public ClassPathXmlApplicationContext(String fileName) {
        Resource resource = new ClassPathXmlResource(fileName);
        SimpleBeanFactory beanFactory = new SimpleBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions(resource);
        this.beanFactory=beanFactory;
    }

    @Override
    public Object getBean(String beanName) throws BeansException {
        return this.beanFactory.getBean(beanName);
    }

    @Override
    public Boolean containsBean(String name) {
        return this.beanFactory.containsBean(name);
    }

    @Override
    public void registryBean(String beanName, Object obj) {
        this.beanFactory.registryBean(beanName,obj);
    }

    @Override
    public boolean isSingleton(String name) {
        return false;
    }

    @Override
    public boolean isPrototype(String name) {
        return false;
    }

    @Override
    public Class getType(String name) {
        return null;
    }

    public void registerBeanDefinition(BeanDefinition beanDefinition) {
        this.beanFactory.registerBeanDefinition(beanDefinition);
    }

    @Override
    public void publishEvent(ApplicationEvent event) {

    }
}
