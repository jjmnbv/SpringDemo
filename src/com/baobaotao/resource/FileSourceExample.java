package com.baobaotao.resource;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;


/**
 * Created by 20150610 on 2016/4/1.
 */
public class FileSourceExample {
    public static void main(String[] args) {
        try {
        String filePath = "D:\\think_in_java_workspaces\\IdeaProjects\\chapter1\\说明.txt";
        //使用系统文件类型方式加载文件
        Resource res1 = new FileSystemResource(filePath);
       // 使用类路径方式加载文件
//        Resource res2 = new ClassPathResource("chapter\\说明.txt");

            InputStream ins1 =res1.getInputStream();
//            InputStream ins2 =res2.getInputStream();
            System.out.println("res1:"+res1.getFilename());
//            System.out.println("res2:"+res2.getFilename());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
