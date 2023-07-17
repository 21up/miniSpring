package com.minis.core;

import com.minis.BeansException;
import com.minis.beans.BeanDefinition;

/**
 * @Author: 7up
 * @Date: 2023/7/4 14:32
 * @Description:集成BeanFactory,Resource,BeanReader
 */
public class ClassPathXmlApplicationContext implements BeanFactory{

    BeanFactory beanFactory;

    public ClassPathXmlApplicationContext(String fileName) {
        Resource resource = new ClassPathXmlResource(fileName);
        BeanFactory beanFactory = new SimpleBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions(resource);
        this.beanFactory=beanFactory;
    }

    @Override
    public Object getBean(String beanName) throws BeansException {
        return this.beanFactory.getBean(beanName);
    }

    @Override
    public void registerBeanDefinition(BeanDefinition beanDefinition) {
        this.beanFactory.registerBeanDefinition(beanDefinition);
    }
}
