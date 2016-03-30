package com.baobaotao.reflect;

/**
 * Created by 20150610 on 2016/3/30.
 */
public class Car {
    private String brand;
    private String color;
    private int maxSpeed;
    //默认构造函数
    public  Car(){}
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
}
