package com.baobaotao.reflect;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * Created by 20150610 on 2016/3/30.
 */
public class Car implements BeanFactoryAware,BeanNameAware,InitializingBean,DisposableBean {
    private String brand;
    private String color;
    private int maxSpeed;

    private BeanFactory beanFactory;
    private String beanName;
    //默认构造函数
    public  Car(){
        System.out.println("调用Car()构造函数。");
    }
    //带参数的构造函数
    public Car(String brand, String color, int maxSpeed) {
        this.brand = brand;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }
    //未带参的方法
    public void introduce(){
        System.out.println("brand:"+brand+";color:"+color+";maxSpeed:"+maxSpeed);
    }

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {

        System.out.println("调用setBrand()设置属性。");
        this.brand = brand;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    //BeanFactoryAware接口方法
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("调用BeanFactoryAware.setBeanFactory().");
        this.beanFactory = beanFactory;
    }

    //BeanNameAware接口方法
    @Override
    public void setBeanName(String beanName) {
        System.out.println("调用BeanNameAware.setBeanName().");
        this.beanName = beanName;

    }

    //DisposableBean接口的方法
    @Override
    public void destroy() throws Exception {
        System.out.println("调用DisposableBean.destory().");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用InitalizingBean.afterPropertiesSet().");
    }

    public void myInit(){
        System.out.println("调用init-method指定的myInit(),将maxSpeed设置为240");
        this.maxSpeed=240;
    }
    public void myDestory(){
        System.out.println("调用destroy-method所指定的myDestory()");
    }
}
