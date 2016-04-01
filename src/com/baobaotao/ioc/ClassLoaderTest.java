package com.baobaotao.ioc;

/**
 * Created by 20150610 on 2016/3/31.
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println("current loader:"+loader);
        System.out.println("parent loader:"+loader.getParent());
        System.out.println("grantparent loader:"+loader.getParent().getParent());
    }
}
