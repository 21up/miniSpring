package com.minis.core.fourth_class;

import com.minis.BeansException;

/**
 * @author 7up
 */
public interface BeanPostProcessor {
    /**
     * Bean 初始化之前
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws
            BeansException;

    /**
     * Bean 初始化之后
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;

}
