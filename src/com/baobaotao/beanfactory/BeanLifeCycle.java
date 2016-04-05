package com.baobaotao.beanfactory;

import com.baobaotao.reflect.Car;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Created by 20150610 on 2016/4/5.
 */
public class BeanLifeCycle {
    private static void LifeCycleInBeanFactory(){
        Resource res = new ClassPathResource("com/baobaotao/beanfactory/beans.xml");
        BeanFactory bf = new XmlBeanFactory(res);
        //向容器中注册MyBeanPostProcessor后处理器
        ((ConfigurableBeanFactory)bf).addBeanPostProcessor(new MyBeanPostProcessor());
        ((ConfigurableBeanFactory)bf).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());
        //第一次从容器中获取car。将触发器实例化该Bean
        Car car1 = (Car) bf.getBean("car");
        car1.introduce();
        car1.setColor("红色");
        //第二次从容器中获取car直接从缓存池中获取
        Car car2 = (Car) bf.getBean("car");
        System.out.println("car1==car2:"+(car1==car2));
        //关闭容器
        ((XmlBeanFactory)bf).destroySingletons();


    }

    public static void main(String[] args) {
        LifeCycleInBeanFactory();
    }
}
