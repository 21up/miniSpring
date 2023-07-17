package com.minis.core;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.Iterator;

/**
 * @Author: 7up
 * @Date: 2023/7/4 14:02
 * @Description:解析Xml文件
 */
public class ClassPathXmlResource implements Resource{
    Document document;
    Element rootElement;
    Iterator<Element> elementIterator;

    public ClassPathXmlResource(String fileName) {
        SAXReader saxReader = new SAXReader();
        URL xmlPath = this.getClass().getClassLoader().getResource(fileName);
        //将配置文件装载进来，生成一个迭代器，可以用于遍历
        try {
            this.document=saxReader.read(xmlPath);
            this.rootElement=this.document.getRootElement();
            this.elementIterator=this.rootElement.elementIterator();
        }catch (Exception e){

        }
    }

    @Override
    public boolean hasNext() {
        return this.elementIterator.hasNext();
    }

    @Override
    public Object next() {
        return this.elementIterator.next();
    }

    @Override
    public void remove() {

    }
}
