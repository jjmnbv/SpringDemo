package com.baobaotao.service;

import com.baobaotao.dao.LoginLogDao;
import com.baobaotao.dao.UserDao;
import com.baobaotao.domain.LoginLog;
import com.baobaotao.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 20150610 on 2016/3/1.
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private LoginLogDao loginLogDao;

    /**
     * @Description 用于检查用户名/密码的正确性
     * @param userName
     * @param password
     * @return
     */
    public boolean hasMatchUser(String userName,String password){
        int matchCount = userDao.getMatchCount(userName,password);
        return matchCount>0;
    }

    /**
     * @Description 以用户名加载User对象
     * @param userName
     * @return
     */
    public User findUserByUserName(String userName){
        return userDao.findUserByUserName(userName);
    }

    /**
     * @Description 在用户登录成功后调用，更新用户最后的登录时间和IP信息
     * 同时记录用户登录日志
     * @param user
     */
    public void loginSuccess(User user){
        user.setCredits(5+user.getCredits());
        LoginLog loginLog = new LoginLog();
        loginLog.setUserId(user.getUserId());
        loginLog.setIp(user.getLastIp());
        loginLog.setLoginDate(user.getLastVisit());
        userDao.updateLoginInfo(user);
        loginLogDao.insertLoginLog(loginLog);
    }

}
