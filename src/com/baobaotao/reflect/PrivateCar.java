package com.baobaotao.reflect;

/**
 * Created by 20150610 on 2016/4/1.
 */
public class PrivateCar {
    //private成员变量：使用传统的类实例调用方式，只能在本类中访问
    private String color;
    //protected方法：使用传统的类实例调用方式。只能在子类和本包中访问
    protected void drive(){
        System.out.println("drive private car!the color is:"+color);
    }
}
