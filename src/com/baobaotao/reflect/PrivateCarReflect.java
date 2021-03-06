package com.baobaotao.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by 20150610 on 2016/4/1.
 */
public class PrivateCarReflect {
    public static void main(String[] args) throws Throwable {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("com.baobaotao.reflect.PrivateCar");
        PrivateCar pcar = (PrivateCar) clazz.newInstance();
        Field colorFld = clazz.getDeclaredField("color");
        //取消Java语言访问检查以访问private变量
        colorFld.setAccessible(true);
        colorFld.set(pcar, "红色");
//        Method driveMtd = clazz.getDeclaredMethod("drive",(Class[])null);
        Method driveMtd = clazz.getDeclaredMethod("drive");
        //取消Java语言访问检查以访问protected方法
        driveMtd.setAccessible(true);
        driveMtd.invoke(pcar,(Object[])null);

    }
}
