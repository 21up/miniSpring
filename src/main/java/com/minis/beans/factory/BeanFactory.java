package com.minis.beans.factory;

import com.minis.BeansException;

/**
 * @Author: 7up
 * @Date: 2023/7/4 13:57
 */
public interface BeanFactory {
    Object getBean(String beanName) throws BeansException;

    Boolean containsBean(String name);

    void registryBean(String beanName, Object obj);

    boolean isSingleton(String name);

    boolean isPrototype(String name);

    Class getType(String name);

}
