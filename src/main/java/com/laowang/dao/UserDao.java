package com.laowang.dao;

import com.laowang.entity.User;
import com.laowang.util.PageUtil;

import java.util.List;

/**
 * @author 隔壁老王
 */
public interface UserDao {
    /**
     * 添加用户
     * @param u 传递进来的用户
     * @return 返回1添加成功，0添加失败
     */
    int addUser(User u);

    int delAllUser(String uids);

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return 返回一个用户对象，不为null代表登陆成功
     */
    User loginUser(String username, String password);

    int getCountRows(String username);

    List<User> getUserByPage(PageUtil pu,String username);
}