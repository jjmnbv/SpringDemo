package com.baobaotao.beanfactory;

import com.baobaotao.reflect.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 20150610 on 2016/4/6.
 */
public class ApplicationContextTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:com/baobaotao/beanfactory/beans.xml");
         Car car = (Car) applicationContext.getBean("car");
        car.introduce();
    }
}
