package com.minis.core;

import com.minis.BeansException;
import com.minis.beans.BeanDefinition;

/**
 * @Author: 7up
 * @Date: 2023/7/4 13:57
 */
public interface BeanFactory {
    Object getBean(String beanName) throws BeansException;
    void registerBeanDefinition(BeanDefinition beanDefinition);
}
