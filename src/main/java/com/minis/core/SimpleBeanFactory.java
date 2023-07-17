package com.minis.core;

import com.minis.BeansException;
import com.minis.beans.BeanDefinition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 7up
 * @Date: 2023/7/4 14:19
 * @Description:
 */
public class SimpleBeanFactory implements BeanFactory{
    private List<BeanDefinition> beanDefinitions=new ArrayList<>();
    private List<String> beanNames=new ArrayList<>();
    private Map<String,Object> singletons=new HashMap<>();

    public SimpleBeanFactory() {
    }

    @Override
    public Object getBean(String beanName) throws BeansException {
        //先尝试直接拿Bean实例
        Object singleton = singletons.get(beanName);
        //如果此时还没有这个Bean的实例，则获取它的定义来创建实例
        if (singleton==null){
            int i = beanNames.indexOf(beanName);
            if (i==-1){
                throw new BeansException();
            }else{
                BeanDefinition beanDefinition = beanDefinitions.get(i);
                try {
                    singleton = Class.forName(beanDefinition.getClassName()).newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                singletons.put(beanDefinition.getId(),singleton);
            }
        }
        return singleton;
    }

    @Override
    public void registerBeanDefinition(BeanDefinition beanDefinition) {
        this.beanDefinitions.add(beanDefinition);
        this.beanNames.add(beanDefinition.getId());
    }
}
