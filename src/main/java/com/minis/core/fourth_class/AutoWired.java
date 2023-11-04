package com.minis.core.fourth_class;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: 7up
 * @Date: 2023/11/2 21:34
 * @Description:
 */
@Target(ElementType.FIELD)
@Retention((RetentionPolicy.RUNTIME))
public @interface AutoWired {
}
