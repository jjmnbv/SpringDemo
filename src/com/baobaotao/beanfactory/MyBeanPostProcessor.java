package com.baobaotao.beanfactory;

import com.baobaotao.reflect.Car;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by 20150610 on 2016/4/5.
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        if (s.equals("car")){
            Car car = (Car) o;
            if (car.getColor()==null){
                System.out.println("调用BeanPostProcessor.postProcessBeforeInitialization.color为空，设置为默认黑色");
                car.setColor("黑色");
            }
        }


        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {

        if (s.equals("car")){
            Car car = (Car) o;
            if (car.getMaxSpeed()>=200){
                System.out.println("调用BeanPostProcessor.postProcessAfterInitialization,将maxSpeend调整为200。");
                car.setMaxSpeed(200);
            }
        }
        return o;
    }
}
