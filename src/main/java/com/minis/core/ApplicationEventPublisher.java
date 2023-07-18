package com.minis.core;

/**
 * @Author: 7up
 * @Date: 2023/7/18 10:12
 * @Description:发布事件
 */
public interface ApplicationEventPublisher {
    void publishEvent(ApplicationEvent event);
}
