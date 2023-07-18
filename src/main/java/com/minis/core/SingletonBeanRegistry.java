package com.minis.core;

/**
 * @Author: 7up
 * @Date: 2023/7/18 9:42
 * @Description:管理单例Bean
 */
public interface SingletonBeanRegistry {
    void registerSingletonBean(String beanName,Object singletonObject);
    Object getSingleton(String beanName);
    boolean containsSingleton(String beanName);
    String[] getSingletonNames();
}
