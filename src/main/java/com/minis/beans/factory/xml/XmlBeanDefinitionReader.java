package com.minis.beans.factory.xml;


import com.minis.beans.*;
import com.minis.beans.factory.support.ArgumentValue;
import com.minis.beans.factory.support.ArgumentValues;
import com.minis.beans.factory.support.BeanDefinition;
import com.minis.core.Resource;
import com.minis.beans.factory.support.SimpleBeanFactory;
import com.minis.core.fourth_class.AbstractBeanFactory;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 7up
 * @Date: 2023/7/4 14:12
 * @Description:将Resoure中解析的xml转换成BeanDefinition
 */
public class XmlBeanDefinitionReader {
    AbstractBeanFactory beanFactory;

    public XmlBeanDefinitionReader(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }
    public void loadBeanDefinitions(Resource resource){
        while (resource.hasNext()){
            Element element = (Element) resource.next();
            String beanId = element.attributeValue("id");
            String beanClassName = element.attributeValue("class");
            BeanDefinition beanDefinition = new BeanDefinition(beanId, beanClassName);
            List<Element> propertyElements = element.elements("property");
            //处理属性
            PropertyValues propertyValues = new PropertyValues();
            List<String> refs=new ArrayList<>();
            for (Element propertyElement : propertyElements) {
                String pType = propertyElement.attributeValue("type");
                String pName = propertyElement.attributeValue("name");
                String pValue = propertyElement.attributeValue("value");
                String pRef = propertyElement.attributeValue("ref");
                String pV="";
                boolean isRef=false;
                if (pValue!=null&&!pValue.equals("")){
                    isRef=false;
                    pV=pValue;
                }else if (pRef!=null && !pRef.equals("")){
                    isRef=true;
                    pV=pRef;
                    refs.add(pRef);
                }
                propertyValues.addPropertyValue(new PropertyValue(pName,pV,pType,isRef));
            }
            String[] refArray = refs.toArray(new String[0]);
            beanDefinition.setDependsOn(refArray);
            beanDefinition.setPropertyValues(propertyValues);
            //处理构造器参数
            ArgumentValues argumentValues = new ArgumentValues();
            List<Element> constructorElements = element.elements("constructor-arg");
            for (Element constructorElement : constructorElements) {
                String aType = constructorElement.attributeValue("type");
                String aName = constructorElement.attributeValue("name");
                String aValue = constructorElement.attributeValue("value");
                argumentValues.addArgumentValue(new ArgumentValue(aValue,aType,aName));
            }
            beanDefinition.setConstructorArgumentValues(argumentValues);
            this.beanFactory.registerBeanDefinition(beanId,beanDefinition);
        }
    }
}
