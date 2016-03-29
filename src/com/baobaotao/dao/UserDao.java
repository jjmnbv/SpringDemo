package com.baobaotao.dao;

import com.baobaotao.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 20150610 on 2016/3/1.
 */
@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /***
     * @Description根据用户名和密码获取匹配的用户数。等于1表示用户名/密码正确。等于0表示用户名或密码错误
     * @param userName
     * @param password
     * @return int
     */
    public  int getMatchCount(String userName,String password){
        String sqlStr ="SELECT count(*) From t_user WHERE user_name=? and password=? ";
        return jdbcTemplate.queryForObject(sqlStr, new Object[]{userName, password}, Integer.class);

    }

    /***
     * @Description 根据用户名获取User对象
     * @param userName
     * @return User
     */
    public User findUserByUserName(final String userName){
        String sqlStr = "SELECT user_id,user_name,credits "+
                " FROM t_user WHERE  user_name =?";
        final User user = new User();
        jdbcTemplate.query(sqlStr, new Object[]{userName}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setUserId(resultSet.getInt("user_id"));
                user.setUserName(userName);
                user.setCredits(resultSet.getInt("credits"));
            }
        });
        return user;
    }

    /***
     * @Description 更新用户积分，最后登录IP以及最后登录时间
     * @param user
     */
    public  void updateLoginInfo(User user){
        String sqlStr = " UPDATE t_user SET last_visit=?,last_ip=?,credits=? "
                +" WHERE user_id=?";
        jdbcTemplate.update(sqlStr,new Object[]{user.getLastVisit(),user.getLastIp(),user.getCredits(),user.getUserId()});
    }
}
