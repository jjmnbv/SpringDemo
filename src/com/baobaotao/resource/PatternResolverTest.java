package com.baobaotao.resource;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * Created by 20150610 on 2016/4/5.
 */
public class PatternResolverTest {
    public static void main(String[] args)throws Throwable{
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        //加载所有类包com.baobaotao一下的以xml为后缀的资源
        Resource resources[] = resolver.getResources("classpath*:com/baobaotao/**/*.xml");
        for (Resource resource:resources){
            System.out.println(resource.getDescription());
        }
    }

}
