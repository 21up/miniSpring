package com.minis.beans;

/**
 * 值类
 */
public class PropertyValue {
    private final String name;
    private final Object value;
    private String type;
    private  boolean isRef;


    public PropertyValue(String name, Object value, String type) {
        this.name = name;
        this.value = value;
        this.type = type;
    }

    public PropertyValue(String name, Object value, String type, boolean isRef) {
        this.name = name;
        this.value = value;
        this.type = type;
        this.isRef = isRef;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isRef() {
        return isRef;
    }
}