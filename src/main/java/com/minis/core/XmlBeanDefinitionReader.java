package com.minis.core;


import com.minis.beans.BeanDefinition;
import org.dom4j.Element;

/**
 * @Author: 7up
 * @Date: 2023/7/4 14:12
 * @Description:将Resoure中解析的xml转换成BeanDefinition
 */
public class XmlBeanDefinitionReader {
    BeanFactory beanFactory;

    public XmlBeanDefinitionReader(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }
    public void loadBeanDefinitions(Resource resource){
        while (resource.hasNext()){
            Element element = (Element) resource.next();
            String beanId = element.attributeValue("id");
            String beanClassName = element.attributeValue("class");
            BeanDefinition beanDefinition = new BeanDefinition(beanId, beanClassName);
            this.beanFactory.registerBeanDefinition(beanDefinition);
        }
    }
}
