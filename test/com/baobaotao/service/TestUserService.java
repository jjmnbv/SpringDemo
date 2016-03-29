package com.baobaotao.service;

import com.baobaotao.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by 20150610 on 2016/3/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class TestUserService {
    @Autowired
    private UserService userService;
    @Test
    public void hasMatchUser(){
        boolean b1 =userService.hasMatchUser("admin","maisui20150610");
        boolean b2 =userService.hasMatchUser("admin","123456");
//        System.out.println(b1);
//        System.out.println(b2);
        assertTrue(!b1);
        assertTrue(b2);
    }
    @Test
    public void findUserByUserName(){
        User user = userService.findUserByUserName("admin");
        assertEquals(user.getUserName(), "admin");
    }
    @Test
    public void loginSuccess(){
        User user = userService.findUserByUserName("admin");
        userService.loginSuccess(user);
    }
}
