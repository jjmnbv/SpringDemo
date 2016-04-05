package com.baobaotao.beanfactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;

/**
 * Created by 20150610 on 2016/4/5.
 */
public class MyInstantiationAwareBeanPostProcessor extends
        InstantiationAwareBeanPostProcessorAdapter{
    public Object postProcessBeforeInstantiation(Class beanClass,String beanName)throws BeansException{
    if ("car".equals(beanName)){
        System.out.println("InstantionAwareBeanPostProcessor.postProcessBeforeInstantiation");
    }
        return null;
    }
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {

        if ("car".equals(beanName)){
            System.out.println("InstantionAwareBeanPostProcessor.postProcessAfterInstantiation");
        }
        return true;
    }

    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        if ("car".equals(beanName)){
            System.out.println("InstantionAwareBeanPostProcessor.postProcessPropertyValues");
        }
        return pvs;
    }
}
